package Number;

// time is O(n) and space o(1)
public class ReverseInteger {

    public int reverse(int x) {
        int mod = 0;long reversed=0;
        boolean flag = false;

        //for negative
        if (x < 0) {
            x = 0-x;
            flag = true;
        }

        while(x>0) {
            mod = x%10;
            reversed = reversed*10+mod;
            x= x/10;
        }

        //for max integer return 0
        if(reversed>Integer.MAX_VALUE)
            return 0;

        if(flag)
            reversed = 0-reversed;

        return (int)reversed;
    }

}
