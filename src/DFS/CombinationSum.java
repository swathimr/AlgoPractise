package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates,0,target,0,temp,result);
        return result;
    }

    private void helper(int[] candidates, int start, int target, int sum, List<Integer> list,List<List<Integer>> result) {
        if(sum>target) {
            return;
        }

        if(sum==target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            helper(candidates, i,target,sum+candidates[i],list,result);
            list.remove(list.size()-1);
        }
    }


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
