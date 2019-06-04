package HashMap;

import java.util.HashMap;

/**
 * keep adding to sum
 * if k==sum, that index is max
 * calc diff, if map contains diff, recalculate max
 * if does not contain sum put sum,index to map
 */
public class MaximumSizeSubArraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0,sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];

            if(k==sum)
                max = Math.max(max,i+1);

            int difference = sum-k;
            if(map.containsKey(difference))
                max = Math.max(max,i-map.get(difference));

            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return max;
    }


}
