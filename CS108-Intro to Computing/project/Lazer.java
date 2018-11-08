package project;


import processing.core.PApplet;

/*
 * The lazer class governs all lazers. lazers
 * have position, speed, direction and status.
 * 
 * 
 */
public class Lazer {

	//	 instance
	private boolean myLazerStatus;
	private float myLazerX,myLazerY,myLazerSpeed,myLazerDirection;
//	lazerconstructor
	public Lazer(float x,float y,float speed, float direction,boolean status){
//		switch(type){
//			case "playerlazer":
				myLazerX=x;
				myLazerY=y;
				myLazerSpeed=speed;
				myLazerDirection=direction;
				myLazerStatus=status;
//		}
	}
	//accessors
	public float getLazerX(){
		return myLazerX;
	}
	public float getLazerY(){
		return myLazerY;
	}
	public float getLazerSpeed(){
		return myLazerSpeed;
	}
	public float getLazerDirection(){
		return myLazerDirection;
	}
	public boolean getLazerStatus(){
		return myLazerStatus;
	}
	//mutators
	public void setLazerStatus(boolean status){
		myLazerStatus=status;
	}
	public void setLazerX(float x){
		myLazerX=x;
	}
	public void setLazerY(float y){
		myLazerY=y;
	}
	//move
	public void moveLazer(int sizeX,int sizeY){
		myLazerY-=myLazerSpeed;
		myLazerX+=myLazerDirection;
		if (myLazerX<0||myLazerX>sizeX||myLazerY>sizeY||myLazerY<0){
			myLazerStatus=false;
		}
	}
	//render
	public void renderLazer(PApplet magicpen){
		magicpen.fill(120,0,180);
		magicpen.ellipse(myLazerX,myLazerY,10,10);
	}
}




