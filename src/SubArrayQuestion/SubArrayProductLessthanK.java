package SubArrayQuestion;

/**
 * time complexity O(n) and space O(1)
 */
public class SubArrayProductLessthanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans= 0, left = 0; int product = 1;

        for(int i=0;i<nums.length;i++) {
            product *= nums[i];
            while(product >=k) {
                product /= nums[left++];
            }
            ans += i-left+1;
        }
        return ans;
    }


}
