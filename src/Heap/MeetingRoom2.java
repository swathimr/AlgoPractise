package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the minimum number of rooms required to conduct these meetings
 * time complexity O(n log n) and space is O(n)
 * sort, add end time of first meeting to heap
 * compare every meeting start time >= by peeking into heap
 * if yes  poll it and add the updated end time to queue
 */
public class MeetingRoom2 {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        // sort by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2){
                return i1[0]-i2[0];
            }
        });

        PriorityQueue<Integer> allocator = new PriorityQueue(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        allocator.add(intervals[0][1]);

        for(int i=1; i < intervals.length ;i++) {

            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

}

