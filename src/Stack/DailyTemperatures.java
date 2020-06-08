package Stack;

import java.util.Stack;

/**
 * time complexity O(n)
 * Basically store index in stack.
 * while current element is  > elem in stack, pop
 * calc res - 0 or stack.peek - i;
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = T.length-1;i>=0;i--) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}
