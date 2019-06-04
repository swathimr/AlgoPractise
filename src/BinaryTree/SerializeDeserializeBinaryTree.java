package BinaryTree;

import java.util.Stack;

/**
 * use in order traversal and keep appending to string builder
 * to deserilize split and recurse
 */
public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack =new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node!=null) {
                sb.append(node.val+",");
                stack.push(node.right);
                stack.push(node.left);
            }
            else
                sb.append("#,");
        }
        return sb.toString().substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;

        int[] t ={0};
        String[] arr = data.split(",");
        return helper(arr,t);
    }

    public TreeNode helper(String[] arr, int[] t) {
        if(arr[t[0]].equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
        t[0] = t[0]+1;
        root.left = helper(arr,t);
        t[0] = t[0]+1;
        root.right = helper(arr,t);

        return root;
    }

}
