package DFS;

import java.util.*;

public class AlienDictionary {

    StringBuilder output  = new StringBuilder();
    Map<Character, List<Character>> adjList = new HashMap<>();
    Map<Character, Boolean> seenMap = new HashMap<>();

    public String alienOrder(String[] words) {

        // add all the words into map
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // if chara are not equal append to the list
        for(int i=0;i<words.length;i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word2.length() < word1.length() && word1.startsWith(word2))
                return "";

            int min = Math.min(word1.length(), word2.length());
            for(int j=0; j<min; j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word2.charAt(j)).add(word1.charAt(j));
                }
            }
        }

        // for each of the key dfs
        for(Character val : adjList.keySet()) {
            boolean result = dfs(val);
            if(!result)
                return "";
        }

        if(output.length() < adjList.size())
            return "";
        return output.toString();
    }

    // Return true if no cycles detected.
    public boolean dfs(Character val) {
        if(seenMap.containsKey(val))
            return seenMap.get(val);
        seenMap.put(val, false);
        for(Character c: adjList.get(val)) {
            boolean result = dfs(c);
            if(!result)
                return false;
        }
        seenMap.put(val, true);
        output.append(val);
        return true;
    }

}
