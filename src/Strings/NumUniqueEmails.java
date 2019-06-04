package Strings;

import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {

    public static int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for(String email:emails) {
            int i = email.indexOf("@");
            String rest = email.substring(i);
            String local = email.substring(0,i);

            if(local.contains("+")) {
                local = local.substring(0,local.indexOf("+"));
            }
            if(local.contains(".")) {
                local = local.replaceAll(".", "");
            }
            seen.add(local+rest);
        }
        return seen.size();
    }

    public static void main( String args[]) {
        String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
