package LinkedListQuestions;

// time O(n) and space O(1)
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;

        while(p1!=null && p2!=null && p2.next!=null) {
            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connectNode;
        return head;
    }
}
