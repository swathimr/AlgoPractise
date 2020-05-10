package Strings;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        for(String val:words) {
            if(!ban.contains(val)) {
                map.put(val, map.getOrDefault(val,0)+1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }
}
