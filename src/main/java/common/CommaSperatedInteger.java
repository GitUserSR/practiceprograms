package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommaSperatedInteger {

	public static void main(String[] args) {
		
		long i = 0;
		String output = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter integer value: ");
		
		try{
			i = scanner.nextInt();
		}catch(InputMismatchException ime){
			System.out.println("Please enter a valid integer");
			System.exit(1);
		}
		
		if(i < 1000){
			System.out.println("Since less than 1000, no need to comma sepearte the value");
			System.exit(1);
		}
		
		long quotient = i/1000; 
		long remainder = i%1000;

		while(quotient > 999){
			output = "," + remainder;
			remainder = quotient%1000;
			quotient  = quotient/1000;
		}
		
		output =  quotient + "," + remainder + output;
		remainder = quotient%1000;
		
		System.out.println(output);
	}
	
}
