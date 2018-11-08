package edu.calvin.jlm54.lab7b;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void calculateTest1() {

		try{
			assertEquals(2.0, Calculator.calculate(1, '+', 1), 1e-3);
			assertEquals(0, Calculator.calculate(1, '-', 1), 1e-3);
			assertEquals(4.0, Calculator.calculate(2, '*', 2), 1e-3);
			assertEquals(3.0, Calculator.calculate(6, '/', 2), 1e-3);
			assertEquals(-2.0, Calculator.calculate(-1, '+', -1), 1e-3);
			
			assertEquals(2.0, Calculator.calculate(1, 'a', 1), 1e-3);
			assertEquals(0, Calculator.calculate(1, 's', 1), 1e-3);
			assertEquals(4.0, Calculator.calculate(2, 'm', 2), 1e-3);
			assertEquals(3.0, Calculator.calculate(6, 'd', 2), 1e-3);
			assertEquals(-2.0, Calculator.calculate(-1, 'a', -1), 1e-3);
			//summate tests
			assertEquals(0, Calculator.calculate(0, 'S', -1), 1e-3);
			assertEquals(15, Calculator.calculate(5, 'S', -1), 1e-3);
		} catch (Exception E){
			fail();
		}
	}
	@Test
	public void calculateTest2() {

		try{
			Calculator.calculate(6, '/', 0);

			//fail("should throw exception");
		} catch (Exception E){
			fail();
			System.out.println(E.getMessage());
		}
	}
	@Test//summation negetive test
	public void calculateTest3() {

		try{
			assertEquals(-15, Calculator.calculate(-5, 'S', -1), 1e-3);

			//fail("should throw exception");
		} catch (Exception E){
			fail();
			System.out.println(E.getMessage());
		}
	}
}
