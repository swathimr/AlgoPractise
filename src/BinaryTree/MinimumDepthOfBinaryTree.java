package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * same as path sum
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> countList = new LinkedList<>();
        if(root==null)
            return 0;
        queue.add(root);
        countList.add(1);
        while(!queue.isEmpty()) {
            TreeNode node =queue.poll();
            int count = countList.poll();

            if(node.left==null && node.right==null)
                return count;

            if(node.left!=null)
            {
                queue.add(node.left);
                countList.add(count+1);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
                countList.add(count+1);
            }
        }
        return 0;
    }

}
