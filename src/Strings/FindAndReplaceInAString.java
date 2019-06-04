package Strings;

import java.util.Map;
import java.util.TreeMap;

/**
 * Put the index and soruce/target in tree map
 * Then for every index, compare source and origin
 * Append the target to string builder
 */
public class FindAndReplaceInAString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        TreeMap<Integer,String[]> map = new TreeMap<>();
        for(int i=0;i<indexes.length;i++) {
            map.put(indexes[i],new String[]{sources[i], targets[i]});
        }
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for(Map.Entry<Integer, String[]> entry : map.entrySet()) {
            int startIndex = entry.getKey();
            int endIndex = startIndex +entry.getValue()[0].length();

            if(prev!=startIndex) {
                sb.append(S.substring(prev,startIndex));
            }

            String orig =S.substring(startIndex,endIndex);

            if(orig.equals(entry.getValue()[0])) {
                sb.append(entry.getValue()[1]);
                prev = endIndex;
            }
            else {
                sb.append(orig);
                prev = endIndex;
            }
        }
        if(prev<S.length()) {
            sb.append(S.substring(prev));
        }
        return sb.toString();
    }

}
