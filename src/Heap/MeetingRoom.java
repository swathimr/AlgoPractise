package Heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Time is O(nlogn) and space O(1)
 * sort the start time
 * compare each intervals end time to start time to see if they can make it to the meeting
 */
public class MeetingRoom {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0]-i2[0];
            }
        });

        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        return true;

    }

}
