package googlePuzzlers;

import java.util.HashSet;
import java.util.Set;

/*
public class SetPuzzler1 {

	public static void main(String[] args) {
		Set<Short> s = new HashSet<Short>();
		for(short i=0; i < 100; i++){
			s.add(i);
			s.remove((short)(i-1));
		}
		System.out.println(s.size());
	}

}

*/
public class SetPuzzler1 {

	public static void main(String[] args) {
		Set<String> urls = new HashSet<String>();
		for(short i=0; i < 100; i++){
			urls.add("www.google.com");
			urls.add("www.yahoo.com");
			//s.remove((short)(i-1));
		}
		System.out.println(urls.size());
	}

}