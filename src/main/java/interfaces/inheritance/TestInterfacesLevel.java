package interfaces.inheritance;

import java.util.Arrays;

public class TestInterfacesLevel {

	public static void main(String[] args) {
      
		BaseClass obj = new SubClass1();
        obj.test();
        obj.test2();

        SomeInterface obj2 = new SubClass1();
        obj2.test();
        obj2.test2();
        
		BaseClass obj3 = new SubClass2();
        obj3.test();
        obj3.test2();
        
        SomeInterface obj4 = new SubClass2();
        obj4.test();
        obj4.test2();
    }
}

interface SomeInterface {
    public void test();

    public void test2();
    
}

abstract class BaseClass implements SomeInterface {
	
	Class<?>[] baseClassInterfaces = this.getClass().getInterfaces();
	
	 @Override
	 public void test() {
		 
	 }
    @Override
    public void test2() {
        try {
         	System.out.println(Arrays.toString(this.getClass().getMethod("test2", null).getDeclaringClass().getInterfaces()));
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }   
}

class SubClass1 extends BaseClass {
	
	Class<?>[] subClass1Interfaces = this.getClass().getInterfaces();
	
    @Override
    public void test() {
        try {
            System.out.println(Arrays.toString(this.getClass().getMethod("test", null).getDeclaringClass().getInterfaces()));
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class SubClass2 extends SubClass1 {
	
	Class<?>[] subClass2Interfaces = this.getClass().getInterfaces();
	
    @Override
    public void test() {
        try {
            System.out.println(Arrays.toString(this.getClass().getMethod("test", null).getDeclaringClass().getInterfaces()));
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}