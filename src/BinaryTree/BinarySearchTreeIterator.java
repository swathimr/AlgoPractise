package BinaryTree;

import java.util.Stack;

public class BinarySearchTreeIterator {

  Stack<TreeNode> stack;

  public BinarySearchTreeIterator(TreeNode root) {
    stack = new Stack<>();
    while(root!=null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    int result = node.val;
    if(node.right!=null) {
      node = node.right;
      while(node!=null) {
        stack.push(node);
        node = node.left;
      }
    }
    return result;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

}
