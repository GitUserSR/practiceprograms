package autoboxing;

public class DoubledoubleNPE {

	public static void main(String[] args) {
		/*
		double primitiveFee_1 = 0d;
		Double objectFee_1 = null;
		primitiveFee_1 = objectFee_1;
		*/
		
		double primitiveFee_2 = 2.0d;
		Double objectFee_2 = null;
		objectFee_2 = primitiveFee_2;
		System.out.println("test");
	}
}
