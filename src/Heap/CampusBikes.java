package Heap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * O(MN * Log(MN))
 * Sort them by distance, worker idx and bike index
 * calc distance and add to queue
 * Assign the bikes if set does not contain bike and result does not contain worker
 * Add the assigned bike to result
 */
public class CampusBikes {

    public int[] assignBikes(int[][] workers, int[][] bikes) {

        // order by Distance ASC, WorkerIndex ASC, BikeIndex ASC
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> {
            int cmp = Integer.compare(a[0],b[0]);

            if(cmp == 0) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[2],b[2]);
                }
                return Integer.compare(a[1],b[1]);
            }
            return cmp;
        });

        // loop through every possible pairs of bikes and people,
        // calculate their distance, and then throw it to the pq.
        for(int i=0;i<workers.length;i++) {
            int[] worker = workers[i];
            for(int j=0;j<bikes.length;j++) {
                int[] bike = bikes[j];
                int distance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                q.add(new int[]{distance, i,j});
            }
        }

        // init the result array with state of 'unvisited'.
        int[] res = new int[workers.length];
        Arrays.fill(res,-1);

        // assign the bikes.
        Set<Integer> bikeAssigned = new HashSet<>();
        while(bikeAssigned.size() < workers.length) {
            int[] workerBikePair = q.poll();
            if(res[workerBikePair[1]]==-1 && !bikeAssigned.contains(workerBikePair[2])) {
                res[workerBikePair[1]] = workerBikePair[2];
                bikeAssigned.add(workerBikePair[2]);
            }
        }
        return res;
    }
}
