package Heap;

import java.util.PriorityQueue;

public class KthLargestInAStream {
     PriorityQueue<Integer> pq;
     int k;

    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue(k);
        for(int val: nums) {
            add(val);
        }

    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);
        }
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

}
