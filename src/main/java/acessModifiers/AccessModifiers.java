package acessModifiers;
/*
 * 1) class level access modifiers - public, abstract, final. 
 * 'Illegal modifier' error is shown if a class is marked as Protected 
 * 3) If primitive data types:
 * 		If local variables / instance variables are not initialized during the declaration, then the IDE shows an Warning.  Program won't 'Compile and Run'
 * 		If a class level variables are not initialized during the declaration, default values would be assigned to them. Program 'Compiles and Runs'
 * 		default values of primitive data types are : { byte:0 , short:0, int:0, long:0L, float:0.0f, double:0.0d, char: '\\u000', String(or any object):null, boolean:false}
 */
//2)protected class AccessModifiers { //Program would not compile, illegal modifier at class level
class AccessModifiers { 
		int i_c;//_c is class level variable
		float f_c;
		double d_c;
		long l_c;
		char c_c;
		boolean b_c;
		Object o_c;
		int[] intArray_c_1;
		int[] intArray_c_2 = new int[10];
	public static void main(String[] args) { new AccessModifiers().test();}
	
	public void test(){
		int i_l;//_l is local variable
		float f_l;
		double d_l;
		long l_l;
		char c_l;
		boolean b_l;
		Object o_l;
		int[] intArray_l;
		//Debug and see what are the default values of these ??
//		System.out.println("default values are" + i_l);  //gives an error
//		System.out.println("default values are" + o_l);  //gives an error
//		System.out.println("default values are" + intArray_l);  //gives an error
		System.out.println(" default values are " + i_c + ":" +f_c + ":" + d_c+ ":" + c_c+ ":" + b_c+ ":" +o_c + ":" + intArray_c_1 + ":" + intArray_c_2); 
	  	// prints default values are 0:0.0:0.0: :false:null:null:[I@4f93b604
//		System.out.println(intArray_c_1[0]);System.out.println(intArray_c_2[0]); int test = intArray_c_1[0]; //Throws a NullPointerException, since the array is not initialized
	}

}
