package BinaryTree;

public class sumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;

        return dfs(root,0,0);
    }

    public int dfs(TreeNode node,int sum, int num){
        if(node==null)
            return 0;

        num = num*10+node.val;

        if(node.left==null && node.right==null)
        {
            sum+=num;
            return sum;
        }

        sum = dfs(node.left,sum,num)+dfs(node.right,sum,num);
        return sum;
    }

}
