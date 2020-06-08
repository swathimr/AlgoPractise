package Array;

import java.util.Stack;

// asked in amazon
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        for(int i= nums.length-1 ; i>=0; i--) {
            stack.push(nums[i]);
        }

        // if not circular array just do this part
        int[] result = new int[nums.length];
        for(int i = nums.length-1; i >=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();

            int val = stack.isEmpty() ? -1 : stack.peek();
            result[i] = val;
            stack.push(nums[i]);
        }
        return result;
    }
}
