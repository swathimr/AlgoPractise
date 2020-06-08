package Heap;

import java.util.*;

/**
 * O(n)
 * Bucket sort
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;

        Map<Character, Integer> map = new HashMap<>();
        for(char val:s.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        int max = Collections.max(map.values());

        List<List<Character>> bucket = new ArrayList<>();
        for(int i = 0;i <= max;i++) {
            bucket.add(new ArrayList<>());
        }

        for(Character key : map.keySet()) {
            int freq = map.get(key);
            bucket.get(freq).add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.size()-1; i>=0;i--) {
            for(char c:bucket.get(i)) {
                for(int j=0;j<i;j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
