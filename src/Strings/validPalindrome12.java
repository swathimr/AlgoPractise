package Strings;

public class validPalindrome12 {

  // time O(n) and space O(1)
  public boolean validPalindrome1(String s) {

    if (s == null || s.length() == 0) return true;

    s = s.toLowerCase();
    int i = 0, j = s.length() - 1;
    while (i < j) {
      while (i < j
          && !((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
              || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
        i++;
        continue;
      }

      while (i < j
          && !((s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
              || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
        j--;
        continue;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean validPalindrome2(String s) {
    int low = 0, high = s.length()-1;
    while(low<high) {
      if(s.charAt(low) == s.charAt(high)) {
        low++;
        high--;
      } else {
        return isPalindrome(low+1,high,s) || isPalindrome(low,high-1,s);
      }
    }
    return true;
  }

  public boolean isPalindrome(int low, int high, String str) {
    while(low<high) {
      if(str.charAt(low) != str.charAt(high))
        return false;
      low++;
      high--;
    }
    return true;
  }

}
