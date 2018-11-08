/* Class program for QuadraticConsole
 * by Joshua MAguire on 11/7/2012
 */
package edu.calvin.jlm54.homework10;

public class Quadratic {//constructors-------------
	private double myA,myB,myC;

	public Quadratic (){
		myA = 1;
		myB = 3;
		myC = 2;
	}
	public Quadratic(double A, double B, double C)throws Exception{
		if (A !=0){
			myA = A;
			myB = B;
			myC = C;
		}
		else{
			throw new Exception ("A " + A + "can not be 0");
		}

	}
	//-----------------------------------------------



	//accessors -------------------------
	public double geta(){
		return myA;
	}
	public double getb(){
		return myB;
	}
	public double getc(){
		return myC;
	}
	//-----------------------------------

	//computation methods---------------------
	public String toString(){
		return (myA + "x^2" + " + " + myB + "x + " + myC);
	}

	public double getEquation (double x){
		return(myA * Math.pow(x, 2) + myB*x + myC);
	}



	public boolean hasRoots(){
		if (Math.pow(myB,2)-4*myA*myC >= 0){
			System.out.print("does have real roots - ");
			return true;
		}
		else{
			System.out.print("doesn't have real roots - ");
			return false;
		}
	}
	//////////////////////////////////////// PARANTHESESSSSSSSSSSSSSSSSSSSSSSS finds min and max root of my abcs
	public double lRoot ()throws Exception{
		if (hasRoots() == true){
			double result = Math.max(((myB*-1 + Math.sqrt (( Math.pow( myB,2 ) - 4*myA*myC )))/ (2 * myA) ),((myB*-1 - Math.sqrt (( Math.pow( myB,2 ) - 4*myA*myC )))/ (2 * myA) ));
			return result;
		}
		else{
			throw new Exception("does not have real little root");
		}

	}
	
	public double sRoot ()throws Exception{
		if (hasRoots() == true){
			double result = Math.min(((myB*-1 + Math.sqrt (( Math.pow( myB,2 ) - 4*myA*myC )))/ (2 * myA) ),((myB*-1 - Math.sqrt (( Math.pow( myB,2 ) - 4*myA*myC )))/ (2 * myA) ));
			return result;
		}
		else{
			throw new Exception("does not have real large root");
		}

	}

	//------------------------------------------
}
