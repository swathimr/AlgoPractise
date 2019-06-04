package Number;

public class MissingNumber {

    // time complexity O(n) space complexity O(1)
    public int missingNumber(int[] nums) {
        int sum=0;
        int n= nums.length;
        for(int val:nums)
            sum+=val;

        return n*(n+1)/2-sum;
    }
}
