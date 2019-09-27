package ocajp.dumps.enthuware;

public class Test1 {

	public static void main(String[] args) {
		Test1 test1 = new Test1();

		test1.question1();

	}

	public void question1() {
		System.out.println(Integer.MIN_VALUE);
	     System.out.println(Integer.MAX_VALUE);
	     System.out.println(Integer.MIN_VALUE - 1);
	     System.out.println(Integer.MAX_VALUE + 1);
	     System.out.println(Math.pow(2, 23));
		int i = 1234567890;
		float f = i;
		System.out.println(i - (int) f);
	}
	
	

}
/*
//question2

class MyString extends String{

	MyString(){ super(); }
}
The type MyString cannot subclass the final class String. This will not compile because String is a final class and final classes cannot be extended.
There are questions on this aspect in the exam and so you should remember that StringBuffer and StringBuilder are also final. All Primitive wrappers are also final (i.e. Boolean, Integer, Byte etc).
java.lang.System is also final

*/

/*
An abstract class can be extended by an abstract or a concrete class.
A concrete class can be extended by an abstract or a concrete class.
An interface can be extended by another interface.
 */

/*
What class of objects can be declared by the throws clause?
Exception,Error,RuntimeException
*/

/*
An instance member 
can be a variable, a constant or a method.
belongs to an instance of the class
*/

/*
|| and && are called short circuiting operators because if, while evaluating a logical expression, at any stage, the value of the whole expression can be determined without evaluating the rest of the expression, then the remaining sub-expressions are not evaluated.

Consider this:
boolean bool  = true; int k = 10;
if( bool == false && ( (k = 3) == 5 )  ) { .....}
System.out.println(k);             // this will print 10.

Because the value of the whole expression can be determined just by looking at bool == false.
So k = 3 is never executed. The big expression was short circuited by &&.

Had the expression been if( bool == false & ( (k = 3) == 5 )  ) { .....}  . notice single & instead of &&  
then it would have printed 3 because k = 3 will be executed. Even though the value of the expression is known immediately after evaluating bool == false, the rest of the expression is still evaluated. Thus, & is not a short circuiting operator.

Same thing happens with || and | as well. 
*/

