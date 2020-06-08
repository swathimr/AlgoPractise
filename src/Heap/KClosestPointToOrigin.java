package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// time complexity O(klogn)
public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] left, int[] right) {
                return getDistance(right) - getDistance(left);
            }
        });

        for(int[] val: points) {
            heap.add(val);
            if(heap.size() > K) {
                heap.poll();
            }
        }

        int[][] result = new int[K][2];
        while(K > 0) {
            result[--K] = heap.poll();
        }
        return result;

    }

    public int getDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

}
