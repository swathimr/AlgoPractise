package BinaryTree;

public class MaximumDepthOfBinaryTree {

    //recursive
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int max = Math.max(leftDepth,rightDepth);
        return max+1;
    }

    public int heightOfBinaryTree(TreeNode node)
    {
        if(node==null)
        {
            return -1;
        }
        else
        {
            return 1+Math.max(heightOfBinaryTree(node.left),heightOfBinaryTree(node.right));
        }
    }

}
