package stream;

import java.util.LinkedList;

// time O(n)
public class MaximumSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i< nums.length;i++) {
         if(!queue.isEmpty() && queue.peek() < i-k+1){
             queue.poll();
         }

         while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]) {
             queue.pollLast();
         }

         queue.offer(i);
         if(i-k+1 >= 0){
             result[i-k+1] = nums[queue.peek()];
         }
        }
        return result;
    }

}
