/* Driver program for quadratic equation program
 * by Joshua Maguire on 11/7/2012
 */
package edu.calvin.jlm54.homework10;
import java.util.Scanner;
public class QuadraticConsole {
	public static void main(String[] args) {
		try {
		System.out.println("test 1-------");
		Quadratic q1 = new Quadratic(-41,2,3);
		System.out.println (q1);
		System.out.println (q1.getEquation(5));
		System.out.println (q1.hasRoots());
		System.out.println("test 2-------------------------------------");
		Quadratic q2 = new Quadratic();
		System.out.println (q2);
		System.out.println (q2.getEquation(5));
		System.out.println (q2.hasRoots());
		System.out.println("test 3-------------------------------------");
		Quadratic q3 = new Quadratic(-87,8,-645);
		System.out.println (q3);
		System.out.println (q3.getEquation(5));
		System.out.println (q3.hasRoots());
		/*System.out.println("test 4-------------------------------------");
		Quadratic q4 = new Quadratic(-0,.37,1);
		System.out.println (q4);
		System.out.println (q4.getEquation(5));
		System.out.println (q4.hasRoots());
		*/
		System.out.println("test 5-------------------------------------");
		Quadratic q5 = new Quadratic(4253,.254,-.524);
		System.out.println (q5);
		System.out.println (q5.getEquation(5));
		System.out.println (q5.hasRoots());
		System.out.println("-------------HOMEWORK 10--------------------");
		
		}
		catch (Exception E){
			System.out.println(E.getMessage());
		}


	}
}
