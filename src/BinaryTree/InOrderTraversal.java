package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * time and space O(n)
 * add root to stack
 * peek node, if left not null push to stack and set left link to null
 * else add to list, pop and check for right node and add to stack
 */
public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null)
            return list;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left=null;
            }
            else {
                list.add(temp.val);
                stack.pop();
                if(temp.right!=null)
                    stack.push(temp.right);
            }
        }
        return list;
    }
}
