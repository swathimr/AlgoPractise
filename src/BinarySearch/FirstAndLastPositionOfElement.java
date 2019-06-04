package BinarySearch;

public class FirstAndLastPositionOfElement {

  public static int[] searchRange(int[] nums, int target) {
    int l=0,r = nums.length-1;

    while (l<r) {
      int mid =(l+r)/2;
      if(nums[mid] <target)
        l= mid+1;
      else
        r = mid;
    }

    int first= l;
    if(l<nums.length && nums[l]==target) {
      l=0;
      r=nums.length-1;
      while(l<r) {
        int mid = l+(r-l+1)/2;//(l+r)/2;
        if(nums[mid]>target)
          r =mid-1;
        else
          l=mid;
      }
      return new int[]{first, r};
    }

    return new int[]{-1,-1};
  }

  public static void main(String args[]) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    searchRange(nums,8);
  }

}
