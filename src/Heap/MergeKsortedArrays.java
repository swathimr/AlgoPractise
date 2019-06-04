package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * time complexity O(nlog(k)) - n is no of elements and k is no of arrays
 * add to priority queue, keep adding it to queue until all the elements in the array are added to list
 */
public class MergeKsortedArrays {

    class ArrayContainer implements Comparable<ArrayContainer>{

        int[] arr;
        int index;

        public ArrayContainer(int[] arr,int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[index]-o.arr[o.index];
        }
    }

    public int[] mergeKSortedArray(int[][] arr) {
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>();
        int total = 0;

        for(int[] arrVal:arr) {
            queue.add(new ArrayContainer(arrVal,0));
            total+= arrVal.length;
        }

        int[] result = new int[total];
        int i = 0;

        while(!queue.isEmpty()) {
            ArrayContainer ac = queue.poll();
            result[i++] = ac.arr[ac.index];

            if(ac.index<ac.arr.length-1) {
                queue.add(new ArrayContainer(ac.arr,ac.index+1));
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };
        MergeKsortedArrays merge = new MergeKsortedArrays();
        int[] ret = merge.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(ret));
    }

}
