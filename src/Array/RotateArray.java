package Array;

/**
 * time o(n) space O(1)
 * reverse is the key
 *
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums ==null || k<0 ||nums.length==0)
            return;

        if(k>nums.length)
            k = k%nums.length;

        //length of the first part
        int a= nums.length-k;

        reverse(nums,0,a-1);
        reverse(nums,a,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public void reverse(int[] nums,int i,int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
