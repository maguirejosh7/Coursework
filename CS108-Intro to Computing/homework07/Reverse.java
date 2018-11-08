//This program reverses numbers
//10/17/2012  by Joshua Maguire

package edu.calvin.jlm54.homework07;
import java.util.Scanner;
public class Reverse {
	
	//main
	public static void main(String[] args) {
		System.out.print("Please enter a positive integer: ");
		Scanner keyboard = new Scanner(System.in);
		int number = keyboard.nextInt();
		//prints "reversed is " then calls method reverse
		System.out.print(number + " reversed is ");
		reverse (number);
	}

//reverse method. uses % to extract and print last number, then
	//uses / to cut it off. repeats until number is gone.
	public static void reverse(int num){
		while (num !=0){
			System.out.print(num%10);
			num = num / 10;
		}
	}
}

