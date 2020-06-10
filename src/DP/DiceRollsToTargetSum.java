package DP;

public class DiceRollsToTargetSum {

    public int numRollsToTarget(int d, int f, int target) {
        int[] prevdp = new int[target+1];
        prevdp[0] = 1;
        for(int i=1;i<=d;i++) {
            int[] currdp = new int[target+1];
            for(int j=1;j<=f;j++) {
                for(int k=j;k<=target;k++) {
                    currdp[k] = (currdp[k] + prevdp[k-j]) % 1000000007;
                }
            }
            prevdp = currdp;
        }
        return prevdp[target];
    }
}
