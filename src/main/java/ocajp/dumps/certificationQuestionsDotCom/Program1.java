package ocajp.dumps.certificationQuestionsDotCom;
/*
What	would	be	the	output,	if	it	is	executed	as	a	program?	
A. 123456
B. 65432
C. 12345
D. An	exception	could	be	thrown	at	runtime.
E. Compile	error.
*/
public class Program1 {

	public static void main(String[] args) {
		int []a = {1,2,3};
		int i = a.length;
		
		while(i>=1) {
			System.out.println(i);
			System.out.println(a[i]);
			i--;
		}
	}

}


/*
 * Length of array “a” is 6, so the value of the variable i is 6. Execution of
 * while loop will try to print array element reverse as variable “i” has
 * initial value 6 , So trying to access element with index position 6 will
 * cause ArrayIndexOutOfBoundsException since the array positions start with0.
 * Hence the correct option is D
 */
