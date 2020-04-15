package LinkedListQuestions;

// time O(1) and space O(n)
public class RandomPointerInALinkedList {

    public Node copyRandomList(Node head) {
        if(head == null)
            return head;

        // copy nodes
        Node p = head;
        while(p!=null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy the random pointer
        p = head;
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // split the nodes
        p = head;
        Node newHead = head.next;
        while(p != null) {
            Node temp = p.next;
            p.next = temp.next;
            if(temp.next !=null) {
                temp.next = temp.next.next;
            }
            p = p.next;
        }
        return newHead;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}