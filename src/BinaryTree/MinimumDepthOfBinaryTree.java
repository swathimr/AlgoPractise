package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * same as right view and path sum combo
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return 0;

        queue.add(root);
        int depth = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return depth;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

}
