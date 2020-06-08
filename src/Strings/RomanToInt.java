package Strings;

import java.util.HashMap;
import java.util.Map;

// time O(1) and space O(1)
// because max possible number can be 36666.since its fixed
public class RomanToInt {

    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;int i=0;
        while(i<s.length()) {
            if(i<s.length()-1) {
                String doubleSym = s.substring(i,i+2);
                if(map.containsKey(doubleSym)) {
                    sum+= map.get(doubleSym);
                    i+=2;
                    continue;
                }
            }
            String singleSym = s.substring(i,i+1);
            sum+=map.get(singleSym);
            i+=1;
        }
        return sum;
    }

}
