package Stack;

import java.util.Stack;

public class BasicCalculator1 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, result = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(i<s.length()-1 && Character.isDigit(s.charAt(i+1))) {
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                result += sign* sum;
            } else if(c=='+') {
                sign = 1;
            } else if(c=='-') {
                sign = -1;
            } else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

}
