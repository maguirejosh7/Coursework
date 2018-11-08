
/*
 * JUnit tests for some of the classes. Tests
 * their accessors, mutators, move methods and
 * constructors.
 */
 
 package project;
 
import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceshipTest {

	@Test
				//testing ship class
	public void ShipTest() {
		try{
			Ship testShip=new Ship(250,500,3,true);
			//			accessors and mutators
			assertTrue(testShip.getShipStatus());
			assertEquals(250,testShip.getShipX(),1e-3);
			assertEquals(500,testShip.getShipY(),1e-3);
			//moving testShip
			testShip.setShipX(10);
			assertEquals(10,testShip.getShipX(),1e-3);
			testShip.movePlayerShip('a',500,600);
			assertEquals(7,testShip.getShipX(),1e-3);
			//out of screen?
			testShip.movePlayerShip('a',500,600);
			testShip.movePlayerShip('a',500,600);
			testShip.movePlayerShip('a',500,600);
			testShip.movePlayerShip('a',500,600);
			assertEquals(-2,testShip.getShipX(),1e-3);

		}catch(Exception E){
			System.out.println(E.getMessage());

		}
	}
	//testing asteroids

	public void AsteroidTest() {
		try{
			Asteroid[] testAsteroid;
			testAsteroid=new Asteroid[3];
			testAsteroid[2]=new Asteroid(8,10,12,14,16,true);
			testAsteroid[2].moveAsteroid(500,600);
			assertEquals(24,testAsteroid[2].getAsteroidX(),1e-3);
			assertEquals(24,testAsteroid[2].getAsteroidY(),1e-3);

		}catch(Exception E){
			System.out.println(E.getMessage());

		}

	}
	//testing lazer class
	public void LazerTest() {
		try{
			Lazer[] testLazers;
			testLazers=new Lazer[2];
			testLazers[2]=new Lazer(20,25,2,5,false);
			assertEquals(20,testLazers[2].getLazerY(),1e-3);
			assertEquals(25,testLazers[2].getLazerX(),1e-3);
			testLazers[2].moveLazer(500,600);
			assertEquals(30,testLazers[2].getLazerX(),1e-3);
			assertEquals(27,testLazers[2].getLazerY(),1e-3);
			

		}catch(Exception E){
			System.out.println(E.getMessage());

		}
	}
	//testing Star class
	public void Startest() {
		try{
			Star[] testStars;
			testStars=new Star[2];
			testStars[2]=new Star(2,3,50,5);
			assertEquals(3,testStars[2].getStarY(),1e-3);
			assertEquals(2,testStars[2].getStarX(),1e-3);
			testStars[2].moveStar(500,600);
			assertEquals(8,testStars[2].getStarY(),1e-3);
			

		}catch(Exception E){
			System.out.println(E.getMessage());

		}
	}
}
