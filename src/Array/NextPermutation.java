package Array;

// time O(n) and space O(1)

/**
 * refer leetcode solution animation for understanding
 * basically move i and then fine j
 * swap and then reverse
 */
public class NextPermutation {

  public void nextPermutation(int[] nums) {

    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    int j = nums.length - 1;
    if (i >= 0) {
      while (j >= 0 && nums[j] <= nums[i]) {
        i--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public void reverse(int[] nums, int start) {
    int i = start;
    int j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
