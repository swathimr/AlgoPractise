package Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

  /**
   *  majority vote alogrithm
   *   time O(n) and space O(1)
   */
  public int majorityElement(int[] nums) {
    int count =0;
    int result =0;
    for(int val:nums) {
      if(count==0)
        result=val;

      count+= (result == val)?1:-1;
    }
    return result;
  }

  /**
   * appears more than n/3 times
   * @param nums
   * @return
   */
  public List<Integer> majorityElement2(int[] nums) {
    List<Integer> list=new ArrayList<>();
    HashMap<Integer,Integer> hm=new HashMap<>();
    for(int i=0;i<nums.length;i++)
    {
      if(hm.containsKey(nums[i]))
        hm.put(nums[i],hm.get(nums[i])+1);
      else
        hm.put(nums[i],1);
    }
    int l=nums.length;
    for(Map.Entry<Integer,Integer> map:hm.entrySet())
    {
      if(map.getValue()>l/3)
        list.add(map.getKey());
    }
    return list;
  }

}
