package stream;

import java.util.Comparator;
import java.util.PriorityQueue;

// time complexity O(logn) and space O(n)
public class MedianFromDataStream {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    /** initialize your data structure here. */
    public MedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }

    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }


}
