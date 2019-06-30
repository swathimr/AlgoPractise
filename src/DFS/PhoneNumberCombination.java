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


    public static List<String> getCombinations(String phoneNum) {
        Map<Integer, String> digitMap = new HashMap<Integer, String>();
        digitMap.put(0, " ");
        digitMap.put(1, "");
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");

        List<String> returnList = new ArrayList<>();

        if(phoneNum == null || phoneNum.length() == 0) {
            return returnList;
        }

        returnList.add("");
        //n
        for(int i=0;i<phoneNum.length();i++) {

            String digitVal = digitMap.get(Integer.valueOf(phoneNum.charAt(i)-'0')); //abc
            ArrayList<String> tempList = new ArrayList<>();

            // loops the list for creating combination
            //??
            for(int j=0;j<returnList.size();j++) {
                // loop for iterating the digit map
                // k
                for(int k = 0; k< digitVal.length(); k++) {
                    tempList.add(new StringBuilder(returnList.get(j)).append(digitVal.charAt(k)).toString());
                }
            }

            if(Integer.valueOf(phoneNum.charAt(i)-'0')!=1) {
                returnList.clear();
            }
            returnList.addAll(tempList);
        }
        return returnList;
    }
}
