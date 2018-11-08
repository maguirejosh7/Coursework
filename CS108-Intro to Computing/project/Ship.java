package project;

/*ship class
 * makes all ships, and moves and renders them.
 * ships are ships, but they can be called/moved as
 * either player or enemy ships (because enemies are 
 * moved by the program and playership is moved by keys.
 * they are also rendered differently (difference in color, triangle...)
 */
import java.util.Random;

import processing.core.PApplet;

public class Ship {
	//instance
	// myEnemyShipX, myEnemyShipY,myEnemyShipSpeed,
	private float	myShipX,myShipY,myShipSpeed;
	private Random myRandomGenorator = new Random();
	private boolean myShipStatus;

	//constructor
	public Ship(float x, float y, int speed,boolean status){
		myShipX=x;
		myShipY=y;
		myShipSpeed=speed;
		myShipStatus=status;
	}
//	accessors and mutators
	public float getShipX(){
		return myShipX;
	}
	public float getShipY(){
		return myShipY;
	}
	public void setShipX(float x){
		myShipX=x;
	}
	public void setShipY(float y){
		myShipY=y;
	}
	public boolean getShipStatus(){
		return myShipStatus;
	}
	public void setShipStatus(boolean status){
		myShipStatus=status;
	}
//	move playership
	public void movePlayerShip(char key,int sizex, int sizey){
		switch (key){
		case 'w':
			if(myShipY>0){
				myShipY-=myShipSpeed;}
			break;
		case 'a':
			if(myShipX>0){
				myShipX-=myShipSpeed;}
			break;
		case 's':
			if(myShipY<sizey){
				myShipY+=myShipSpeed;}
			break;
		case 'd':
			if(myShipX<sizex){
				myShipX+=myShipSpeed;}
			break;
		default:
		}
	}
	//render ship
	public void renderMyShip(PApplet magicpen){
		magicpen.fill(0,255,20);
		magicpen.triangle(myShipX, myShipY-10, myShipX+10,myShipY+10,myShipX-10,myShipY+10);
	}
	//move enemyship
	public void moveEnemyShip(int sizeX,int sizeY){
		if(myShipY>sizeY+50){
			myShipY=-200-300*myRandomGenorator.nextFloat();
			myShipX=sizeX*myRandomGenorator.nextFloat();
		}
		else{
			myShipY+=myShipSpeed;
			if (myShipX<5){
				myShipX+=5;
			}
			else if(myShipX>sizeX-5){
				myShipX-=5;
			}
			else{
				myShipX+=5-10*myRandomGenorator.nextFloat();
			}
		}
		//random number...if num, shoot bullet aha(color,direction,speed)
	}
	//render enemyship
	public void renderEnemyShip(PApplet magicpen){
		magicpen.fill(204,0,0);
		magicpen.triangle(myShipX, myShipY+10, myShipX+10,myShipY-10,myShipX-10,myShipY-10);
	}
}

