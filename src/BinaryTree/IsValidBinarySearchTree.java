package BinaryTree;

public class IsValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode node, Integer lower,Integer upper) {
        if(node == null)
            return true;

        if(lower!= null && node.val <= lower)
            return false;
        if(upper!=null && node.val>= upper)
            return false;

        boolean ifLeftvalid = helper(node.left, lower, node.val);
        boolean ifRightvalid = helper(node.right, node.val, upper);

        if(!ifLeftvalid || !ifRightvalid)
            return false;

        return true;
    }

}
