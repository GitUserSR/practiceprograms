package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		long input = scanner.nextLong();
		long factorial = factorial(input);
		System.out.print(factorial);
	}
	//5! = 5*(5-1)*(4-1)*(3-1)*(2-1)*
	static long factorial(long input){
		long factorial = 0;
		if(input == 1) {
			return 1;
		}else if(input > 0) {
			factorial = input*factorial(input-1);
		}
		return factorial;
	}
}
