/* Class program for QuadraticConsole
 * by Joshua MAguire on 10/31/2012
 */
package edu.calvin.jlm54.homework09;

public class Quadratic {//constructors-------------
	private double myA,myB,myC;

	public Quadratic (){
		myA = 1;
		myB = 3;
		myC = 2;
	}
	public Quadratic(double A, double B, double C){
		if (A !=0){
			myA = A;
			myB = B;
			myC = C;
		}
		else{
			System.err.println("\"a\" can't be 0!");
			System.exit(-1);
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

	//------------------------------------------
}
