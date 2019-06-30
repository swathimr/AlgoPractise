package HashMap;

import java.util.HashMap;

/**
 * put every char in map and increment count if exists already
 * map size <=k, calculate result
 * else get count of i
 * count ->0 remove that char
 * else decrement the count of character and increment i
 * time complexity O(n) and space k, size of map
 */
public class LongestSubstringWithKUniqueCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        int i= 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int j=0;j<s.length();j++) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }

            if(map.size()<=k){
                result = Math.max(result,j-i+1);
            }
            else{
                while(map.size()>k){
                    char l = s.charAt(i);
                    int count = map.get(i);
                    if(count==1) {
                        map.remove(l);
                    } else {
                        map.put(l,count-1);
                    }
                    i++;
                }
            }

        }

        return result;

    }

}
