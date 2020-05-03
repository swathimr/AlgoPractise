package Array;

// time O(n) and space O(1)
// basically find min and for moves = subtract min from num
public class MinMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;
        for(int i=0;i<nums.length;i++) {
            min = Math.min(min,nums[i]);
        }

        for(int i=0;i<nums.length;i++) {
            moves += nums[i] - min;
        }
        return moves;
    }

}
