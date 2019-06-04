package BinarySearch;

import java.util.ArrayList;

/**
 * if num> last element add to list
 * else use binary search to set the index and num
 * return list size
 * time complexity O(log n)
 */
public class LongestIncreasingSubSequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : nums) {
            if(list.size()==0 || num>list.get(list.size()-1))
                list.add(num);
            else {
                int i =0,j =list.size()-1;
                while(i<j) {
                    int mid = (i+j)/2;
                    if(list.get(mid)<num)
                        i = mid+1;
                    else
                        j = mid;
                }
                list.set(j,num);
            }
        }
        return list.size();
    }

    public static void main(String args[]) {
        int[] nums = {9,1,3,7,5,6,20};
        lengthOfLIS(nums);
    }

}
