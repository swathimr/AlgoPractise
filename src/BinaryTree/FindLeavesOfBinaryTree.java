package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// DFS approach
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    public int helper( List<List<Integer>> result, TreeNode node) {
        if(node==null)
            return -1;

        int left = helper(result,node.left);
        int right = helper(result,node.right);

        int curr = 1+Math.max(left,right);

        if(result.size()<=curr)
            result.add(new ArrayList<Integer>());

        result.get(curr).add(node.val);

        return curr;
    }

}
