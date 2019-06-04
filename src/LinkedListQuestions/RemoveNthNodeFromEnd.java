package LinkedListQuestions;

public class RemoveNthNodeFromEnd {

    //time complexity O(l)
    //space complexity 1
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        if(head==null)
            return head;

        for(int i = 0;i<n;i++){
            fast= fast.next;
        }

        //for input [1] and n = 1
        if(fast==null){
            head= head.next;
            return head;
        }

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next  = slow.next.next;

        return head;
    }
}
