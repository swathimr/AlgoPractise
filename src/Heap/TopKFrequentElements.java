package Heap;

import java.util.*;

/*
Add to map
Add to heap with custom ordering
add to list and reverse
time O(Nlogk), n is number of words
space - O(n)
 */
public class TopKFrequentElements {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> countMap = new HashMap<>();
        for(String word: words) {
            countMap.put(word, countMap.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1,w2) -> countMap.get(w1).equals(countMap.get(w2)) ?
                        w2.compareTo(w1) : countMap.get(w1) - countMap.get(w2)
        );

        for(String word:countMap.keySet()) {
            heap.offer(word);
            if (heap.size()>k)
                heap.poll();
        }

        List<String> returnList = new ArrayList<>();
        while (!heap.isEmpty()) {
            returnList.add(heap.poll());
        }
        Collections.reverse(returnList);
        return returnList;
    }
}
