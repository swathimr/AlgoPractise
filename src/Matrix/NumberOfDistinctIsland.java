package Matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * using direction string to track
 */
public class NumberOfDistinctIsland {

    public static int numDistinctIslands(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j<height; j++) {
                StringBuilder sb = new StringBuilder();
                if(grid[i][j]!=0) {
                    dfs(grid,i,j,sb,"o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || j < 0 || i >=grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid,i-1,j,sb,"u");
        dfs(grid,i+1,j,sb,"d");
        dfs(grid,i,j-1,sb,"l");
        dfs(grid,i,j+1,sb,"r");
        sb.append("b"); // back
    }

  public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,1},
            {1,1,0,1,1}};
    numDistinctIslands(grid);
  }
}
