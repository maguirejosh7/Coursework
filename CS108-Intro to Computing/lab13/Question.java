package edu.calvin.jlm54.lab13;

public abstract class Question {
	//instance
	public String myText;
	
	
	//constructor
	public Question(String text){
		myText = text;
	}
	
	//accessor
	public String getText(){
		return myText;
	}
	
	
	

	public abstract String getQuestion() ;

	public abstract String getAnswer() ;

	public abstract boolean checkAnswer(String answer) ;
}
