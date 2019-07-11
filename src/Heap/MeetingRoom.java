package Heap;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;

//check if meeting end is lesser than next meeting start - true
public class MeetingRoom {

    public boolean canAttendMeetings(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        for(int i=0;i<intervals.length;i++) {
            if(intervals[i].end>intervals[i+1].start)
                return false;
        }

        return true;

    }

}
