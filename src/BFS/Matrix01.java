package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * wherever 1 set -1, if 0 add to queue
 *
 * time and space O(rc)
 */
public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<m; i++) {
            for(int j=0; j<n;j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                } else {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int length = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for(int i=0;i<size;i++) {
                int[] curr = queue.poll();
                for(int[] dir:dirs) {
                    int ii = curr[0]+dir[0];
                    int jj = curr[1]+dir[1];
                    if(ii >= 0 && ii < matrix.length && jj >= 0 && jj < matrix[0].length)
                    {
                        if(matrix[ii][jj] == -1) {
                            matrix[ii][jj] = length;
                            queue.offer(new int[]{ii,jj});
                        }
                    }
                }
            }

        }
        return matrix;
    }

}
