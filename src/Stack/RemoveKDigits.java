package Stack;

import java.util.LinkedList;

// time and space O(n)
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char val:num.toCharArray()) {
            while(stack.size() > 0 &&  k>0 && stack.peekLast()>val) {
                stack.removeLast();
                k--;
            }
            stack.addLast(val);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0;i<k;i++) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char val: stack) {
            if(leadingZero && val == '0')
                continue;
            leadingZero = false;
            sb.append(val);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
