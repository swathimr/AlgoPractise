package Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    //time and space o(n)
    public boolean isValid(String s) {
        HashMap<Character,Character> mapVal = new HashMap<>();
        mapVal.put('(',')');
        mapVal.put('{','}');
        mapVal.put('[',']');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char val =s.charAt(i);
            if(mapVal.containsKey(val))
                stack.push(val);
            else if(mapVal.containsValue(val))
            {
                if(!stack.isEmpty() && mapVal.get(stack.peek())==val)
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
