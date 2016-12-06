package util.Locale;

import java.util.Locale;

public class Locale_1 {
	public static void main(String args[]){
		Locale locale1 = new Locale("in", "id");
		System.out.println(locale1.getLanguage());
		
		Locale locale2 = new Locale("id", "id");
		System.out.println(locale2.getLanguage());
	}
}
