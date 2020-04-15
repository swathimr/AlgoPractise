package Strings;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        reverseWords(s.toCharArray());
    }

    public static void reverseWords(char[] s) {
        int i = 0;
        for(int j=0; j<s.length; j++) {
            if(s[j] == ' ') {
                reverse(s,i,j);
                i = j+1;
            }
        }
        reverse(s,i,s.length-1);
        reverse(s,0,s.length-1);
    }

    private static void reverse(char[] s,int i, int j) {
        while(i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
