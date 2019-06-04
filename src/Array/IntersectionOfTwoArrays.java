package Array;

import java.util.HashSet;

//Time and space O(n)
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1= new HashSet<Integer>();
        HashSet<Integer> set2= new HashSet<Integer>();
        for(int val:nums1)
            set1.add(val);

        for(int val: nums2){
            if(set1.contains(val))
                set2.add(val);
        }

        int[] arr = new int[set2.size()];
        int i=0;
        for(int val:set2){
            arr[i++] = val;
        }

        return arr;
    }

}
