package Stack;

import java.util.Stack;

// time O(n) and space O(n) - size of the result
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids) {
            if(ast > 0)
                stack.push(ast);
            else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(ast))
                    stack.pop();

                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(ast);
                else if(stack.peek() + ast == 0)
                    stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
