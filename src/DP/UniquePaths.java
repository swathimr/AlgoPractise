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

        for(int col = 1;col < m;col++) {
            for(int row = 1; row <n; row ++) {
                result[col][row] = result[col-1][row] + result [col] [row-1];
            }
        }

        return result[m-1][n-1];
    }

}
