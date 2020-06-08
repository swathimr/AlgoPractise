package Stack;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(Math.max(x, max));
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.pop();
        Stack<Integer> buffer = new Stack<>();
        while(top() != max) {
            buffer.push(pop());
        }
        stack.pop();
        while(!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }
}
