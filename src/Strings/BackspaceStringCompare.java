package Strings;

import java.util.Stack;

/**
 * time complexity O(m+n) and space O(m+n)
 */
public class BackspaceStringCompare {

  public boolean backspaceCompare(String S, String T) {
    return finalString(S).equals(finalString(T));
  }

  public String finalString(String s) {
    Stack<Character> stack = new Stack();
    for (char c:  s.toCharArray()) {
      if(c!='#')
        stack.push(c);
      else if(!stack.empty())
        stack.pop();
    }

    return String.valueOf(stack);
  }

}
