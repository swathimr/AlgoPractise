package Stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/** Example : lee(t(c)o)de)
 * add index ( to stack
 * if ) if stack is not empty pop
 * else add index to set. add remaining stack elements to set
 * append to string builder
 */
public class MinRemoveToMakeValidParenthesis {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> hs = new HashSet<>();

        char[] arr = s.toCharArray();
        for(int i = 0;i < arr.length; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    hs.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            hs.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length() ; i++) {
            if(!hs.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
