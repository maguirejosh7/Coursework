/*
 * Console for Circle program which gets area of a circle
 * by Joshua Maguire on 11/1/2012
 */

package lab10;

public class CircleConsole {
	public static void main(String[] args) {
		try{
			Circle c1 = new Circle();
			System.out.println(c1.getArea());//no error
		} catch (Exception E){
			System.out.println(E.getMessage());
		}
	}
	
}
