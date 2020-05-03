package Strings;

public class Anagram {

    /**
     * Increment the counter and decrement the counter. Valid if counter is 0
     * time complexity o(n) space complexity O(1)
     * tables size stay constant no matter what the size of n is
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s==null || t ==null)
            return false;

        if(s.length()!=t.length())
            return false;

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i:arr) {
            if(i!=0)
                return false;
        }
        return true;
    }

    public int minStepsToMakeTwoStringsAnagram(String s1, String s2) {
        int[] str = new int[26];
        int count = 0;
        for(int i=0;i<s1.length();i++) {
            str[s1.charAt(i)-'a']++;
        }

        for(int i =0; i<s2.length(); i++) {
            if(str[s2.charAt(i)-'a']-- <0) {
                count++;
            }
        }

        return count;
    }


}


