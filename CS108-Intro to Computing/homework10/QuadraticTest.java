//This is the test class of Quadratic that tests the key functionality by Joshua Maguire on 11/7/2012
package edu.calvin.jlm54.homework10;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuadraticTest {

	@Test
	public void test() {//tests KEY functionality 
		try{
			Quadratic tQ1 = new Quadratic(-5,90,-160);
			assertEquals(tQ1.lRoot(), 16,1e-3);
			
			Quadratic tQ2 = new Quadratic(-5,90,-160);
			assertEquals(tQ2.sRoot(), 2,1e-3);
			
			
		}
		catch (Exception E){
			System.out.println(E.getMessage());
		}
	
	}
}
