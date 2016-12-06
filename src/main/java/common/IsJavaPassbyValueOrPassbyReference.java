/**
 * Java does manipulate the objects by references, and all object variables are references. However, java dosen't pass method arguments by reference; it passes by value.
 * public void badSwap(int var1, int var2){
 * 	int temp = var1;
 * 	var1 = var2;
 * 	var2 = temp;
 * }
 * When bad swap returns, the variables passed as arguments will still hold their original values. The method will also fail if we change the type from int to Object, since Java passes 'object references' by value as well. 
 * 
 * @author swathirapolu
 *
 */

public class IsJavaPassbyValueOrPassbyReference {

	public void tricky(Point arg1, Point arg2)
	{
	  arg1.x = 100;
	  arg1.y = 100;
	  Point temp = arg1;
	  arg1 = arg2;
	  arg2 = temp;
	  //This method successfully alters the value of pnt1, even though it is passed by value; however, a swap of pnt1 and pnt2 fails! 
	  //In the main() method, pnt1 and pnt2 are nothing more than object references. When you pass pnt1, pnt2 to the tricky() method, Java passes the
	  //references by value just like any other parameter. This means 
	}
	public static void main(String [] args)
	{
	  Point pnt1 = new Point(0,0);
	  Point pnt2 = new Point(0,0);
	  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
	  System.out.println(" ");
	  new IsJavaPassbyValueOrPassbyReference().tricky(pnt1,pnt2);
	  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);  
	}

}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}


