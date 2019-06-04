package HashSet;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
            return false;

        HashSet<Integer> set =new HashSet<>();
        for(int val:nums) {
            if(!set.add(val))
                return true;
        }
        return false;
    }
}
