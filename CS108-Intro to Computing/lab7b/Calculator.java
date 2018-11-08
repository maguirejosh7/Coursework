package edu.calvin.jlm54.lab7b;

/**
 * Calculator is a stub for the CalculatorController.
 * 
 * @author kvlinden
 * @version Fall, 2008
 */
public class Calculator {

	public static double calculate(double operand1, char operator, double operand2) throws Exception {
		switch(operator){
		case '+':
		case 'a':
		case 'p':
			return (operand1 + operand2);
		case '-':
		case 's':
			return (operand1 - operand2);
		case '*':
		case 'm':
			return (operand1 * operand2);
		case '/':
		case 'd':
			if (operand2 == 0){throw new IllegalArgumentException("cannot divide by 0.");}
			else{return (operand1 / operand2);}
		case 'S':
			return (summate((int)operand1));
		default:
			throw new Exception("illegal operator.");

		}
	}
	public static double summate (int n) throws Exception{
		if(n < 0){
			throw new Exception("operand must be positive");
		}
		if (n >0){
			return n + summate (n-1);
		}
		else{
			return 0;
		}}

}


