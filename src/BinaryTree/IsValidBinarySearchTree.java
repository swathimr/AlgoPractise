package BinaryTree;

public class IsValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }

    public boolean helper(TreeNode node, double min, double max) {
        if(node==null)
            return true;

        if(node.val<=min || node.val>=max)
            return false;

        boolean isLeftBST = helper(node.left, min,node.val);
        boolean isRightBST = helper(node.right,node.val,max);

        if(!isLeftBST||!isRightBST)
            return false;

        return true;
    }

}
