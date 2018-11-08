package edu.calvin.jlm54.lab07;
import java.util.Scanner;

public class ConsumptionSongConsoleDriver {
	//setup
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		//verses
		System.out.print("number of verses: ");
		int quantity = keyboard.nextInt();
		keyboard.nextLine();  

		//conatainer
		System.out.print("\ncontainer: ");
		String container = keyboard.nextLine();

		//substance
		System.out.print("\nsubstance: ");
		String substance = keyboard.nextLine();

		//calling makeSong method
		String song = makeSong(quantity, container, substance);
		//printing song and DONE
		System.out.println(song);
		System.out.println("DONE");
	}

//make song method. Creates song depending on quantity
	public static String makeSong (int quantity, String container, String substance){
		String result = "";

// loops testing if it should be the end of the song or not
		for (int count = quantity; count >= 0; count = count -1){
			result += (count + " " + pluralize(container,count) + " of " + substance + " on the wall, " + count + " " + pluralize(container,count) + " of " + substance + ".");

			if (count != 0) {
				result += " Take one down, pass it around. " + (count - 1) + " " + pluralize(container,(count-1)) + " of " + substance + " on the wall.\n";
			}
			else {
				result += (" Go to the store and buy some more. " + quantity + " " + pluralize(container,count) + " of " + substance + " on the wall.");
			}
		}
		return result;
	}
	//Method used to figure out pluralization for some parts of the sing
	public static String pluralize (String container, int count){
		if (count == 1){
			return container;
		}
		else{
			container = container + "s";
			return container;
		}
	}
}
