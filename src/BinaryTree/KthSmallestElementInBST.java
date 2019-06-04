package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Inorder traversal
 * and stop after after kth element
 */
public class KthSmallestElementInBST {

    //iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);int result=0;

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left=null;
            }
            else {
                stack.pop();
                k--;
                if(k==0) {
                    result= temp.val;
                    break;
                }
                if(temp.right!=null)
                    stack.push(temp.right);
            }
        }
        return result;
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
