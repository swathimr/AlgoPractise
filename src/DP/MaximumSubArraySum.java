package DP;

//time complexity O(n) and space O(1)
public class MaximumSubArraySum {

    public int maxSubArray(int[] nums) {
        int sum = nums[0],result = nums[0];
        for(int i=1;i<nums.length;i++) {
            sum = Math.max(nums[i],sum+nums[i]);
            result =Math.max(sum,result);
        }
        return result;
    }

}
