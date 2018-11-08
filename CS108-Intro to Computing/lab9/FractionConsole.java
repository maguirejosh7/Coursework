/*
 * This is the console for the program. It creates a new type (Fractions) and prints it, which
 * is printed using the fraction.java part.
 * by Joshua Maguire on October 25, 2012
 */
package edu.calvin.jlm54.lab9;

public class FractionConsole {
	public static void main(String[] args) {
		Fraction f1 = new Fraction();     // Construct a default fraction object.
		System.out.println(f1);           // Print the object.

		Fraction f2 = new Fraction(1, 2);     // Construct a fraction object for one half.
		System.out.println(f2);               // Print the object.

		//----9.5 tests----
		System.out.println("--------------9.5-----------");
		Fraction f3 = new Fraction(453, 7654);
		System.out.println(f3);    
		/*
		 * Fraction f4 = new Fraction(7, 0);  
		 * System.out.println(f4);  
		 */

		//----9.6----
		System.out.println("---------9.6---------");
		System.out.println(f3.getDenominator());//calls method for printing the denominator
		System.out.println(f3.getNumerator());//calls method for printing the numerator

		//---9.7---
		System.out.println("-----------9.7----------");
		Fraction f5 = new Fraction(2, 4);     // Construct a fraction object for two fourths.
		System.out.println(f5);               // Print the object.
		
		Fraction f6 = new Fraction(-100, -200);     // Construct a fraction object for two fourths.
		System.out.println(f6);               // Print the object.
		
		//----9.8----
		System.out.println("---------9.8----------");
		System.out.println(f2.multiply(f5));//should equal 1/4 and does. yay.
	}

}
