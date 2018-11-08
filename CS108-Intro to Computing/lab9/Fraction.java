/*
 * this is the code for the type Fractions
 * by Joshua Maguire on October 25,2012
 */
package edu.calvin.jlm54.lab9;

public class Fraction {

	private int myNumerator;
	private int myDenominator;//myDenominator != 0

	public int getDenominator(){//Accessory method for getting mydenominator instance value
		return myDenominator;
	}
	public int getNumerator(){//Accessory method for getting mynumerator instance value
		return myNumerator;
	}


	public Fraction (int numerator, int denominator){//EXPLICIT-VALUE Constructor method sets variables if denominator != 0
		if (denominator != 0){
			myNumerator = numerator;
			myDenominator = denominator;
			simplify();//involces simplify method
		}
		else{

			System.err.println("Denominator was 0");
			System.exit(-1);
		}

	}




	public Fraction() {//this CONSTRUCTOR method initializes the two declared variables above
		myNumerator = 0;
		myDenominator = 1;
	}

	public String toString (){//this takes over the default System.out.print
		return (myNumerator+"/"+myDenominator);
	}

	
	public Fraction multiply (Fraction otherFraction){//This method when called multiplies Fractions together! Wow!
		return new Fraction(myNumerator * otherFraction.getNumerator(),myDenominator * otherFraction.getDenominator());
	}
	
	
	public void simplify(){//this method simplifies the fraction using the greatest common divisor and by making numbers positive.
		int gdc = computeGCD(myNumerator, myDenominator);
		if(gdc !=0){
			myNumerator = myNumerator/gdc;
			myDenominator = myDenominator/gdc;
		}
		if (myDenominator < 0){
			myNumerator = myNumerator*-1;
			myDenominator = myDenominator*-1;
		}
	}

	/**
	 * This method finds the greatest common divisor of two integers, using
	 * Euclid’s algorithm
	 * 
	 * @param alpha  one integer
	 * @param beta   the other integer
	 * @return       the greatest common divisor of alpha and beta.
	 */
	private static int computeGCD(int alpha, int beta) {
		alpha = Math.abs(alpha);
		beta = Math.abs(beta);
		int remainder = alpha % beta;
		while (remainder != 0) {
			alpha = beta;
			beta = remainder;
			remainder = alpha % beta;
		}
		return beta;
	}
}