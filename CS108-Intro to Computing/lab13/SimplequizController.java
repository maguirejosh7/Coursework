package edu.calvin.jlm54.lab13;
/*
 * program that uses multiple classes for different types of questions,
 * inheritance and polymorphic behavior and super computer AI to outsmart foolish humans.
 * by Joshua Maguire on 12/6/2012
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * SimplequizController implements a GUI driver for Simplequiz.
 * 
 * @author kvlinden
 * @version Fall, 2009
 * @version Added inner class, Spring, 2012
 */
@SuppressWarnings("serial")
public class SimplequizController extends JFrame {
//instance
	private JTextArea questionArea;
	private JTextField answerField;
	private JLabel messageLabel;
	private Simplequiz simplequiz;
//constructor
	public SimplequizController() throws Exception {
		super("Simplequiz");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Font font = new Font("Ariel", 0, 18);

		questionArea = new JTextArea(7, 40);
		questionArea.setEditable(false);
		questionArea.setFont(font);
		add(questionArea, BorderLayout.NORTH);

		answerField = new JTextField(12);
		answerField.setFont(font);
		answerField.addActionListener(new AnswerFieldListener());
		add(answerField, BorderLayout.WEST);

		messageLabel = new JLabel();
		messageLabel.setFont(font);
		messageLabel.setText("\u21D0 Enter your answers here.");
		add(messageLabel, BorderLayout.CENTER);

		simplequiz = new Simplequiz();
		startQuiz();
	}
//listener
	class AnswerFieldListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				if (simplequiz.checkCurrentAnswer(answerField.getText())) {
					messageLabel.setText("Well done!");
				} else {
					messageLabel.setText("Sorry, the answer was " + simplequiz.getCurrentAnswer());
				}
				answerField.setText("");
				if (simplequiz.hasNext()) {
					try {
						simplequiz.next();
						startQuiz();
					} catch (Exception e) {
						// Control should never get here.
						endQuiz();
					}
				} else {
					endQuiz();
				}
			} catch (Exception e) {
				messageLabel.setText(e.getMessage());
			}
		}
	}

	private void startQuiz() {
		questionArea.setText(simplequiz.getCurrentQuestion());
	}

	private void endQuiz() {
		questionArea.setText("Quiz finished.");
		answerField.setEditable(false);
	}

	public static void main(String[] args) throws Exception {
		SimplequizController application = new SimplequizController();
		application.pack();
		application.setVisible(true);
	}

}
