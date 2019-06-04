package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right==null)
            {
                list.add(temp.val);
                stack.pop();
            }
            else{
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right=null;
                }
                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left=null;
                }
            }
        }
        return list;
    }

}
