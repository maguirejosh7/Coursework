package edu.calvin.jlm54.lab13;
/*
 * class for question type- uses tro strings for question and answer. by Joshua Maguire on 12/6/2012
 */
public class FillInBlankQuestion extends Question{


//instance
	private String myAnswer;
	
	//constructor
	public FillInBlankQuestion(String text,String ans) {
		super(text);
		myAnswer=ans;
	}



	@Override
	public String getQuestion() {
		return super.getText()+"\nFill in the blank.";
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
