package keywords.volatil;

public class VolatileTest {
	
	public static volatile int MY_INT = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}
	/*static nested class (Recollect diff between 'static nested class' and 
	'non-static nested class/inner class') >>>>>>>
	A non-static nested class (or 'inner class') has full access to the members of the class 
	within which it is nested. A static nested class does not have a reference to a nesting 
	instance, so a static nested class cannot invoke non-static methods or access non-static 
	fields of an instance of the class within which it is nested.

	Technically, there is no such thing as a static inner class. According to "Effective Java", 
	the correct terminology is a "static nested class". A non-static nested class is indeed an
	inner class, along with anonymous classes and local classes.

	Each instance of a nonstatic [nested] class is implicitly associated with an enclosing 
	instance of its containing class... It is possible to invoke methods on the enclosing instance.

	A static nested class does not have access to the enclosing instance. It uses less space too.
	
	1)Remove static keyword before class declaration of ChangeListener. Makes ChangeListener a inner class/non-static nested class.
	2)To instantiate inner class and access methods of it
		VolatileTest volatileTest =new VolatileTest();
		volatileTest.new ChangeListener().start();
	*/
	
	static class ChangeListener extends Thread {

		@Override
		public void run() {
			int local_value = MY_INT;
			while (MY_INT < 5){
				if(local_value != MY_INT){
					System.out.println("Got change for MY_INT");
					local_value = MY_INT;
				}
			}
		}
		
	}

	static class ChangeMaker extends Thread {
	
		@Override
		public void run() {
			int local_value = MY_INT;
			while (MY_INT < 5){
				System.out.println("Incrementing MY_INT " + (local_value+1));
				MY_INT = ++local_value;
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}

			}
		}
		
	}
}


