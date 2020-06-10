package LinkedListQuestions;

/**
 * 3 cases case 1: insertVal is between 2 nodes e.g. 1->2->4, insert 3 condition: insertVal >= n.val
 * && insertVal <= n.next.val
 *
 * <p>case 2: insertVal is >= largest node value or <= smallest node value e.g. 1->2->4, insert 0 or
 * 1->2->4, insert 5 condition: n.next.val < n.val && (insertVal >= n.val || insertVal <=
 * n.next.val)
 *
 * <p>case 3: all the nodes in the tree have same value e.g. 1->1->1, insert 2 condition: n.next ==
 * head
 */
public class InsertIntoSortedCircularList {

    public ListNode insert(ListNode head, int insertVal) {
        ListNode newNode = new ListNode(insertVal, null);

        if(head == null) {
            newNode.next = newNode;// coz it circular point to itself
            return newNode;
        }

        ListNode n = head;

        while(true) {
            if((insertVal >= n.val && insertVal <= n.next.val) // case 1
                || (n.val>n.next.val && (insertVal >= n.val && insertVal <= n.next.val)) // case 2
                    || n.next == head // case 3
             ) {
                newNode.next = n.next;
                n.next = newNode;
                break;
            }
            n = n.next;
        }
        return head;
    }

}
