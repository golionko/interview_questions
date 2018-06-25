package interview;

import java.util.HashMap;
import java.util.Map;

public class QStrings {

    public static void main(String [ ] args){

    }




    //Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        for (int i = 0, j = cleaned.length()-1; i < j;)
            if (cleaned.charAt(i++) != cleaned.charAt(j--))
                return false;
        return true;
    }

    //Given two strings s and t , write a function to determine if t is an anagram of s.
    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;

        Map<Character, Integer> dict = new HashMap<>();
        for(char c : s.toCharArray()) dict.put(c, dict.getOrDefault(c, 0) + 1);
        for(char c : t.toCharArray()) {
            int count = dict.getOrDefault(c, 0);
            if (count == 0) return false;
            else dict.put(c, count - 1);
        }

        return true;
    }

}
