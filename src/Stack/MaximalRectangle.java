package Stack;

import java.util.Stack;

/**
 * same as largest rectangle area
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int[] dp = new int[width];
        int maxArea = 0;
        for(int i=0; i<height; i++) {
            for(int j=0;j<width;j++) {
                dp[j] = matrix[i][j]=='1' ? dp[j]+1 : 0;
            }
            maxArea = Math.max(maxArea,getMaxArea(dp));
        }
        return maxArea;
    }

    public int getMaxArea(int[] arr) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<arr.length;i++) {
            while(stack.peek()!=-1 && arr[stack.peek()] >= arr[i]) {
                maxArea = Math.max(maxArea, arr[stack.pop()] * (i - stack.peek()-1));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1) {
            maxArea = Math.max(maxArea, arr[stack.pop()] * (arr.length - stack.peek()-1));
        }
        return maxArea;
    }
}
