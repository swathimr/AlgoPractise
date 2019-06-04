package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n2)
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++) {
            int left =i+1;
            int right =nums.length-1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while(left<right) {

                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                if(nums[i]+nums[left]+nums[right]==0) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);
                    left++;
                    right--;
                }
                else if(nums[i]+nums[left]+nums[right]>0)
                    right--;
                else
                    left++;
            }
        }
        return list;
    }

}
