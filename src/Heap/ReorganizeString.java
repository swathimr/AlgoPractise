package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * We store frequency of characters from the String in a Hashmap. Build a PriorityQueue(Max Heap),
 * pq that stores characters and their frequencies. We are maintaining a Priority Queue based on max
 * frequency. We are storing a previous entry which tells which was our last character processed.
 * The previous entry is important since we don't want 2 consecutive characters to be the same. Pop
 * an element from Priority Queue and add it to the final result. When we pop an element from the
 * queue, we have used 1 character, so we decrease the frequency count of that Entry's Character. If
 * the Character count of that Entry is >0 then we need to add that entry back to the Priority Queue
 * for further processing. The reason why we are adding prev to the heap and not curr, is because we
 * don't consecutive characters to be same. Because when we do maxHeap.poll(), then we are taking
 * out an Entry(char and it's frequency), so next time we remove an entry from the PriorityQueue, we
 * are going to get a different character entry for sure(which is the base condition: No consecutive
 * chars should be same) If length of resultant string and original string is equal then return the
 * resultant string, otherwise return an Empty String.
 */
public class ReorganizeString {

  public static void main(String[] args) {
      reorganizeString("aab");
  }

    public static String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char s : S.toCharArray()) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        Map.Entry<Character, Integer> prev = null;
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            result.append(curr.getKey());
            curr.setValue(curr.getValue()-1);

            if(prev!=null) {
                pq.add(prev);
            }
            if(curr.getValue() > 0) {
                prev = curr;
            } else {
                prev = null;
            }
        }
        return result.length() == S.length() ? result.toString() : "";
    }
}
