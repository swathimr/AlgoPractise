package LinkedListQuestions;

public class RemoveElementsFromLL {

    public ListNode removeElements(ListNode head, int val) {
        ListNode returnNode= new ListNode(0);
        returnNode.next = head;
        ListNode workerNode = returnNode;
        while(workerNode.next!=null) {
            if(workerNode.next.val==val) {
                workerNode.next = workerNode.next.next;
            }
            else {
                workerNode= workerNode.next;
            }
        }
        return returnNode.next;
    }
}
