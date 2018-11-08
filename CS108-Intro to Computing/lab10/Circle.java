/*
 * coding for Circle program which gets area of a circle
 * by Joshua Maguire on 11/1/2012
 */
package lab10;
public class Circle {
	private double myX, myY, myDiameter;


	public Circle(){ //default constructor
		myX = 0;
		myY =0;
		myDiameter = 100;
	}
	
	public Circle(double X, double Y, double Diameter)throws Exception{
		if (Diameter >= 0){
			myX = X;
			myY = Y;
			myDiameter = Diameter;
		}
		else{
			throw new Exception("Diameter \"" + Diameter + "\" cannot be negative!");
		}
	}
	//accessors-----------------------
	public double getX(){
		return myX;
	}
	public double getY(){
		return myY;
	}
	public double getDiameter(){
		return myDiameter;
	}
	//---------------------------------
	
	public double getArea(){//instance method calculates area. default answer=7850. If Diameter = 10, area = 25.
		return (3.14*Math.pow(.5*myDiameter, 2));
	}

}
