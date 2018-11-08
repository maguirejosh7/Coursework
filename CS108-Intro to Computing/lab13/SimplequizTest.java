package edu.calvin.jlm54.lab13;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SimplequizTest tests the functionality of Simplequiz's individual question
 * classes. It doesn't test the Simplequiz mechanism itself.
 * 
 * @author kvlinden
 * @version Fall, 2009
 */
public class SimplequizTest {

	@Test
	public void shortAnswerQuestionTest() {
		ShortAnswerQuestion q = new ShortAnswerQuestion("a question", "answer");
		assertTrue(q.checkAnswer("answer"));
		assertEquals("a question", q.getQuestion());
		assertEquals("answer", q.getAnswer());
		
		
		FillInBlankQuestion r = new FillInBlankQuestion("a question", "answer");
		assertTrue(r.checkAnswer("answer"));
		assertEquals("a question"+"\nFill in the blank.", r.getQuestion());
		assertEquals("answer", r.getAnswer());
		
		
		TrueFalseQuestion s = new TrueFalseQuestion("a question", true);
		assertTrue(s.checkAnswer("true"));
		assertEquals("a question"+"\nIs this statement true or false?", s.getQuestion());
		assertEquals("true", s.getAnswer());
	}
}
