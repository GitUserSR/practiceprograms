package test;

import java.util.Arrays;
import java.util.Scanner;

public class Hw5 {
	
	public static void main(String args[]){
		Hw5 hw5 = new Hw5();
		while(true){
			int num = hw5.readUserInput();
			int size = getSize(num);
			int[] intArray = new int[size];
			fillArray(num, intArray);
			isPalindrome(intArray);
		}		
	}
	
	@SuppressWarnings("resource")
	private int readUserInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an interger : ");
		int num = scanner.nextInt();
		if(num == -99){
			System.out.print("Teminating because you have inputted -99");
			System.exit(0);
		}
		return num;
	}

	private static int getSize(int num){
		int size=0;
		if(num == 0){
			return size;
		}else if(num > 0){			
			while(num>0){
				size++;
				num = num/10;
			}			
		}else if(num<0){
			while(num<0){
				size++;
				num = num/10;
			}
		}
		return size;		
	}	
	
	private static void fillArray(int num, int[] intArray){
		for(int i=0; i<intArray.length; i++){
			int remainder = num % 10;
			intArray[i] = remainder;
			num = num/10;			
		}
	}
	
	private static boolean isPalindrome(int[] intArray){
		boolean isPalindrome = false;
		if(Arrays.equals(intArray, reverseArray(intArray))){
			isPalindrome = true;
			System.out.println("palindrome");
		}else{
			isPalindrome = false;
			System.out.println("Not a palindrome");
		}
		return isPalindrome;
	}
	
	public static int[] reverseArray(int[] intArray){
		int size = intArray.length;
		int[] intArrayReverse = new int[size];		
		for(int i=0; i<intArray.length; i++){
			intArrayReverse[size-1-i] = intArray[i];
		}
		return intArrayReverse;
	}
	
}
