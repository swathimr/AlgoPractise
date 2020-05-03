package HashMap;

import java.util.HashMap;

public class TwoSum {

    // time complexity o(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i};
            else
                map.put(target-nums[i],i);
        }
        return new int[]{0,0};
    }

    public int[] twoSum2(int[] nums, int target) {
        int i = 0,j = nums.length -1;
        while(i<j) {
            int total = nums[i]+nums[j];
            if(total>target)
                j--;
            else if(total<target)
                i++;
            else
                return new int[]{i+1,j+1};
        }
        return null;
    }

}
