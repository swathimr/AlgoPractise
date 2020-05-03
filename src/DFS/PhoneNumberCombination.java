package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(k^n)
//asked in branch
public class PhoneNumberCombination {

    public static void main(String args[]) {
        getCombinations("23");
    }


    public static List<String> getCombinations(String digits) {
        List<String> returnList = new ArrayList<>();

        if(digits.length() == 0)
            return returnList;

        Map<Integer, String> digitMap = new HashMap<Integer, String>();

        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");


        returnList.add("");

        for(int i=0;i<digits.length();i++) {
            String option = digitMap.get(digits.charAt(i)-'0');
            List<String> tempList= new ArrayList<>();

            for(int j=0;j<returnList.size();j++) {
                for(int k = 0 ;k< option.length();k++) {
                    tempList.add(new StringBuilder(returnList.get(j)).append(option.charAt(k)).toString());
                }
            }
            returnList.clear();
            returnList.addAll(tempList);

        }
        return returnList;
    }
}
