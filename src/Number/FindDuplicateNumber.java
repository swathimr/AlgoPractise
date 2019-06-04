package Number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        //app-1
         Set<Integer> seen = new HashSet<>();
         for(int val:nums){
             if(seen.contains(val))
                 return val;
             seen.add(val);
         }

        //app-2
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
