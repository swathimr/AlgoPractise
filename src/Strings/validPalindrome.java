package Strings;

public class validPalindrome {

  // time O(n) and space O(1)
  public boolean isPalindrome(String s) {

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
}
