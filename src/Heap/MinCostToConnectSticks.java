package Heap;

import java.util.PriorityQueue;

// O(n log n)
public class MinCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int val: sticks)
            heap.offer(val);

        int sum = 0;
        while(heap.size() > 1) {
            int two = heap.poll() + heap.poll();
            sum += two;
            heap.offer(two);
        }
        return sum;
    }
}
