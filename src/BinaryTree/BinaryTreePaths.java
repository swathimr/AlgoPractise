package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * keep adding node to string
 * if left and right is null, add it to the list
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        String sb="";
        ArrayList<String> result = new ArrayList<>();
        helper(root, result,sb);
        return result;
    }

    public void helper(TreeNode node,ArrayList<String> result,String s) {
        if(node==null)
            return;

        s = s+"->"+node.val;

        if(node.left==null && node.right==null)
        {
            result.add(s.substring(2));
            return;
        }

        if(node.left!=null)
            helper(node.left,result,s);

        if(node.right!=null)
            helper(node.right,result,s);

    }

}
