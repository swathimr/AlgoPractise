package Array;

import java.util.TreeMap;

/**
 * Basically add to treemap and
 * prev=floor and next = ceiling
 * if(prev end time <= start) && next >= end
 * O(nlogn) we search the event and then insert it in O(1)
 * and space O(n)
 */
public class MyCalendar {

    TreeMap<Integer,Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start,end);
            return true;
        }
        return false;
    }
}
