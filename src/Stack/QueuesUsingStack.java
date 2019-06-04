package Stack;

import java.util.Stack;

class QueuesUsingStack {

    Stack<Integer> stack;
    Stack<Integer> temp;

    /** Initialize your data structure here. */
    public QueuesUsingStack() {
        stack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(empty())
            stack.push(x);
        else {
            while(!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            temp.push(x);
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your QueuesUsingStack object will be instantiated and called as such:
 * QueuesUsingStack obj = new QueuesUsingStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
