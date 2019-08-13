package leetcode.medium;

public class FindPower {

	public static void main(String[] args) {
		System.out.println(new FindPower().power(2,3));
		System.out.println(new FindPower().power(2.10f,2));
		System.out.println(new FindPower().power(2,-2));
	}
	
	public float power(float x, int n) {
		float pow = x;
		if(n > 0) {
			int i=1;
			while(i<n) {
				pow = pow*x;
				i++;
			}
		}else {
			int newn = n *-1;
			int i=1;
			while(i<newn) {
				pow = pow*x;
				i++;
			}
			return 1/pow;
		}
		return pow;
	}
}
