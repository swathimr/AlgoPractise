package BinaryTree;

public class HeightOfBinaryTree {

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
