package DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * O(M 2 ×N), where M is the length of words and N is the total number of words in the input word list
 */
public class WordLadder {

    public int ladderLength(String start, String end, List<String> dict) {

        if(!dict.contains(end))
            return 0;

        Set<String> dictSet = new HashSet<>(dict);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        int step = 1;
        HashSet<String> visited = new HashSet<>();

        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for(String word : beginSet) {
                char[] val = word.toCharArray();
                for(int i = 0; i< val.length; i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char old = val[i];
                        val[i] = c;
                        String tempWord = String.valueOf(val);
                        if(endSet.contains(tempWord))
                            return step+1;
                        if(!visited.contains(tempWord) && dictSet.contains(tempWord)) {
                            visited.add(tempWord);
                            temp.add(tempWord);
                        }
                        val[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }
}