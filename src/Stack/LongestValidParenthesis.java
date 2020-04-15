package Stack;

import java.util.Stack;

/**
 * example )()())
 * time and space O(n)
 * when (, push to stack
 * when ), 1.pop from stack, 2. if empty insert index 3. max=i-stack.peek
 */
public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        int maxAns = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                maxAns = Math.max(maxAns,i-stack.peek());
            }
        }
        return maxAns;
    }
}
