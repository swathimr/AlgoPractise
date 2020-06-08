package Stack;

public class MinimumAddToMakeParenthesisValid {
    public int minAddToMakeValid(String S) {
        int right = 0, left = 0;
        for(char s : S.toCharArray()) {
            if(s == '(')
                right++;
            else if(right > 0)
                right--;
            else
                left++;
        }
        return right+left;
    }

}
