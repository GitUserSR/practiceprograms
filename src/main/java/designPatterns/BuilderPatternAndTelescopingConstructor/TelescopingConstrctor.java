package designPatterns.BuilderPatternAndTelescopingConstructor;

public class TelescopingConstrctor {
	
	TelescopingConstrctor(int size) { }        
	TelescopingConstrctor(int size, boolean cheese) { }    
	TelescopingConstrctor(int size, boolean cheese, boolean pepperoni) {}    
	TelescopingConstrctor(int size, boolean cheese, boolean pepperoni, boolean bacon) {  }
	
//Pro: bettern than java bean style: setter and getter -- more thread safe.
//Con: Ugly and confuse -- which constructor should be use??
	public static void main(String[] args) {}

}
