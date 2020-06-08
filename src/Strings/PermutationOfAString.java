package Strings;

public class PermutationOfAString {

    public void permute(String str, int left) {
        if(left == str.length()-1) {
            System.out.println(str);
        } else {
            for(int i=left;i<=str.length()-1;i++) {
                str = swap(left, i, str);
                permute(str, left+1);
                str = swap(left, i, str);
            }
        }
    }

    private String swap(int left, int right, String str) {
        char[] input = str.toCharArray();
        char temp = input[left];
        input[left] = input[right];
        input[right] = temp;
        return String.valueOf(input);

    }

  public static void main(String[] args) {
      String str = "ABC";
      int n = str.length();
      PermutationOfAString permutation = new PermutationOfAString();
      permutation.permute(str, 0);
  }
}

