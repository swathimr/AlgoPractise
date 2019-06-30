package DFS;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    /**
     * time complexity O(N!)
     * swap the number
     * recursively call helper method
     * swap the numbers again to get the original result
     * if start reach end of list, add it to the list
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        helper(0,nums,result);
        return result;
    }

    public void helper(int start,int[] nums, List<List<Integer>> result) {

        if(start==nums.length-1) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int val:nums){
                list.add(val);
            }
            result.add(list);
            return;
        }

        for(int i=start;i<nums.length;i++) {
            swap(i,start,nums);
            helper(start+1,nums,result);
            swap(i,start,nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
