package Matrix;

// time  and space O(m*n)
// DFS approach
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] matrix =  {
                {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(matrix));
    }

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1') {
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1')
            return;

        grid[i][j] = 'X';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
