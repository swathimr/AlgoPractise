package LinkedListQuestions;

// 1->2->3->4->5
// time O(n) and space O(1)
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (count < k) {
            if (node == null) return head;
            node = node.next;
            count++;
        }

        ListNode pre = reverseKGroup(node, k);
        while (count > 0) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
            count = count - 1;
        }
        return pre;
    }

  public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode tmp = head;
      int count = 1; int val = 2;
      while(count < 5) {
          tmp.next = new ListNode(val++);
          tmp = tmp.next;
          count++;
      }
      reverseKGroup(head, 2);
  }
}
