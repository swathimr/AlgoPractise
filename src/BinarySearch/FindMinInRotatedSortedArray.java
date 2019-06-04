package BinarySearch;

/**
 * in any rotated sorted array right most should be lesser than left most
 * get middle -if middle <left, consider left part
 * else consider right part
 * if start <=end return start
 * time complexity O(logn)
 */
public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            //case1 - start<=end
            if(nums[start]<=nums[end])
                return nums[start];

            int m= (start+end)/2;
            //if mid>start consider second half of array
            if(nums[m]>=nums[start])
                start=m+1;
            else
                end=m;
        }
        return -1;
    }
}
