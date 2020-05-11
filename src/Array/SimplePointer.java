package Array;

import java.util.ArrayList;
import java.util.List;

public class SimplePointer {

  /** Time complexity o(n) space o(1)
   * if its same increment j
   * if not same need to copy, increment i and copy the val
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    if(nums.length == 0 || nums.length == 1)
      return nums.length;

    int j=1;int i=0;
    while(j<nums.length){
      if(nums[i]!=nums[j]) {
        i++;
        nums[i] = nums[j];
      }
      j++;
    }
    return i+1;
  }

  /**
   * remove duplicates at-most 2 duplicates can be present
   * @param nums
   * @return
   */
  public int removeDuplicatesTwo(int[] nums) {
    if(nums.length<=2)
      return nums.length;

    int i = 1,j=2;
    while(j<nums.length) {
      if(nums[i] == nums[j] && nums[j] == nums[i-1]) {
        j++;
      }
      else {
        i++;
        nums[i] = nums[j];
        j++;
      }
    }
    return i+1;
  }

  /**
   * Time complexity o(n) space o(1)
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    if(nums.length == 0)
      return nums.length;
    int i=0,j=0;
    while(j<nums.length) {
      if(nums[j]!=val) {
        nums[i]=nums[j];
        i++;
      }
      j++;
    }
    return i;
  }

  /**
   *  Time complexity o(n) space o(1)
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    int i=0,j=0;
    while(j<nums.length){
      if(nums[j]!=0){
        nums[i++]=nums[j];
      }
      j++;
    }
    while(i<nums.length){
      nums[i++]= 0;
    }
  }

  // time o(n) and space O(n)
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    result[nums.length-1] = 1;
    //holds the product of elements to the right of i
    for(int i=nums.length-2;i>=0;i--) {
      result[i] = result[i+1]*nums[i+1];
    }

    int left = 1;
    for(int i=0;i<nums.length;i++) {
      result[i] = result[i] * left;
      left =left*nums[i];
    }
    return result;
  }

  // array is sorted - use two pointers
  public int[] twoSum2(int[] numbers, int target) {
    int i=0,j = numbers.length-1;
    while(i<j) {
      int total = numbers[i]+numbers[j];
      if(total<target){
        i++;
      } else if(total>target) {
        j--;
      } else {
        return new int[]{i+1,j+1};
      }
    }
    return null;
  }
}
