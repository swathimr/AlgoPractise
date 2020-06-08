package HashSet;

import java.util.Arrays;
import java.util.HashSet;

// time and space is O(1)

/**
 * time depends on how many time we ran the cycle to find the loop
 * So regardless of N, our space is bounded by the length of the cell (and not by N, i.e input).
 * Hence the space complexity is O(1) i.e with increasing N, our hashset space doesn't increase (it stays constant)
 */
public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        HashSet<String> set = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;
        for(int i=0;i<N;i++) {
            int[] next = getNextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key))
            {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle) {
            N%=cycle;
            for(int i=0;i<N;i++) {
                cells = getNextDay(cells);
            }
        }
        return cells;
    }

    public int[] getNextDay(int[] cells) {
        int[] temp = new int[cells.length];
        for(int i=1;i<temp.length-1;i++) {
            temp[i] = cells[i-1]==cells[i+1] ? 1: 0;
        }
        return temp;
    }

}
