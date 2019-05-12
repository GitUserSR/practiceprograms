package generics;

import java.lang.reflect.Array;
import java.util.Scanner;

public class GenericsDemo {

	public static void main(String[] args) {
		Container<Integer> container = new Container<>();
		
		container.value = 9;
		container.show();
		
		Scanner scanner = new Scanner(System.in); 
		Integer[] array = container.createArray();
		
	}
}

class Container<T>{
	T value;
	
	public void show() {
		System.out.print(value);
	}
	
	public T[] createArray() {
		T[] array = (T[]) Array.newInstance(value.getClass(), 5);
		return array;
	}
}
