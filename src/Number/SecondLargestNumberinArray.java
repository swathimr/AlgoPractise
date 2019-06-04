package Number;

public class SecondLargestNumberinArray {


  public int secondLarget(int[] arr){
    int first = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++) {
      if(arr[i]>first) {
        second = first;
        first = arr[i];
      }
    }
    return second;
  }
}
