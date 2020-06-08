package LinkedListQuestions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Exactly same as daily temperature or next greater element
 * just add the elements to list and then same process
 */
public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];

        for(int i = list.size()-1;i>=0;i--) {
            while(!stack.isEmpty() && list.get(i) >= list.get(stack.peek()))
                stack.pop();

            int right = (stack.isEmpty()) ? 0 : list.get(stack.peek());
            result[i] = right;
            stack.push(i);
        }
        return result;
    }
}
