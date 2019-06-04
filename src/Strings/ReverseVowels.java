package Strings;

import java.util.ArrayList;

public class ReverseVowels {

    public String reverseVowels(String s) {
        ArrayList<Character> vowelList= new ArrayList<>();
        vowelList.add('A');
        vowelList.add('E');
        vowelList.add('I');
        vowelList.add('O');
        vowelList.add('U');
        vowelList.add('a');
        vowelList.add('e');
        vowelList.add('i');
        vowelList.add('o');
        vowelList.add('u');
        char[] inputArray = s.toCharArray();
        int i= 0,j= inputArray.length-1;

        while(i<j) {
            if(!vowelList.contains(inputArray[i])) {
                i++;
                continue;
            }
            if(!vowelList.contains(inputArray[j])) {
                j--;
                continue;
            }
            char temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;j--;
        }
        return new String(inputArray);
    }

}
