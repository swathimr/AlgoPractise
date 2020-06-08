package DFS;

import java.util.*;

/**
 * Time complexity : O(n^3)
 * Size of recursion tree can go up to n^2. The creation of list takes n time.
 * Space complexity : O(n^3)
 * The depth of the recursion tree can go up to nn and each activation record can contains a string list of size nn.
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_break(s, wordDict, 0);
    }

    Map<Integer,List<String>> map = new HashMap<>();

    public List<String> word_break(String s, List<String> wordDict, int start) {
        if(map.containsKey(start))
            return map.get(start);

        List<String> result = new LinkedList<>();
        if(start == s.length())
            result.add("");

        for(int end = start+1; end <=s.length(); end++) {
            if(wordDict.contains(s.substring(start,end)))
            {
                List<String> list = word_break(s,wordDict, end);
                for(String val:list) {
                    result.add(s.substring(start,end) + (val.equals("") ? "" : " ") + val);
                }
            }
        }
        map.put(start, result);
        return result;
    }

    public static void main(String[] args){
        String s = "catsanddog";
        List<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        WordBreak2 wordBreak2 = new WordBreak2();
        wordBreak2.wordBreak(s,dict);
    }

}
