package leetcode.easy;

import java.util.*;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(new LongestSubString().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<Character>();
        Map<String, String> charMap = new HashMap<>();
        StringBuilder patternBuilder = new StringBuilder();
        SortedMap<Integer, String> patternMap = new TreeMap<Integer, String>();
        for(int i=0; i<s.length();i++) {
            String character = Character.toString(s.charAt(i));
            if(!charMap.containsKey(character)){
                charMap.put(character, character);
                patternBuilder.append(character);
               /* if(s.contains(patternBuilder)){
                    patternMap.put(patternBuilder.length(), patternBuilder.toString());
                }*/
            }
        }
        String pattern = patternBuilder.toString();
        int i=0;
        do{
            if(s.contains(pattern)){
                return pattern.length();
            }else{
                pattern = pattern.substring(i++, pattern.length());
            }
        }while(pattern.length()<1);

        return 0;
    }
}

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */