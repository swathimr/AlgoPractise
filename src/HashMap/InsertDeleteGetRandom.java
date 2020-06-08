package HashMap;

import java.util.*;

public class InsertDeleteGetRandom {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    /** Get last element and index fo it from map
     *  Move last element to the element to be remvoed index
     *  remove element from map and list
     */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int lastElement = list.get(list.size()-1);
        int indx = map.get(val);

        list.set(indx, lastElement);
        map.put(lastElement,indx);

        list.remove(list.size()-1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
