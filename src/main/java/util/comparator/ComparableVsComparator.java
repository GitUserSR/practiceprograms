package util.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 @author swathirapolu
 * java.lang.Comparable is an Interface with method: int compareTo(),  java.util.Comparator is an Interface with method: int compare(). 
 * -(returns - 0 (if 'this' equal to 'target'),  +ve integer (if 'this' greater than 'target')), -ve integer (if 'this' less than 'target'))
 * 
 * >>Differences between Comparable and Comparator:
 * -There can be only one 'compareTo' implementation for an object, while multiple Comparator for comparing different parameters of an object[example-fruitDescriptionComparator, fruitNameComparator].
 * -Many Java classes, which make use ofComparator and Comparable defaults to Comparable and provided overloaded method to work with arbitary Comparator instance [example, 
 * 1) Collections.sort(List<T> list) - sort according to Comparable:compareTo defined in  class type T, 
 *    Collections.sort(List<T> list, Comparator<? super T> c)  - sort according to Comparator instance 'c' 
 * 2) Arrays.sort(Object[] a) - Sorts the specified array of objects into ascending order, according to the natural ordering of its elements, 
 *    Arrays.sort(T[] a, Comparator<? super T> c) - uses Comparator instance 'c'
 *
 *>>Best practice:
 * - Both compareTo() and compare() method must be consistent with equals() method implementation i.e. if two objects are equal by 'equals() method' then compareTo() and compare() must return zero.
 *   Failing to adhere this guideline, your object may break invariants of Java collection classes which rely on compare() or compareTo() e.g. TreeSet and TreeMap.
 * - Declare Comparator as a 'nested static class', because it is closely associated with objects it compares.
 */
public class ComparableVsComparator {

	public static void main(String[] args) {
		
		Fruit pineappale = new Fruit("Pineapple", "Pineapple description",70); 
		Fruit apple = new Fruit("Apple", "Apple description",100);
		Fruit peach = new Fruit("peach", "peach description",60);
		Fruit orange = new Fruit("Orange", "Orange description",80); 
		Fruit banana = new Fruit("Banana", "Banana description",90); 
		
		Fruit[] fruitComparable = new Fruit[]{pineappale, apple, peach, orange, banana};
		Arrays.sort(fruitComparable); printFruits("fruitComparable", fruitComparable);
		
		Fruit[] fruitQuantityComparator = new Fruit[]{pineappale, apple, peach, orange, banana};
		Arrays.sort(fruitQuantityComparator, new Fruit());printFruits("fruitQuantityComparator", fruitQuantityComparator);
		
		Fruit[] fruitDescriptionComparator = new Fruit[]{pineappale, apple, peach, orange, banana};
		Arrays.sort(fruitDescriptionComparator, Fruit.fruitDescriptionComparator);printFruits("fruitDescriptionComparator", fruitDescriptionComparator);
		
		Fruit[] fruitNameComparator = new Fruit[]{pineappale, apple, peach, orange, banana};
		Arrays.sort(fruitNameComparator, new FruitNameComparator());printFruits("fruitNameComparator", fruitNameComparator);
	}
	
	public static void printFruits(String from, Fruit[] fruits){
		System.out.println("****"+from+"****");
		for(Fruit fruit:fruits){
			System.out.println(fruit.getName() +":"+fruit.getQuantity());
		}
	}

}
class FruitNameComparator implements Comparator<Fruit>{

//	implementing Comparator:compare method
	public int compare(Fruit o1, Fruit o2) {
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
//		return o1.getName().compareToIgnoreCase(o2.getName()); //Calls 'String' compare method, to find the string equality
	}
	
}

class Fruit implements Comparable<Fruit>, Comparator<Fruit>{
	String name;
	String description;
	int quantity;
	
	//implementing Comparable:compareTo() method
	public int compareTo(Fruit o) {
		return this.quantity - o.quantity;//ascending order
		//return o.quantity - this.quantity; //descending order
	}
	
	//implementing Comparator:compare() method
	public int compare(Fruit o1, Fruit o2) {
		return o1.quantity - o2.quantity;
	}
	
	public static Comparator<Fruit> fruitDescriptionComparator = new Comparator<Fruit>(){
		//implementing Comparator:compare method
		public int compare(Fruit o1, Fruit o2) {
			return o1.getDescription().toLowerCase().compareTo(o2.getDescription().toLowerCase());
		}
		
	};
	
	public Fruit(){}
	
	public Fruit(String name, String description, int quantity){
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
