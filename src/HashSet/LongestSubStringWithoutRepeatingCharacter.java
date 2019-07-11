package HashSet;

import java.util.HashSet;

/**
 * abcabcbb
 * sliding window technique
 * Time compexity O(n), worst case - O(2n)
 * Space O(k) - k is size of set
 *
 */
public class LongestSubStringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,n= s.length();
        int ans= 0 ;
        HashSet<Character> set = new HashSet<>();
        while(i<n &&j<n)
        {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, set.size());
            }
            else
                set.remove(s.charAt(i++));
        }
        return ans;
    }
}
