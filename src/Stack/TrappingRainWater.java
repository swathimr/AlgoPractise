package Stack;

import java.util.Stack;

// time O(n) and space O(n)
public class TrappingRainWater {

    public int trap(int[] height) {
       Stack<Integer> stack = new Stack<>();
       int ans = 0, current  = 0;
       while(current<height.length) {
           while(!stack.isEmpty() && height[current] > height[stack.peek()]) {
               int top = stack.peek();
               stack.pop();
               if(stack.isEmpty())
                   break;
               int distance = current - stack.peek() - 1;
               int boundedDistance = Math.min(height[current], height[stack.peek()]) - height[top];
               ans += distance * boundedDistance;
           }
           stack.push(current++);
       }
       return ans;
    }
}
