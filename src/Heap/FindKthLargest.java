package Heap;

import java.util.PriorityQueue;

//Time complexity is O(nlog(k)). Space complexity is O(k)
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int val:nums) {
            queue.offer(val);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.peek();
    }
}
