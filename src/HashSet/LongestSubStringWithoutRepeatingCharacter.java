package HashSet;

import java.util.HashSet;

/**
 * abcabcbb
 * sliding window technique
 * Time complexity O(n), worst case - O(2n)
 * Space O(k) - k is size of set
 *
 */
public class LongestSubStringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int i=0; int result = 1;
        for(int j=0;j<s.length();j++) {
            char c = s.charAt(j);
            if(!set.contains(c)) {
                set.add(c);
                result = Math.max(result,set.size());
            } else {
                while(i<j) {
                    if(s.charAt(i) == c) {
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return result;
    }
}
