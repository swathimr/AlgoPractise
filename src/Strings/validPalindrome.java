package Strings;

public class validPalindrome {

  public boolean isPalindrome(String str) {

    if(str==null ||str.length()==0)
      return true;

    int l=0,r=str.length()-1;
    str = str.toLowerCase();
    while(l<=r) {
      char left = str.charAt(l);
      char right = str.charAt(r);

      //if left contains any symbols or numbers
      if(!((left>='a' && left<='z') || (left>='0'&&left<='9')))
        l++;
        //if right contains any symbols or numbers
      else if(!((right>='a' && right<='z')|| (right>='0'&&right<='9')))
        r--;
      else if(left == right)
      {
        l++;r--;
      }
      else
        return false;
    }
    return true;
  }

}
