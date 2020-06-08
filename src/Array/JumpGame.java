package Array;

public class JumpGame {

    public boolean jumpGame1(int[] nums) {

        int maxPos = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(maxPos < i)
                return false;
            maxPos = Math.max(maxPos, i+nums[i]);
        }
        return true;
    }

    public int jump(int[] nums) {

        if(nums.length < 2)
            return 0;

        int steps = 1;
        int maxPos = nums[0];
        int maxSteps = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(maxSteps < i){
                steps++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i]+i);
        }
        return steps;
    }
}
