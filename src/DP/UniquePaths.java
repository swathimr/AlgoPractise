package DP;

import java.util.Arrays;

/**
 * Fill the array with 1
 * time complexity O(m*n) and space complexity o(m*n)
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        for(int[] arr:result) {
            Arrays.fill(arr,1);
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j<n; j ++) {
                result[i][j] = result[i-1][j] + result[i] [j-1];
            }
        }

        return result[m-1][n-1];
    }

}
