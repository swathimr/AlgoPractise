package Strings;

/** haystack problem
 * O((m-n)N) and space O(1)
 * We compute a substring of length L in a loop, which is executed (N - L) times.
 */
public class FindSubstringInAString {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(); int n = needle.length();

        for(int i = 0;i< m-n+1;i++) {
            if(haystack.substring(i,i+n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
