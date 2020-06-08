package OODesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> hits;
    Map<Integer,Integer> map;

    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new LinkedList<>();
        map = new HashMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp)+1);
        } else {
            update(timestamp);
            hits.add(timestamp);
            map.put(timestamp,1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        update(timestamp);
        int res = 0;
        for(int val:map.values()){
            res+=val;
        }
        return res;
    }

    private void update(int timestamp) {
        while(!hits.isEmpty() && hits.peek() <= timestamp-300){
            map.remove(hits.poll());
        }
    }


}
