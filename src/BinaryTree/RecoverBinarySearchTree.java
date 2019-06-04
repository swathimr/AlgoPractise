package BinaryTree;

public class RecoverBinarySearchTree {

  TreeNode first,second,pre;

  public void inOrder(TreeNode root) {
    if(root == null)
      return;

    inOrder(root.left);
    if(pre==null)
      pre=root;
    else {
      if(root.val<pre.val){
        if(first==null) {
          first = pre;
        }
        second = root;
      }
      pre = root;
    }

    inOrder(root.right);
  }

  public void recoverTree(TreeNode root) {
    if(root == null)
      return;

    inOrder(root);

    if(first!=null && second!=null) {
      int val = second.val;
      second.val = first.val;
      first.val = val;
    }
  }

}
