package edu.calvin.jlm54.lab13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simplequiz implements a list of quiz questions (only short-answer questions
 * in this version).
 * 
 * @author kvlinden
 * @version Fall, 2009
 */
public class Simplequiz {
//instance
	private List<Question> myQuestions;
	private int currentQuestion;
	
//constructor
	public Simplequiz() throws Exception {
		myQuestions = new ArrayList<Question>();

		myQuestions.add(new ShortAnswerQuestion("Who won the English football cup in 1949?",
				"Wolverhampton"));
		myQuestions.add(new ShortAnswerQuestion(
				"What is the name of Jerry Lee Lewis's biggest solid gold hit?",
				"Great Balls of Fire"));
		myQuestions.add(new ShortAnswerQuestion(
				"What?",
				"a"));
		myQuestions.add(new FillInBlankQuestion(
				"what is 2 + ___?",
				"2"));
		myQuestions.add(new TrueFalseQuestion(
				"what color is yellow?",
				true));

		Collections.shuffle(myQuestions);
		currentQuestion = 0;
	}

	/**
	 * Return the full specification for the current question.
	 * 
	 * @return the full question
	 */
	public String getCurrentQuestion() {
		return myQuestions.get(currentQuestion).getQuestion();
	}

	/**
	 * Return the answer to the current question
	 * 
	 * @return the answer
	 */
	public String getCurrentAnswer() {
		return myQuestions.get(currentQuestion).getAnswer();
	}

	/**
	 * Returns true if the given answer is correct for the current question.
	 * 
	 * @param answer
	 *            the user's answer
	 * @return true if and only if the given answer is correct
	 */
	public boolean checkCurrentAnswer(String answer) {
		return myQuestions.get(currentQuestion).checkAnswer(answer);
	}

	/**
	 * Returns true if this quiz has another question.
	 * 
	 * @return true if and only if this quiz has another question
	 */
	public boolean hasNext() {
		return currentQuestion < myQuestions.size() - 1;
	}

	/**
	 * Advance to the next question.
	 * 
	 * @throws Exception
	 *             if there are no more questions
	 */
	public void next() throws Exception {
		if (currentQuestion == myQuestions.size() - 1) {
			throw new Exception("There are no more questions.");
		}
		currentQuestion++;
	}

}
