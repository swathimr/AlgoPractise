package LinkedListQuestions;

public class PalindromeLinkedList {


    /**
     * move to middle of the list to split the list
     * create a new sublist, reverse the 2nd part of list
     * compare two lists
     * Time complexity o(n) space O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode firstHalf = firstHalfEnd(head);
        ListNode secondHalfStart = reverseList(firstHalf.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while(result && p2 != null) {
            if(p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    public ListNode firstHalfEnd(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p1 = null,p2 = head;
        while(p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        return p1;
    }

}
