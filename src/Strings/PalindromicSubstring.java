package Strings;

// time complexity O(n^2) and space O(1)
// basically for odd and even check and increment count
public class PalindromicSubstring {

    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++) {
            extendedPalindrome(s,i,i);
            extendedPalindrome(s,i,i+1);
        }
        return count;
    }

    public void extendedPalindrome(String s,int left, int right) {
        while(left >=0 && right<=s.length()-1 && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;right++;
        }
    }
}
