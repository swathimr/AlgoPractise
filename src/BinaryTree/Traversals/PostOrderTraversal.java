package BinaryTree.Traversals;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * same as preorder, except use linkedlist and add first the values
 */
public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if(node.left!=null) {
                stack.push(node.left);
            }
            if(node.right!=null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}
