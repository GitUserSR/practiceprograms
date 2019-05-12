package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;

//0,1,1,2,3,5,8,13,21,34..
public class Fibonacci {

	static boolean isFirst = true;
	static int i_0 = 0;
	static int i_1 = 1;

	public static void main(String[] args) {
		System.out.print("Enter a Number: ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		// f(input);
		printFibonacci(input);
	}

	/*
	 * static void f(int input) { int fib; for (int j =0; j<=input; j++) { if(input
	 * == 0) { System.out.print(input); }else { fib+= f(j-1); System.out.print(fib);
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	static void printFibonacci(int input) {
		int fibonacci = 0;
		int i = 0;
		while (i < input) {
			fibonacci = fibonacci(i);
			System.out.print(fibonacci + " ");
			i++;
		}
	}

	static int fibonacci(int input) {
		int fibonacci = 0;
		if (input == 0) {
			fibonacci = 0;
			return fibonacci;
		} else if (input == 1) {
			fibonacci = 1 + fibonacci(input - 1);
			return fibonacci;
		} else {
			fibonacci = fibonacci(input - 1) + fibonacci(input - 2);
		}
		return fibonacci;
	}
}