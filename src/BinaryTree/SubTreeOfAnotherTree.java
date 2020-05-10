package BinaryTree;

/**
 * Basically traverse left right and check equals
 * equals method checks for val eq and left and right equal
 * worst case time O(m∗n) and space O(n)
 */
public class SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public boolean equals(TreeNode x, TreeNode y) {
        if(x == null && y == null)
            return true;
        if(x == null || y==null)
            return false;
        return (x.val == y.val && equals(x.left,y.left) && equals(x.right,y.right));
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        return s!=null && (equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

}
