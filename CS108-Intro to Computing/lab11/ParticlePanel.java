/*
 *Joshua Maguire, Lab11
 *
 */


package edu.calvin.jlm54.lab11;

import processing.core.PApplet;

public class ParticlePanel extends PApplet {
	/**
	 * MovingParticles implements multiple, random, moving/bouncing particles.
	 *
	 * @author kvlinden
	 * @version Spring, 2012
	 */
	public final int SIZE = 500;
	private float particleDiameter;

	private boolean myRunningStatus;
	private Particle[] myParticles;

	public ParticlePanel(){
		particleDiameter = 50;
		myRunningStatus = true;
		createParticles();

	}


	public void setup() {
		background(0);
		smooth();
		size(SIZE, SIZE);
	}

	public void createParticles(){
		myParticles = new Particle[10];
		for (int i = 0; i < myParticles.length; i++){
			myParticles[i]= new Particle(random(particleDiameter, SIZE - particleDiameter), random(particleDiameter, SIZE - particleDiameter), 50, random(-10, 10), random(-10, 10), color(random(255), random(255), random(255)));
		}

	}

	public void draw() {
		if (myRunningStatus==true){
			fill(0, 25);
			noStroke();
			rect(0, 0, width, height);
			for(int i = 0; i<myParticles.length; i++){				myParticles[i].move(SIZE, SIZE);
			myParticles[i].render(this);
			
			}

		}
	}



	public void setRunningStatus(boolean runningStatus){
		myRunningStatus = runningStatus;
	}



}
