package DP;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //time complexity O(string length * dict size).
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] t =new boolean[s.length()+1];

        t[0] = true;
        for(int i=0;i<s.length();i++) {

            if(!t[i])
                continue;

            for(String val:wordDict) {
                int len = val.length();
                int end = len+i;

                if(end>s.length())
                    continue;

                if(t[end])
                    continue;

                if(s.substring(i,end).equals(val))
                    t[end]= true;
            }

        }
        return t[s.length()];

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
