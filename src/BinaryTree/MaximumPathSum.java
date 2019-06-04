package BinaryTree;

public class MaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root,max);
        return max[0];
    }

    public int calculateSum(TreeNode node,int[] max) {
        if(node==null)
            return 0;

        int left = calculateSum(node.left,max);
        int right = calculateSum(node.right,max);
        int current = Math.max(node.val,Math.max(node.val+left, node.val+right));

        max[0] = Math.max(max[0],Math.max(current,left+node.val+right));
        return current;
    }

}
