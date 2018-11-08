package edu.calvin.jlm54.lab11;

import processing.core.PApplet;

public class Particle {
	//instance data
	private float myparticleX,myparticleY,myparticleVelocityX,myparticleVelocityY,myparticleDiameter;
	private int myparticleColor;

	//Default constructor
	public Particle(){ 
		myparticleX = 20;
		myparticleY = 20;
		myparticleColor = 20;
		myparticleDiameter = 50;
		myparticleVelocityX = 20;
		myparticleVelocityY=20;
	}
	//explicit-value constructor
	public Particle(float x,float y,float Diameter,float VelocityX,float VelocityY,int Color){
		myparticleX = x;
		myparticleY = y;
		myparticleColor = Color;
		myparticleDiameter = Diameter;
		myparticleVelocityX= VelocityX;
		myparticleVelocityY= VelocityY;
	}
	//Accessors
	public float getparticleX(){
		return myparticleX;
	}
	public float getparticleY(){
		return myparticleY;
	}


	public void render(PApplet magicPen ) {
		magicPen.fill(myparticleColor);
		magicPen.ellipse(myparticleX, myparticleY, myparticleDiameter, myparticleDiameter);
	}


	public void move(int width, int height) {
		if (myparticleX < myparticleDiameter/2 || myparticleX > width - myparticleDiameter/2) {
			myparticleVelocityX *= -1;
		}
		myparticleX += myparticleVelocityX;
		if (myparticleY < myparticleDiameter/2 || myparticleY > height - myparticleDiameter/2) {
			myparticleVelocityY *= -1;
		}
		myparticleY += myparticleVelocityY;
	}




}
