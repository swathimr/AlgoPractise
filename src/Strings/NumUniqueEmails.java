package Strings;

import java.util.HashSet;
import java.util.Set;

// time complexity and space complexity O(c) - c istotal content of emails
public class NumUniqueEmails {

    public static int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for(String email:emails) {
            int i = email.indexOf("@");
            String local = email.substring(0,i);
            String rest = email.substring(i);

            if(local.contains("+")) {
                local = local.substring(0,local.indexOf("+"));
            }
            if(local.contains(".")) {
                local = local.replaceAll("  \\.", "");
            }
            seen.add(local+rest);
        }
        return seen.size();
    }

    public static void main( String args[]) {
        String[] emails = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
