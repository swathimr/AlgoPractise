package BinaryTree;

public class LowestCommonAncestorOfBST {

    // iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(node!=null)
        {
            if(p.val>node.val && q.val>node.val){
                node = node.right;
            } else if(p.val<node.val && q.val<node.val) {
                node = node.left;
            }
            else {
                return node;
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
