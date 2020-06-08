package LinkedListQuestions;

/**
 * Find middle
 * Reverse second part of list
 * Merge two lists
 * time O(n) space O(1)
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null)
            return;

        ListNode slow = head, fast = head;

        while(fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow;
        while(curr!=null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        ListNode first = head, second = prev, tmp;
        while(second.next!=null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

}
