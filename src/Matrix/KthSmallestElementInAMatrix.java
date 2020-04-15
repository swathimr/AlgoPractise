package Matrix;

import java.util.PriorityQueue;

public class KthSmallestElementInAMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;

        int totalElem = row*column;
        if(k>totalElem || k==0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++) {
                pq.offer(matrix[i][j]);
            }
        }

        while(!pq.isEmpty()) {
            // System.out.println(totalElem - k);
            if (pq.size() ==  totalElem+1 - k) {
                break;
            }
            pq.poll();
        }
        return pq.poll();
    }
}
