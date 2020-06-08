package LinkedListQuestions;

// merge sort
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head,fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeList(l1,l2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(0);
        ListNode p = returnNode;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null) {
            p.next = l1;
        }
        if(l2!=null) {
            p.next = l2;
        }
        return returnNode.next;
    }

}
