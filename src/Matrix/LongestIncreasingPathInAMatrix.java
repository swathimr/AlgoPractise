package Matrix;

public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for(int i =0 ;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                int length = dfs(matrix,cache,i,j,-1);
                max = Math.max(max,length);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int[][] cache, int i, int j, int prev) {
        if(i < 0 || i >= matrix.length || j<0 || j>=matrix[0].length)
            return 0;

        int curr = matrix[i][j];
        if(curr <= prev) return 0;

        if(cache[i][j] >0)
            return cache[i][j];
        else {
            int tempMax = 0;
            tempMax = Math.max(dfs(matrix,cache,i-1,j,curr),tempMax);
            tempMax = Math.max(dfs(matrix,cache,i+1,j,curr),tempMax);
            tempMax = Math.max(dfs(matrix,cache,i,j-1,curr),tempMax);
            tempMax = Math.max(dfs(matrix,cache,i,j+1,curr),tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }

    }
}
