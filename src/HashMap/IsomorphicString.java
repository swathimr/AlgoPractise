package HashMap;

import java.util.HashMap;

public class IsomorphicString {

    /**
     * Add in map and test for character
     * time complexity O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;

        HashMap<Character,Character> mapVal = new HashMap<Character,Character>();
        for(int i= 0 ;i<s.length();i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(mapVal.containsKey(s1))
            {
                if(mapVal.get(s1) == t1)
                    continue;
                return false;
            }
            else if(mapVal.containsValue(t1))
                return false;

            mapVal.put(s1,t1);
        }
        return true;
    }
}
