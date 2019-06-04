package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null)
            return list;

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.add(n.val);
            if(n.right!=null)
                stack.push(n.right);
            if(n.left!=null)
                stack.push(n.left);
        }
        return list;
    }

}
