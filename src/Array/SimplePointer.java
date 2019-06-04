package Array;

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

    int i= 0;
    for(int j=1;j<nums.length;j++)
    {
      if(nums[i]!=nums[j])
      {
        i++;
        nums[i] = nums[j];
      }
    }
    return i+1;
  }

  /**
   * remove duplicates at-most 2 duplicates can be present
   * @param nums
   * @return
   */
  public int removeDuplicatesTwo(int[] nums) {
    if(nums.length ==0 || nums.length ==1 ||nums.length==2)
      return nums.length;
    int i= 1,j=2;
    while(j<nums.length) {
      if(nums[j]==nums[i] && nums[j]==nums[i-1])
        j++;
      else{
        i++;
        nums[i] =nums[j];
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
    int i = 0;
    for(int j = 0;j<nums.length;j++) {
      if(nums[j]!=val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

  /**
   *  Time complexity o(n) space o(1)
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    int i =0;
    for(int j=0 ;j<nums.length;j++) {
      if(nums[j]!=0) {
        nums[i] = nums[j];
        i++;
      }
    }
    while(i<nums.length) {
      nums[i] = 0;
      i++;
    }
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
