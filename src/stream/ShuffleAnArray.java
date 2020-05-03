package stream;

import java.util.Random;

// time and space O(n)
public class ShuffleAnArray {

    private int[] array;
    private int[] original;

    Random random = new Random();


    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int rand(int min, int max) {
        return random.nextInt(max-min) + min;
    }

    public void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<array.length;i++) {
            swapAt(i,rand(i, array.length));
        }
        return array;
    }

}
