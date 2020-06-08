package DP;

import java.util.*;

// same as word break 1
public class FindAllConcatenatedWordsInADict {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        List<String> result = new ArrayList<>();

        Set<String> preWords = new HashSet<>();
        for(String word : words) {
            if(wordBreak(word, preWords))
                result.add(word);
            preWords.add(word);
        }
        return result;
    }

    public boolean wordBreak(String s, Set<String> preWords) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        if (preWords.isEmpty()) return false;

        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && preWords.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
