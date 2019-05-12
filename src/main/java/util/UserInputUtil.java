package util;

import java.lang.reflect.Array;
import java.util.Scanner;

public class UserInputUtil<T> {
	
	
	
	public static <T> T[] readInputArray() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int size = in.nextInt(); 
		
		UserInputUtil<Integer> userInputUtil = new UserInputUtil<>();
		T[] inp = createArray(T.class ,size); 
		//<T>[] input = new <T>[count]; 
		String input = in.nextLine();
		String[] inputs = input.split(",");
		//Integer.parseInt(s, radix);
		Integer[] intArray = {1, 2, 3};
		return inp;
	}
	
	public static <T> T[] createArray(T inputType, int size){
		return (T[])Array.newInstance(inputType.getClass(), size);
	}
}
