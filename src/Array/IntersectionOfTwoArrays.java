package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Time and space O(n)
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1= new HashSet<Integer>();
        HashSet<Integer> set2= new HashSet<Integer>();
        for(int val:nums1)
            set1.add(val);

        for(int val: nums2){
            if(set1.contains(val))
                set2.add(val);
        }

        int[] arr = new int[set2.size()];
        int i=0;
        for(int val:set2){
            arr[i++] = val;
        }

        return arr;
    }

    // time O(m+n) and space  O(min(m,n)
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums2) {
            if(map.get(num)!=null && map.get(num)>0) {
                map.put(num,map.get(num)-1);
                list.add(num);
            }
        }

        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
        }

        return ret;
    }

}
