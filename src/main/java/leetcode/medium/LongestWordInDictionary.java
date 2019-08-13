package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 * @author srapolu
 * 
 * 524. Longest Word in Dictionary through Deleting
 * 
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
 *
 */
public class LongestWordInDictionary {
	static String input = "abpcplea"; 
	static String[] dictionary = {"ale","apple","monkey","plea"};
	
	public static void main(String[] args) {
		/*
		for(int i=0; i< dictionary.length; i++) {
			String[] dictionaryWord = dictionary[i].split("");
			System.out.println(dictionaryWord.length);
			for(int j=0; j<dictionaryWord[i].length();i++) {
				
		
			}
			
		}*/
		getPermutations("abpcplea");
	}
	/*abpcplea
	a, ab, */
	//find all permutations and combinations of input 
	public static void getPermutations(String input) {
		Map<String, String> inputWordPermutations = new HashMap<>();
		String str = new String();
		for(int i=0; i<input.length(); i++) {
			str = str + input.charAt(i);
			inputWordPermutations.put(str, str);
			System.out.println(str);
		}
	}
}
