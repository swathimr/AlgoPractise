package LinkedListQuestions;

public class SwapNodesInPairs {

    // O(n) time and space
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public ListNode swapPairsWithoutRecursion(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead = head.next, a=head,b=a.next,pre = null;
        while(a!=null && b!=null){
            a.next = b.next;
            b.next = a;
            if(pre!=null) pre.next = b;
            if(a.next==null) break;
            b = a.next.next;
            pre = a;
            a = a.next;
        }
        return newHead;
    }

}
