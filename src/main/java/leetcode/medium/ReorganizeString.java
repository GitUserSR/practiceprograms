package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author srapolu
 * 
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 *
 */

public class ReorganizeString {

	static String input = "aab";
	static Set possibilities = new HashSet<>();
	
	public static void main(String[] args) {
		generate(input);
		System.out.println("test");
	}
	
	public static void generate(String input) {
		for(int i=0; i<input.length(); i++) {
			char currentChar = input.charAt(i);
			for(int j=i+1; j <input.length(); j++) {
				char nextChar = input.charAt(j);
				if(currentChar != nextChar) {
					StringBuilder newString = new StringBuilder(input); 
					newString.setCharAt(j, currentChar);
					newString.setCharAt(i, nextChar);	
					possibilities.add(newString.toString());
				}
				
			}
			
		}
	}

}
