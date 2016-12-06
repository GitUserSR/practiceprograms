package test;

import java.util.ArrayList;
import java.util.List;

public class SimpleNullCheck {

	public static void main(String args[]){
		byte[] b = {};
		String s = new String(b);
		
		List<String> str = new ArrayList<String>();
		str.add("");
		str.add("");
		
		System.out.println(str.get(0) + "testing");
		
		
		String s1 = null;
		System.out.println(s1+ "testing");
		
		StringBuilder buff = new StringBuilder(1000);
		buff.append("");
		String s2 = buff.toString();
		System.out.println("S2 value:" + s2 + "Spaces" + s2.toString());
		
		if(s2.equals(" ")){
			System.out.println("True");
		}
		
		//S2 value: Spaces
		//S2 value:  Spacescd biz/
		
	}
	
}
