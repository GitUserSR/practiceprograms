package leetcode.medium;

public class DivideTwoIntegers {
	
	
	public static void main(String[] args) {
		//divisor dividend
		//7 = 2 * (1...dividend/2) + remainder
		//7-2* = 5
		System.out.println(divideTwoIntegers(2, 7));
		System.out.println(divideTwoIntegers(7, 13));
	}
	
	//2 13   dividend = divisor*quotient+remainder
	private static int divideTwoIntegers(int divisor, int dividend) {
		int quotient = 1;
		int reminder = dividend - divisor*quotient;
		/*while(dividend > divisor) {
			dividend- = divisor;
			quotient++;
		}*/
		
		while(reminder > divisor) {
			reminder = dividend - divisor*quotient;
			if(dividend < divisor*quotient+reminder) {
				return quotient-1;
			}
			quotient++;
		}
		return quotient;
	}
}
