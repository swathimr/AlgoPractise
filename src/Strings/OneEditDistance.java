package Strings;

public class OneEditDistance {

    /**
     * time complexity o(n)
     * space complexity o(1)
     */
    public boolean OneEditDistance(String s, String t) {
        int m = s.length(); int n = t.length();
        int i = 0,  j= 0;
        int count =0;

        if(Math.abs(m-n)>1){
            return false;
        }

        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)) {
                i++;j++;
            } else {
                count++;
                if(count>1)
                    return false;
                if(m>n)
                    i++;
                else if(n>m)
                    j++;
                else{
                    i++;
                    j++;
                }
            }
        }
        if(i<m||j<n){
            count++;
        }
        return count==1;
    }
}
