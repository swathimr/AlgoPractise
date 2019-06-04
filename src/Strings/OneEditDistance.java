package Strings;

public class OneEditDistance {

    /**
     * time complexity o(n)
     * space complexity o(1)
     */
    public boolean OneEditDistance(String s, String t) {
        int count =0;
        int m = s.length(),n = t.length();
        int i=0,j=0;
        if(Math.abs(m-n)>1)
            return false;

        while(i<m && j<n) {

            if(s.charAt(i)==t.charAt(j)) {
                i++;j++;
            }
            else { //if char dont match
                count++; //increment count

                if(count>1)
                    return false;

                //if length of 1 string is more, remove char. so move ahead in larger string
                if(m>n)
                    i++;
                else if(m<n)
                    j++;
                else { //length is same, update char. move ahead
                    i++;
                    j++;
                }

            }

        }

        return count==1;
    }
}
