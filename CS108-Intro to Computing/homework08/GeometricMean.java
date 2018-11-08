/*
 * This program made on10/24/2012 by Joshua Maguire calculates the
 * geometric mean of an array.
 */
package edu.calvin.jlm54.homework08;
import java.util.Scanner;

public class GeometricMean {
	public static void main(String[] args){
		//asks for how many numbers you wanan get the gmean of
		Scanner keyboard = new Scanner (System.in);
		System.out.print("number of numbers:");
		int amount = keyboard.nextInt();
		//prints out a method inside a method. 
		//first goes to arrayMaker and makes the array, then 
		//goes to gMean and uses that array to get the geometric mean
		System.out.println(gMean(arrayMaker(amount)));
	}
//method for making the array using amount(how big the array it)
	public static int[] arrayMaker (int amount) {
		Scanner keyboard = new Scanner (System.in);
		int values[] = new int [amount];
		for (int i=0;i<amount;i++){
			System.out.println("Value " + i + ":");
			values[i] = keyboard.nextInt();
			keyboard.nextLine();
		}
		return values;
	}
//calculates the gmean of the array
	public static double gMean (int[] values){
		double gmean = 1;
		for (int i=0; i < values.length;i++){
			gmean *=values[i];
		}
		double dValues = (double)values.length;
		return Math.pow(gmean,  1/dValues);
	}
}