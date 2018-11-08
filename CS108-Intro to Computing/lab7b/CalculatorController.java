/*
 * This program by Joshua Maguire made on 11/30/2012 
 * uses a gui to let the user enter numbers to calculate the answers and stuff like that.
 * Wow! So super awesommme.
 * enjoy---
 */
package edu.calvin.jlm54.lab7b;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CalculatorControllerStarter presents a simple textfield-based GUI to an
 * arithmetic calculator, but doesn't implement any of the interactive behavior.
 * 
 * @author kvlinden
 * @version Fall, 2008
 */
@SuppressWarnings("serial")
public class CalculatorController extends JFrame {

	private JTextField operand1Field, operatorField, operand2Field, resultField;
	private JLabel messageLabel;
	private char operator;
	private double operand1,operand2;
	private double result;
/*
 * operand1Field is the first text imput field, the first number calculated
 * operand2Field is the third text field and the second num calculated
 * operator is the second text field, put +,=,/,*,p,a,m,s,d, ie ==r S for Summation.
 */
	public CalculatorController() {
		setTitle("iCalculate");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Font font = new Font("Ariel", 0, 28);

		JPanel calculatorPanel = new JPanel(new FlowLayout());
		operand1Field = new JTextField(4);
		operand1Field.setFont(font);
		operand1Field.addActionListener(new calculateListener());
		calculatorPanel.add(operand1Field);

		operatorField = new JTextField(1);
		operatorField.setFont(font);
		operatorField.addActionListener(new calculateListener());
		calculatorPanel.add(operatorField);

		operand2Field = new JTextField(4);
		operand2Field.setFont(font);
		operand2Field.addActionListener(new calculateListener());
		calculatorPanel.add(operand2Field);

		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setFont(font);
		calculatorPanel.add(equalsLabel);

		resultField = new JTextField(15);
		resultField.setFont(font);
		resultField.setBackground(Color.WHITE);
		resultField.setEditable(false);
		calculatorPanel.add(resultField);

		add(calculatorPanel, BorderLayout.CENTER);

		messageLabel = new JLabel("Welcome iCalculate");
		add(messageLabel, BorderLayout.SOUTH);



	}
	class calculateListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			try{
			operand1 = Double.parseDouble(operand1Field.getText());
			operator = operatorField.getText().charAt(0) ;
			operand2 = Double.parseDouble(operand2Field.getText());
				result=Calculator.calculate(operand1, operator, operand2);
				
			}catch (NumberFormatException b){
				messageLabel.setText("please use numbers, not letters...come on man...");
			}
			catch (Exception Ee){
				messageLabel.setText(Ee.getMessage());
			}

			resultField.setText(Double.toString(result));
			
		}
	}


	public static void main(String[] args) {
		CalculatorController application = new CalculatorController();
		application.pack();
		application.setVisible(true);

	}

}
