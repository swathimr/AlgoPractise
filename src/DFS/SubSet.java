package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//time compexity 2^n
public class SubSet {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for(int val : nums) {
      List<List<Integer>> temp = new ArrayList<>();
      for(List<Integer> sub : result) {
        List<Integer> a = new ArrayList<>(sub);
        a.add(val);
        temp.add(a);
      }
      result.addAll(temp);
    }
    return result;
  }

  public static void main(String args[]) {
    SubSet s= new SubSet();
    int[] input = {1,2,3};
    s.subsets(input);
  }

}
