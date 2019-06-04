package HashSet;

import java.util.HashSet;

/**
 * time O(n)
 */
public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    if(nums.length==0)
      return 0;

    HashSet<Integer> set = new HashSet<Integer>();
    for(int val:nums)
      set.add(val);

    int max=1;
    for(int val:nums) {
      int count=1;
      int left = val-1;
      int right = val+1;

      while(set.contains(left)) {
        count++;
        set.remove(left);
        left--;
      }
      while(set.contains(right)) {
        count++;
        set.remove(right);
        right++;
      }
      max = Math.max(max,count);
    }

    return max;
  }
}
