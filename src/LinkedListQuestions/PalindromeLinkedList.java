package LinkedListQuestions;

public class PalindromeLinkedList {

    public static void main(String args[]) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }


    /**
     * move to middle of the list to split the list
     * create a new sublist, reverse the 2nd part of list
     * compare two lists
     * Time complexity o(n) space O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next==null)
            return true;

        // move to middle of the list
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;


        ListNode p1 = secondHead;
        ListNode p2 = p1.next;

        // reverse the second list
        while(p1!=null && p2!=null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secondHead.next =null;

        ListNode p = head;
        ListNode q = (p2==null?p1:p2);


        while(q!=null) {
            if(p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

}
