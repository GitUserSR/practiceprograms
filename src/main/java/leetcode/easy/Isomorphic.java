package leetcode.easy;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Isomorphic {
    public static void main(String[] args) {
        System.out.println(new Isomorphic().isIsomorphic("aa", "ab"));
    }
    public boolean isIsomorphic(String s, String t) {
        Set<Character> charSet = new HashSet<Character>();
        HashMap<String, String> map = new HashMap<>();

        boolean isIsomorphic = false;
        if(s.length() != t.length()){
            isIsomorphic = false;
            return isIsomorphic;
        }
        //StringBuilder newt = new StringBuilder(t);
        for(int i=0; i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                String regex = Character.toString(s.charAt(i));
                String replacement = Character.toString(t.charAt(i));
                map.put(regex,replacement);
                t =  t.replace(regex, replacement);
            }
        }
        isIsomorphic = t.equalsIgnoreCase(s) ? true : false;
        return isIsomorphic;
    }
}
/*
    https://leetcode.com/problems/isomorphic-strings/

    Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

        Example 1:

        Input: s = "egg", t = "add"
        Output: true
        Example 2:

        Input: s = "foo", t = "bar"
        Output: false
        Example 3:

        Input: s = "paper", t = "title"
        Output: true
        Note:
        You may assume both s and t have the same length.

 */