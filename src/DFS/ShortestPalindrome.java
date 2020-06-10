package DFS;

//time complexity o(n2)
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(j>=0) {
            if(s.charAt(i) == s.charAt(j))
                i++;
            j--;
        }

        if(i == s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String middle = shortestPalindrome(s.substring(0,i));

        return prefix+middle+suffix;
    }

}
