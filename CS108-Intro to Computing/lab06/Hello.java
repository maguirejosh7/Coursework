//This program simply asks for a name and outputs it with a welcome.
//By Joshua Maguire on 10/4/2012


//required at top stuff
package lab06;
import java.util.Scanner;

//required stuff for every program
public class Hello {
	public static void main(String[] args) {
	
		//outputs enter name
	System.out.print("Enter name:");
	
	//inputs the next keyboard line into a string
	Scanner keyboard = new Scanner(System.in);
	String userName = keyboard.nextLine();
	
	//outputs the string after "welcome"
	System.out.print("Welcome, "+ userName + "!");
	//
	
	}
}
