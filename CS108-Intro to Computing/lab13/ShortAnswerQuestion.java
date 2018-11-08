package edu.calvin.jlm54.lab13;

/**
 * ShortAnswerQuestion implements a simple question class that encapsulates a
 * question text (one String) and a correct answer (one String). An answer must
 * match the answer string to be considered correct.
 * 
 * @author kvlinden
 * @version Fall, 2009
 */
public class ShortAnswerQuestion extends Question {
//instance
	private String myAnswer;
//constructor
	public ShortAnswerQuestion(String text, String answer) {
		super(text);
		myText = text;
		myAnswer = answer;
	}
	
	
	
	
	@Override
	public String getQuestion() {
		return super.getText();
	}

	/**
	 * Return the answer to this question, potentially with helpful comments.
	 * 
	 * @return the answer
	 */
	@Override
	public String getAnswer() {
		return myAnswer;
	}

	/**
	 * Return true if the given answer is correct for this question.
	 * 
	 * @param answer
	 *            the user's answer
	 * @return true if and only if the given answer is correct
	 */
	@Override
	public boolean checkAnswer(String answer) {
		return answer.equalsIgnoreCase(myAnswer);
	}

}
