package BinaryTree;

import java.util.LinkedList;

public class InvertBinaryTree {

    //Iterative add to queue - level order traversal and swap nodes
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null)
            return root;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);

            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }
        return root;
    }


    //recursive
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode t =root.left;
        root.left= root.right;
        root.right = t;

        return root;
    }

}
