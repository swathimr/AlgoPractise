package LinkedListQuestions;

// time complexity O(n)
// space complexity O(1)
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        head.next= null;

        while(p1!=null && p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }

}
