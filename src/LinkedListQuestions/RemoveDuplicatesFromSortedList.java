package LinkedListQuestions;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode p = head;
        while(p!=null && p.next!=null) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
            }
            else
                p = p.next;
        }
        return head;
    }

    // remove duplicates 2. if there is a duplicate remove that number
    public ListNode removeDuplicates2(ListNode head) {
        if (head == null)
            return head;
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return t.next;
    }
}
