package leetcode.easy;

public class SquareRoot {

	public static void main(String[] args) { 
		SquareRoot squareRoot = new SquareRoot();
		//System.out.print(squareRoot.squareRoot(8));
		System.out.print(squareRoot.squareRoot(13));
		//System.out.print(squareRoot.squareRoot(8));
	}
	
	private int squareRoot(int input) {
		int i = 0;
		while(i < input) {
			int square = i * i;
			if(square > input) {
				return i-1;
			}
			i++;
		}
		return i;
	}
	//use binary search
	
	//try newton methos
}
