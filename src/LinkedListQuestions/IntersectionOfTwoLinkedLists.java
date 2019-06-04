package LinkedListQuestions;

import java.util.HashSet;

/**
 * time complexity O(m+N)
 * space complexity o(m) or o(n)
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet val = new HashSet();
        boolean intersect  = false;

        if(headA == null) {
            return headA;
        }
        if(headB == null) {
            return headB;
        }

        while(headA!=null) {
            val.add(headA);
            headA = headA.next;
        }

        while(headB!=null && intersect!=true) {
            if(val.contains(headB)) {
                intersect = true;
            }
            else {
                headB = headB.next;
            }
        }
        return headB;
    }
}
