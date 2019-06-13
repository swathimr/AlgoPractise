package Stack;

/*  Implement stack using array
    Can hold any elements
    Basic operations push, pop
    max size, top
 */
public class StackUsingArray<E> {

    private E[] stackArr;
    private int top =0;
    private int maxSize;

    public StackUsingArray(int size){
        maxSize = size;
        stackArr = (E[]) new Object[maxSize];
    }

    public boolean push(E val) {
        if(top<maxSize){
            stackArr[top++] = val;
            return true;
        }
        return false;
    }

    public void pop() {
        if(top ==0) {
            System.out.println("Cannot pop from empty stack");
            return;
        }
        stackArr[top] = null;//prevent memory leaking
        top--;
    }

    public static void main(String[] args) {

        StackUsingArray stack = new StackUsingArray(11);
        stack.push(10);
        stack.push("world");

        System.out.println(stack.top);

        stack.pop();
        System.out.println(stack.top);

        stack.pop();
        System.out.println(stack.top);
    }


}