package Strings;

public class lexographicallyNextString {

  public static void main(String[] args) {
      String str = "samer";
      System.out.print(nextWord(str));
  }

    public static String nextWord(String str) {
      if(str == "")
          return str;

      int i= str.length()-1;
      while (str.charAt(i) == 'z' && i>=0) {
          i--;
      }

      if(i == -1) {
          str = str + 'a';
      } else {
          str = str.substring(0,i)+
                  (char)((int)(str.charAt(i)) + 1) +
                  str.substring(i + 1);
      }
      return str;

    }

}
