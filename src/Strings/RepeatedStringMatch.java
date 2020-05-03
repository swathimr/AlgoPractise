package Strings;

// time and space O(m+n)
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        while(sb.indexOf(B) ==-1) {
            if(sb.length()-A.length()>B.length())
                return -1;
            sb.append(A);
            count++;
        }
        return count;
    }
}
