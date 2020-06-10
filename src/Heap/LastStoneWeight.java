package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// same as min cost to connect sticks
// time O(nlog n) and space O(n)
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val:stones) {
            heap.add(val);
        }

        while(heap.size() > 1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if(stone1!=stone2) {
                heap.add(stone1-stone2);
            }
        }

        return heap.isEmpty() ? 0 : heap.remove();
    }
}
