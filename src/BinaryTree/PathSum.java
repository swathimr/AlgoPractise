package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * post order traversal
 * we maintain list to add both left sum values and right sum values separately
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> list = new LinkedList<>();
        if(root ==null)
            return false;

        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer sumVal = list.poll();
            if(node.left==null && node.right==null && sumVal==sum) {
                return true;
            }

            if(node.left!=null)
            {
                queue.add(node.left);
                list.add(sumVal+node.left.val);
            }
            if(node.right!=null) {
                queue.add(node.right);
                list.add(sumVal+node.right.val);
            }
        }
        return false;
    }
}
