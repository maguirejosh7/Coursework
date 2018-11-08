package project;

/*
 * background stars (only for looks).
 * creates background stars that make the 
 * ship look like it's moving at an incredible
 * rate using it's interstellular universes engines
 * which move space around the ship rather than
 * moving the ship through space.
 * this allows for faster travel at the cost
 * of ridiculous gas prices.
 * similar to class Asteroid
 */
import java.util.Random;

import processing.core.PApplet;

public class Star {
	//instance 
	private float myStarX,myStarY,myStarSize,myStarSpeed;
	private Random myRandomGenorator = new Random();

	// constructor
	public Star(float x,float y,float size,float speed){
		myStarX=x;
		myStarY=y;
		myStarSize=size;
		myStarSpeed=speed;
	}
	//Accessors
	public float getStarX(){
		return myStarX;
	}
	public float getStarY(){
		return myStarY;
	}
	public float getStarSize(){
		return myStarSize;
	}
	public float getStarSpeed(){
		return myStarSpeed;
	}

//move star
	public void moveStar(int sizeX,int sizeY){
		
		
		if (myStarY > sizeY){
			myStarY = 0;
			myStarX=sizeX*myRandomGenorator.nextFloat();//float!!!
			myStarSize=6*myRandomGenorator.nextFloat();//float!!!
			myStarSpeed=1+(5*myRandomGenorator.nextFloat()); //Want this to be float(1.0,5.0)
		}
		else{
			myStarY+= myStarSpeed;
		}

	}
	//render star
	public void renderStar(PApplet magicpen){
		magicpen.fill(255);
		magicpen.ellipse(myStarX, myStarY, myStarSize, myStarSize);
	}
}
