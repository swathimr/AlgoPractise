package HashMap;

import java.util.HashMap;

/**
 * put string t in map
 * put s in map only if it exists in t, keep incrementing the count
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }

        //add t to map
        HashMap<Character,Integer> target =new HashMap<>();
        for(int i=0;i<t.length();i++) {
            int count = target.getOrDefault(t.charAt(i),0);
            target.put(t.charAt(i),count+1);
        }

        String result = "";
        int count = 0; int left = 0; int minLen = s.length()+1;
        //add s to map
        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(target.containsKey(c)) {
                if(map.containsKey(c)) {
                    if(map.get(c)<target.get(c))
                        count++;
                    map.put(c,map.get(c)+1);
                } else {
                    map.put(c, 1);
                    count++;
                }
            }

            if(count==t.length()){
                char leftVal = s.charAt(left);
                while(!map.containsKey(leftVal) || map.get(leftVal)>target.get(leftVal)) {
                    if(map.containsKey(leftVal) && map.get(leftVal)>target.get(leftVal))
                        map.put(leftVal,map.get(leftVal)-1);
                    left++;
                    leftVal = s.charAt(left);
                }
                if(i-left+1<minLen) {
                    result = s.substring(left,i+1);
                    minLen = i-left+1;
                }
            }
        }
        return result;
    }

}
