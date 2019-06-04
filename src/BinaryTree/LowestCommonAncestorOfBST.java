package BinaryTree;

public class LowestCommonAncestorOfBST {

    // iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t = root;
        while(t!=null)
        {
            if(p.val>t.val && q.val>t.val){
                t = t.right;
            } else if(p.val<t.val && q.val<t.val) {
                t = t.left;
            }
            else {
                return t;
            }
        }
        return null;
    }

    //recursion
    public TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t = root;
        if (p.val > t.val && q.val > t.val) {
            return lowestCommonAncestorR(t.right, p, q);
        } else if (p.val < t.val && q.val < t.val) {
            return lowestCommonAncestorR(t.left, p, q);
        } else {
            return t;
        }
    }
}
