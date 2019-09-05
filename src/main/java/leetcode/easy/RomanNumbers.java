package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
	static Map<String, Integer> roman = new HashMap<>();
	
	public static void main(String[] args) {
		populateHashMap();
		String s = "";
		System.out.println(romanToInt("IVIII"));
		
	}
	
	private static int romanToInt(String s) {
		int length = s.length();
		int value = 0;
		for(int i=0; i<length; i++) {
			String c1 = String.valueOf(s.charAt(i));
			Integer i1 = roman.get(c1);
			
			if(i+1 < length && (roman.get(String.valueOf(s.charAt(i+1))) > i1) ) {
				Integer i2 = roman.get(String.valueOf(s.charAt(i+1)));
				if(i1 < i2) {
					value = value + (i2-i1);
					i++;
				}
			}else {
				value = value + i1;
			}
		}
		return value;
	}
	
	private static void populateHashMap() {
		roman.put("I", 1);
		roman.put("V", 5);
		roman.put("X", 10);
		roman.put("L", 50);
		roman.put("C", 100);
		roman.put("D", 500);
		roman.put("M", 1000);
	}

}
