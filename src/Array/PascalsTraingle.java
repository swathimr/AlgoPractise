package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle {

    /**
     * add 1. start from idx 2, add first and last 1's and add two nums in the middle
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;

        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);

        for(int i = 2; i<=numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int j=0;j<pre.size()-1;j++) {
                current.add(pre.get(j)+pre.get(j+1));
            }
            current.add(1);
            result.add(current);
            pre = current;
        }
        return result;
    }
}
