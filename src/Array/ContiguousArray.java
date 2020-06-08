package Array;

import java.util.HashMap;

/**
 * for every 1 add 1 to count , for 0 subtract 1 from count
 * put count and index into map
 * if it contains count already calculate max len, i - map.get(count)
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0, maxLen = 0;
        for(int i=0;i < nums.length;i++) {
            count+= nums[i]==1 ? 1: -1;
            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

}
