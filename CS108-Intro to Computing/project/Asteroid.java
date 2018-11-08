package project;

/*
 * class for creating asteroids. when they are
 *  destroyed or goes off screen, they respawn
 *  randomly at the top again. uses size, position,
 *  speed, direction variables. Similar to Star class.
 * 
 */

import java.util.Random;
import processing.core.PApplet;


public class Asteroid {
	//instance
	public float myAsteroidX,myAsteroidY,myAsteroidSpeed,myAsteroidSize,myAsteroidDirection;
	private Random myRandomGenorator = new Random();
	boolean myAsteroidStatus;
	//constructor
	public Asteroid(float x, float y, float size,float speed, float direction,boolean status){
		myAsteroidX=x;
		myAsteroidY=y;
		myAsteroidSize=size;
		myAsteroidSpeed=speed;
		myAsteroidDirection=direction;
		myAsteroidStatus = status;
	}
	//Accessors
	public float getAsteroidX(){
		return myAsteroidX;
	}
	public float getAsteroidY(){
		return myAsteroidY;
	}
	public float getAsteroidSize(){
		return myAsteroidSize;
	}
	public float getAsteroidSpeed(){
		return myAsteroidSpeed;
	}
	public float getAsteroidDirection(){
		return myAsteroidDirection;
	}
	public boolean getmyAsteroidStatus(){
		return myAsteroidStatus;
	}

	//mutators
	public void setAsteroidX(float x){
		myAsteroidX=x;
	}
	public void setAsteroidY(float y){
		myAsteroidY=y;
	}
	public void setAsteroidStatus(boolean status){
		myAsteroidStatus=status;
	}
	//move Asteroid
	public void moveAsteroid(int sizeX,int sizeY){
		if (myAsteroidY > sizeY+50||myAsteroidX<-50||myAsteroidX>sizeX+50){
			resetAsteroid(sizeX,sizeY);
		}
		else{
			myAsteroidY+= myAsteroidSpeed;
			myAsteroidX+=myAsteroidDirection;
		}
	}
	//	render Asteroid
	public void renderAsteroid(PApplet magicpen){
		magicpen.fill(255,180,0);
		magicpen.ellipse(myAsteroidX, myAsteroidY, myAsteroidSize, myAsteroidSize);
	}
	//reset Asteroid
	public void resetAsteroid(int sizeX,int sizeY){
		myAsteroidY = -200-300*myRandomGenorator.nextFloat();;
		myAsteroidX=50-(sizeX+100)*myRandomGenorator.nextFloat();
		myAsteroidSize=15+25*myRandomGenorator.nextFloat();
		myAsteroidSpeed=2+(4*myRandomGenorator.nextFloat()); 
		myAsteroidDirection=5-(10*myRandomGenorator.nextFloat());
	}
}
