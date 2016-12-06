package test;

import java.util.Scanner;

public class SumReversePalindrome { 
	
	private static int number;
	
	public static void main(String[] args) {
		SumReversePalindrome sumReversePalindrome = new SumReversePalindrome();
		while(true){
			sumReversePalindrome.readUserInput();
			System.out.println("The sum of all digits is: " + sumReversePalindrome.sumOfDigits(number));
			System.out.println("The reversed number is: " + sumReversePalindrome.reverseNumber(number)); ;
			System.out.println("It is a palindrome: " +  sumReversePalindrome.palindrome(number));
		}
	}
	
	private void readUserInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an interger : ");
		number = scanner.nextInt();
	}
	
	private int sumOfDigits(int number){
		int dividend = number, remainder = 0, sum = 0;
		
		while(dividend > 0){
			remainder = dividend % 10; 
			dividend = dividend / 10;
			sum = sum + remainder ;
		}
		return sum;		
	}

	private int reverseNumber(int number){ 
		int dividend = number, remainder = 0, multiplier = 10, reversedNumber = 0;
		while(dividend > 0){
			remainder = dividend % 10; 
			dividend = dividend / 10;
			reversedNumber = reversedNumber * multiplier + remainder;
		}	
		return reversedNumber;
	}
	
	private boolean palindrome(int number){
		boolean isPalindrome = false; 
		if(number == reverseNumber(number)){
			isPalindrome = true;
		}
		return isPalindrome;
	}
}
