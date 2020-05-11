package LinkedListQuestions;

public class RemoveElementsFromLL {

    public ListNode removeElements(ListNode head, int val) {
        ListNode returnNode= new ListNode(0);
        returnNode.next = head;
        ListNode p = returnNode;
        while(p.next!=null) {
            if(p.next.val==val) {
                p.next = p.next.next;
            }
            else {
                p= p.next;
            }
        }
        return returnNode.next;
    }
}
