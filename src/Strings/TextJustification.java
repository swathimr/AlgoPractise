package Strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        int len = 0;
        for(String word : words) {
            if(len+word.length()>maxWidth) {
                result.add(toString(tempList,maxWidth, len));
                len = 0;
                tempList = new ArrayList<>();
            }

            len+= word.length()+1;
            tempList.add(word);
        }

        if(tempList.size() > 0) {
            StringBuilder last = new StringBuilder(tempList.get(0));

            for(int i = 1;i < tempList.size();i++) {
                last.append(" ");
                last.append(tempList.get(i));
            }
            int spaces = maxWidth - last.length();
            for(int i=0;i<spaces;i++) {
                last.append(" ");
            }
            result.add(last.toString());
        }
        return result;
    }

    public String toString(List<String> tempList, int maxWidth, int len) {
        StringBuilder sb = new StringBuilder();
        if(tempList.size() == 1) {
            sb.append(tempList.get(0));
            for(int i=0;i<maxWidth - tempList.get(0).length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int textLen = len - tempList.size();
        int spaces = maxWidth - textLen;
        int avg = spaces / (tempList.size()-1);
        int extra = spaces % (tempList.size() - 1);
        for(int i = 0 ; i< tempList.size()-1; i++) {
            sb.append(tempList.get(i));
            for(int j = 0 ; j<avg; j++) {
                sb.append(" ");
            }
            if(extra-- > 0) {
                sb.append(" ");
            }
        }
        sb.append(tempList.get(tempList.size()-1));
        return sb.toString();
    }
}
