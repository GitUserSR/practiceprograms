package ocajp.dumps.certificationQuestionsDotCom;

public class Program5 {
	static Integer i;

	public static void main(String[] args) {
		try {
			System.out.println(i.compareTo(0));
		} catch (ArithmeticException | NullPointerException e ) {
			e.printStackTrace();
		}
	}
}

/*
Which	is	the	output?
A. -1
B. 0
C. 1
D. Exception
E. Compilation	fails.












Option	D	is	correct.	
From	java	se	8,	we	can	use	catch	box	for	multi	exceptions	so	this	code	compiles	fine.		In	given	catch	box	it	can	catch	
both		ArithmeticException	and	NullPointerException.		At	line	7,	a	NullPointerException	will	be	thrown	since	I	is	not	
initialized.	Hence	option	D	is	correct.

*/