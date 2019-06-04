package LinkedListQuestions;

import java.util.LinkedList;

class StackUsingQueues {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(empty()){
            queue1.offer(x);
        }
        else{
            if(queue1.size()>0) {
                queue2.offer(x);
                int size = queue1.size();
                while(size>0) {
                    queue2.offer(queue1.poll());
                    size--;
                }
            }
            else if(queue2.size()>0) {
                queue1.offer(x);
                int size = queue2.size();
                while(size>0) {
                    queue1.offer(queue2.poll());
                    size--;
                }
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int returnVal = 0;
        if(queue1.size()>0) {
            returnVal = queue1.poll();
        }
        else if(queue2.size()>0) {
            returnVal = queue2.poll();
        }
        return returnVal;

    }

    /** Get the top element. */
    public int top() {
        int returnVal = 0;
        if(queue1.size()>0)
            returnVal =  queue1.peek();
        else if(queue2.size()>0)
            returnVal =  queue2.peek();
        return returnVal;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */