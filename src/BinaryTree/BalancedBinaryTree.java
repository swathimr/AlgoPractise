package BinaryTree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(getHeight(root)==-1)
            return false;
        return true;
    }

    public int getHeight(TreeNode node) {
        if(node==null)
            return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if(left==-1||right==-1)
            return -1;

        if(Math.abs(left-right)>1)
            return -1;

        return 1+Math.max(left,right);
    }

}
