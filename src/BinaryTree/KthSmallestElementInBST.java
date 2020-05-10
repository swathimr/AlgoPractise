package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Inorder traversal
 * and stop after after kth element
 */
public class KthSmallestElementInBST {

    //inorder and return when k is 0
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || curr!=null) {
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(--k == 0)
                return curr.val;
            curr = curr.right;

        }
        return 0;
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallestRecursion(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

}
