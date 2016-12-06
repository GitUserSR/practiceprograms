package util.NavigableSet;

import java.util.TreeSet;
//What will be the output of below program ?
//1. The program will compile and run fine to print the contents of the set.
//2. The program will raise a run-time exception telling that it is not possible to add objects of type ‘java.lang.Object’ in place of ‘java.lang.String’.
//3. The program will raise a compile-time error.
public class Ques02 {

	/* Note: Uncomment this to run
	public static void main(String[] args) {
		MyNavigableSet objects = new MyNavigableSet();
		objects.add(new Object());
		System.out.println(objects);
	}
}

class MyNavigableSet extends TreeSet<String>{
	public boolean add(Object value){ //Line-A
		return super.add(value);
	}
	*/
}
