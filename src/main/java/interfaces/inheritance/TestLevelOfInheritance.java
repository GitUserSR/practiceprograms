package interfaces.inheritance;

public class TestLevelOfInheritance {
	public static void main() {
		
	}
}
abstract class Animal{
	String latinName;
	String commonName;
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
}
//6 types of animals
abstract class Mammal extends Animal{
	abstract boolean isCarnivore();
	abstract boolean isHerbivore();
	abstract boolean isOmnivore();
}
abstract class Bird extends Animal{
	abstract boolean canFly();
}
abstract class Fish extends Animal{
	
}
class Tiger extends Animal{
	boolean isCarnivore() {return true;}
	boolean isHerbivore() {return false;}
	boolean isOmnivore() {return false;}
}
class Raccoon extends Animal{
	boolean isCarnivore() {return false;}
	boolean isHerbivore() {return true;}
	boolean isOmnivore() {return false;}
}

