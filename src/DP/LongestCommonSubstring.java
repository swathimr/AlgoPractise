package DP;

public class LongestCommonSubstring {

    // dp[i-1][j-1] adjacent value
    private int getLongestCommonSubstring(String a, String b) {

        int max= 0 ;
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;i<n; j++) {
                if(a.charAt(i)==b.charAt(j)) {
                    if(i==0|| j==0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 1+dp[i-1][j-1];


                    if(dp[i][j]>max)
                        max= dp[i][j];
                }
            }
        }
        return max;

    }

}
