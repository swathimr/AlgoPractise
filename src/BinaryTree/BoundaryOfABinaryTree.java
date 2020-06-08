package BinaryTree;

import java.util.ArrayList;
import java.util.List;

// time O(n)
public class BoundaryOfABinaryTree {

    List<Integer> list = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return list;

        list.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return list;
    }

    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        list.add(root.val);
        if(root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    public void rightBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        list.add(root.val);
    }

    public void leaves(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

}
