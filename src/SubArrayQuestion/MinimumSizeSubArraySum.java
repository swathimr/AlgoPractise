package SubArrayQuestion;

public class MinimumSizeSubArraySum {

    /**
     * i+1-left is the size of subarray
     * time complexity o(n) space complexity O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int sum =0;
        int left = 0;

        for(int i=0;i<nums.length;i++) {
            sum +=nums[i];
            while(sum>=s) {
                answer = Math.min(answer,i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return answer!=Integer.MAX_VALUE?answer:0;
    }

}
