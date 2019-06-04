package DFS;

import java.util.HashMap;

// similar to isomorphic string
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length!=pattern.length())
            return false;

        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            Character c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(arr[i]))
                    return false;
            } else if(map.containsValue(arr[i]))
            {
                return false;
            }
            map.put(c,arr[i]);
        }
        return true;
    }
}
