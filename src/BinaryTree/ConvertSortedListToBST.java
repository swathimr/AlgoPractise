package BinaryTree;

import LinkedListQuestions.ListNode;

// time complexity O(n logn) since you have to traverse the sub-list in each recursive call.
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
