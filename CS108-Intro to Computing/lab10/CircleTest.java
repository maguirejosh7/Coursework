/*
 * Testing and debugging class of Circle program, which gets diameter of circle.
 * by Joshua Maguire on 11/1/2012
 */

package lab10;
import static org.junit.Assert.*;
import org.junit.Test;
public class CircleTest {
	@Test
	public void test() {
		assertTrue (true);
		assertEquals(3.14159,Math.PI,1e-3);
		try{//10.5 tests
			Circle TC1 = new Circle();
			assertEquals((TC1.getArea()),7850.0,1e-3);//should be true
			
			Circle TC2 = new Circle(1,1,2);
			assertEquals((TC2.getArea()),3.14,1e-3);//true

			Circle TC3 = new Circle(1,1,500);
			assertEquals((TC3.getArea()),196250.0,1e-3);//true
			
			Circle TC4 = new Circle(1,1,500);
			assertEquals((TC4.getArea()),7878.0,1e-3);//FALSE
		} catch (Exception E){
			System.out.println(E.getMessage());
		}
	}
}
