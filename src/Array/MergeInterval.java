package Array;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * use comparator and sort the interval
 * O(nlogn)
 */

public class MergeInterval {
//  public List<Interval> merge(List<Interval> intervals)  {
//    if(intervals==null || intervals.size()<1)
//      return intervals;
//
//    List<Interval> list = new ArrayList<>();
//    Collections.sort(intervals,Comparator.comparing((Interval it)->it.start));
//
//    Interval initial = intervals.get(0);
//    for(int i=1;i<intervals.size();i++){
//      Interval next = intervals.get(i);
//      if(next.start<=initial.end)
//        initial.end = Math.max(next.end,initial.end);
//      else {
//        list.add(next);
//        initial = next;
//      }
//
//    }
//    list.add(initial);
//    return list;
//  }

}
