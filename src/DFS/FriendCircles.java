package DFS;

/**
 * dfs approach
 * O(n2) time and space O(n)
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for(int i = 0; i<M.length;i++) {
            if(visited[i] == 0) {
                dfs(visited, i, M);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[] visited, int i, int[][] M) {
        for(int j = 0; j < M.length; j++) {
            if(visited[j] == 0 && M[i][j] ==1){
                visited[j] = 1;
                dfs(visited, j, M);
            }
        }
    }
}
