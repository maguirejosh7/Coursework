package edu.calvin.jlm54.lab13;
/*
 * class for question type that uses string and boolean. by Joshua Maguire on 12/6/2012
 */
public class TrueFalseQuestion extends Question{
//instance
	private boolean myAnswer;

	//constructor
	public TrueFalseQuestion(String text,boolean ans) {
		super(text);
		myAnswer=ans;
	}






	@Override
	public String getQuestion() {
		return super.getText()+"\nIs this statement true or false?";
	}

	/**
	 * Return the answer to this question, potentially with helpful comments.
	 * 
	 * @return the answer
	 */
	@Override
	public String getAnswer() {
		return new Boolean(myAnswer).toString();//casting myAnswer to boolean
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
		return getAnswer().equalsIgnoreCase(answer);
	}

}
