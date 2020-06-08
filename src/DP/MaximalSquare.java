package DP;

// time and space O(mn)
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(matrix[i-1][j-1] == '1') {
                    // this would help us to maintain the largest square formed
                    // before elem, ad elemnet, up element. get min to get the largest square
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result* result;
    }
}
