package BinaryTree;

public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if(root==p||root==q)
            return root;

        TreeNode l = lowestCommonAncestor(root.left, p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        // if both of the above calls are non null,
        // then one key is present in one subtree and other in other so this node is LCA
        //other wise check if left or right subtree is LCA
        if(l!=null && r!=null)
            return root;
        else if(l==null && r==null)
            return null;
        else
            return l==null?r:l;
    }

}
