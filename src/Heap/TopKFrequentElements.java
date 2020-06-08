package Heap;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for(int val: nums)
            countMap.put(val, countMap.getOrDefault(val,0)+1);

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> countMap.get(n1) - countMap.get(n2));

        for(int num:countMap.keySet()) {
            heap.offer(num);
            if(heap.size()>k)
                heap.poll();
        }

        List<Integer> list = new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(heap.poll());
        }
        Collections.reverse(list);
        int[] array = list.stream().mapToInt(i -> i).toArray();
        return array;

    }
}
