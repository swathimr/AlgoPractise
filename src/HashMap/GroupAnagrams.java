package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// time complexity O(n*m)
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String val:strs) {
            char[] arr =new char[26];
            for(int i=0;i<val.length();i++) {
                arr[val.charAt(i)-'a']++;
            }
            String word = new String(arr);
            if(map.containsKey(word)) {
                map.get(word).add(val);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(val);
                map.put(word,list);
            }
        }

        result.addAll(map.values());
        return result;
    }

}
