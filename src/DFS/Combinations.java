package DFS;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    //combinations

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(k>n || n<0)
            return result;

        helper(k,n,1,result, list);
        return result;
    }

    public void helper(int k, int n,int start, List<List<Integer>> result, List<Integer> list) {
        if(list.size()==k)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start;i<=n;i++) {
            list.add(i);
            helper(k,n,i+1, result,list);
            list.remove(list.size()-1);
        }
    }
}
