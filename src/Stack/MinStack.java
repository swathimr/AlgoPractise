package Stack;

import java.util.Stack;

// time O(1) and space O(n)
public class MinStack {

    Stack<int[]> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new int[]{x,x});
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[]{x,Math.min(currentMin,x)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
