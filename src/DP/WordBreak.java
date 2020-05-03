package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //time complexity O(n^2) ans space O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp =new boolean[s.length()+1];
        Set<String> dictSet = new HashSet<>(wordDict);
        dp[0] = true; // initial state

        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++){
                if(dp[j] && dictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    // when dict is too large , and time complexity is o(n^2)
    public boolean wordBreakSimple(String s, Set<String> dict) {
        int[] pos =new int[s.length()+1];
        Arrays.fill(pos,-1);
        pos[0] = 0;

        for(int i=0;i<s.length();i++) {
            if(pos[i]!=-1) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (dict.contains(sub))
                        pos[j] = i;
                }
            }
        }
        return pos[s.length()]!=-1;
    }

}
