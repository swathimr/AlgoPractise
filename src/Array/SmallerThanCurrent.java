package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);

        Map<Integer,Integer> map = new HashMap<>();

        for(int i= 0; i<nums.length; i++) {
            map.putIfAbsent(clone[i], i);
        }

        for(int i=0;i < nums.length; i++) {
            clone[i] = map.get(nums[i]);
        }

        return clone;
    }

}
