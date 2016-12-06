package common;

import java.io.*;


public class HowManyWaysToCreateAnObject {

	public static void main(String[] args)  {
//		1) using new keyword
		Test test_new = new Test();
		
//		2)using newInstance; Example, is connecting to a JDBC driver in Java. Class.forName loads the class but doesnt create an object. 
//		Class needs to have public default Constructor.
		try {
			Class cls = Class.forName("Test"); //throws ClassNotFoundException
			Test test_forName_newInstance = (Test) cls.newInstance(); //thows InstantiationException,IllegalAccessException 
			System.out.println(test_forName_newInstance.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
//		3)using clone method; 
//		creates the clone of the existing object and not any new Object
//		Clone method is declared protected in Object class. So it can be accessed only in subclass or in same package. That is the reason why it has been overridden in TestClone class, . 
//		Class need to implement Cloneable Interface otherwise calling clone() method on it throw CloneNotSupportedException 
		try {
			TestClone test_clone = (TestClone)new TestClone().clone();
			System.out.println(test_clone.toString());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
//		4)using Object deserialization. //TODO try with ByteArrayOutputStream and ByteArrayInputStream instead of FileInputStream
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TestSerializable.ser"));
			out.writeObject(new TestSerializable());
			out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("TestSerializable.ser"));
			TestSerializable test_deserialized = (TestSerializable)in.readObject();
			System.out.println(test_deserialized.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		5)using ClassLoader
		try {
			Test test_classLoader = (Test) new HowManyWaysToCreateAnObject().getClass().getClassLoader().loadClass("Test").newInstance();
			System.out.println(test_classLoader.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

class Test{
//	private Test(){} // if the modifier is private, then
//	way-1 >> compiler error, can not access a private member. 
//	way-2 Reflection.java throws an java.lang.IllegalAccessException with message - can not access a member of class Test with modifiers "private" 
}

class TestClone implements Cloneable{
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

class TestSerializable implements java.io.Serializable{
	//To improve read and write times in large object trees, use the transient keyword for instance variables that don't require serialization.
	//This will increase performance in taht you are no longer reading and writing unnecessary data into the serialization process
	
	private static final long serialVersionUID = -7418277454300989836L;
	int i = 10;
	String s = new String("test");
}

enum TestEnum{
	enum1;
	private String currentTestBed=null;

	public String getCurrentTestBed() {
		return currentTestBed;
	}

	public void setCurrentTestBed(String currentTestBed) {
		this.currentTestBed = currentTestBed;
	}
}




















