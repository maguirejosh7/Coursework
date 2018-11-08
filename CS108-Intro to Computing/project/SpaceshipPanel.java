
/*
 * main panel for game. has draw that renders everything. Also creates all
 * objects (at bottom) except myShip, which is near the top.
 * !!!!!also checks for collisions !!!!!!!
 * 
 * ********variables change lives, enemies, etc.
 * 
 * 
 */
 package project;
 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

public class SpaceshipPanel extends PApplet{

	//instance variables
	public final int SIZEX=500,SIZEY=600;//screensize
	private Star[] myStars;// background star objects array-Star class
	private Asteroid[] myAsteroids;//asteroid object array-Asteroid class
	private Ship myShip; //player ship-Ship class
	private Ship[] myEnemyShips;//enemy ship array-Ship class
	private Lazer[] myPlayerLazers;//player lazers-Lazer class
	private boolean wKey,aKey,sKey,dKey,//provides constant status for keys using myKeyListener and booleans
	myRunningStatus,waveComplete;
	private int numAsteroids,numEnemies,enemySpeed,numPlayerLazers,playerSpeed,numPlayerLives;
	private float myScore,myWave;
	
	//accessors and mutators
	public boolean getWaveComplete(){
		return waveComplete;
	}
	public void setWaveComplete(boolean status){
		waveComplete=status;
	}
	public boolean getRunningStatus(){
		return myRunningStatus;
	}
	public void setRunningStatus(boolean status){
		myRunningStatus=status;
	}
	
	
	//constructor for spaceshippanel
	public SpaceshipPanel(){//put difficulty in here(num lazers, enemies, etc)
		//initialize game variables************************
		numAsteroids=10;
		numEnemies=7;
		enemySpeed=3;
		numPlayerLazers=3;
		playerSpeed=2;
		numPlayerLives=3;
		myWave=1;
		myScore=0;
		
		//create objects (methods at bottom of page
		createStars(30);
		createAsteroids(numAsteroids);
		myShip=new Ship(250,500,playerSpeed,true);//(playership possition x,y,speed,status)
		createEnemyShips(numEnemies,enemySpeed,true);//(number enemyships,enemyship speed,status)
		createPlayerLazers(numPlayerLazers);//num player lazers
		//initialize things
		wKey=false;aKey=false;sKey=false;dKey=false;
		myRunningStatus = false;
		addKeyListener(new myKeyListener());//listens for keys that need booleans
		waveComplete=false;
	}
	//setting up screen, background,
	public void setup(){
		background(0);
		smooth();
		size(SIZEX,SIZEY);
	}



	public void draw() {//	-------------draw-------	\\
		if (myRunningStatus){
			//		background
			fill(0);
			rect(0,0,SIZEX,SIZEY);


			//!!!!!!!!!!checking for collisions!!!!!!!!!!!!		!!!!!		!!!!
			//myShip and Asteroids
			for(int i=0; i<myAsteroids.length;i++){
				if(myAsteroids[i].getmyAsteroidStatus()&&myShip.getShipStatus()&&dist(myShip.getShipX(),myShip.getShipY(),myAsteroids[i].getAsteroidX(),myAsteroids[i].getAsteroidY())<myAsteroids[i].getAsteroidSize()){
					myShip.setShipStatus(false);
					myAsteroids[i].setAsteroidStatus(false);
					myScore+=-50;
					numPlayerLives--;
				}
			}
			//myShip and enemyShips
			for(int i=0; i<myEnemyShips.length;i++){
				if(myShip.getShipStatus()&&myEnemyShips[i].getShipStatus()&&dist(myShip.getShipX(),myShip.getShipY(),myEnemyShips[i].getShipX(),myEnemyShips[i].getShipY())<20){
					myShip.setShipStatus(false);
					myEnemyShips[i].setShipStatus(false);
					numEnemies--;
					myScore+=-50;
					numPlayerLives--;
				}
			}
			//lazers and asteroids or enemyships
			//checks if each lazer[i] is hitting a asteroid or enemy at [ai] or [ei]
			for(int i=0; i<myPlayerLazers.length;i++){
				for(int ai=0; ai<myAsteroids.length;ai++){

					if(myPlayerLazers[i].getLazerStatus()&&myAsteroids[ai].getmyAsteroidStatus()&&dist(myPlayerLazers[i].getLazerX(),myPlayerLazers[i].getLazerY(),myAsteroids[ai].getAsteroidX(),myAsteroids[ai].getAsteroidY())<myAsteroids[ai].getAsteroidSize()){
						myAsteroids[ai].setAsteroidStatus(false);
						myPlayerLazers[i].setLazerStatus(false);
						myScore+=5;
					}
				}
				for(int ei=0; ei<myEnemyShips.length;ei++){

					if(myPlayerLazers[i].getLazerStatus()&&myEnemyShips[ei].getShipStatus()&&dist(myPlayerLazers[i].getLazerX(),myPlayerLazers[i].getLazerY(),myEnemyShips[ei].getShipX(),myEnemyShips[ei].getShipY())<20){
						myEnemyShips[ei].setShipStatus(false);
						myPlayerLazers[i].setLazerStatus(false);
						numEnemies--;
						myScore+=10;
					}
				}
			}
			//			!!!!!!!!!!!!!!!!!!!!		!!!!!!!!!!			!!!!!!!

			//		render stars
			fill(255);
			for(int i=0;i<myStars.length;i++){
				myStars[i].moveStar(SIZEX,SIZEY);
				myStars[i].renderStar(this);
			}

			//moving myShip depending on wasdKey booleans
			if(wKey){
				myShip.movePlayerShip('w', SIZEX, SIZEY);
			}
			if(aKey){
				myShip.movePlayerShip('a', SIZEX, SIZEY);
			}
			if(sKey){
				myShip.movePlayerShip('s', SIZEX, SIZEY);
			}
			if(dKey){
				myShip.movePlayerShip('d', SIZEX, SIZEY);
			}
			//		render myShip
			if(myShip.getShipStatus()){
				noStroke();
				myShip.renderMyShip(this);
			}
			//move and render Lazers
			//			if getlazerstatus[i]==true
			//				move and render lazer
			for(int i=0; i<myPlayerLazers.length;i++){
				if (myPlayerLazers[i].getLazerStatus()==true){
					myPlayerLazers[i].moveLazer(SIZEX, SIZEY);
					myPlayerLazers[i].renderLazer(this);
				}
			}


			//		move and render myAsteroids
			for(int i=0;i<myAsteroids.length;i++){
				if(myAsteroids[i].getmyAsteroidStatus()){
					myAsteroids[i].moveAsteroid(SIZEX,SIZEY);
					myAsteroids[i].renderAsteroid(this);
				}
				else{

				}
			}
			//move and render myEnemyShips
			for(int i=0;i<myEnemyShips.length;i++){
				if(myEnemyShips[i].getShipStatus()){
					myEnemyShips[i].moveEnemyShip(SIZEX,SIZEY);
					myEnemyShips[i].renderEnemyShip(this);
				}
			}
			//stage clear?
			if(numEnemies<1&&numPlayerLives>0){
				fill(255);
				textSize(50);
				text("WAVE"+myWave+"CLEAR!! \n pause to continue..", 10, 300);
				waveComplete=true;
			}
			//game over?
			if(numPlayerLives<1){
				fill(255,0,0);
				textSize(50);
				text("GAME OVER DUDE! \n Score:"+myScore+"\n Wave:"+myWave, 10, 300);
			}
			//draw points, lives, etc
			fill(100,100,255);
			textSize(15);
			text("Lives:"+numPlayerLives+"\n Score:"+myScore+"\n Wave:"+myWave,0,570);

		}
	}//		------draw----end-------			\\
	//keypressed events
	public void keyPressed(){
		if(myShip.getShipStatus()){
			switch(key){
			case ' ':
				//for lazer...if lazeri=false, mutate and set true.

				for(int i=0; i<myPlayerLazers.length;i++){
					if (myPlayerLazers[i].getLazerStatus()==false){
						myPlayerLazers[i].setLazerStatus(true);
						myPlayerLazers[i].setLazerX(myShip.getShipX());
						myPlayerLazers[i].setLazerY(myShip.getShipY());
						break;
					}

				}
			default:
			}
		}
	}
	//if dead, respawn at mouseclicked position with less lives
	public void mousePressed(){
		if(myShip.getShipStatus()==false&&numPlayerLives>0){
			myShip.setShipX(mouseX);
			myShip.setShipY(mouseY);
			myShip.setShipStatus(true);


		}
	}
	//keypressed events that require a constant status-moveship
	//some coding in this class is from:
	//http://www.zekkocho.com/java-games/82-java-move-an-object-using-the-arrow-keys-keylistener
	private class myKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				aKey = true;
				break;
			case KeyEvent.VK_D:
				dKey = true;
				break;
			case KeyEvent.VK_W:
				wKey = true;
				break;
			case KeyEvent.VK_S:
				sKey = true;
				break;
			}
		}
		public void keyReleased(KeyEvent e){
			switch (e.getKeyCode()){
			case KeyEvent.VK_A:
				aKey = false;
				break;
			case KeyEvent.VK_D:
				dKey = false;
				break;
			case KeyEvent.VK_W:
				wKey = false;
				break;
			case KeyEvent.VK_S:
				sKey = false;
				break;
			}
		}
	}
	//	create objects:
	//	stars
	public void createStars(int numstars){
		myStars=new Star[numstars];
		for(int i=0; i<myStars.length;i++){
			myStars[i]=new Star(random(500),random(600),random(1,8),random(1,5));
		}
	}
	//	asteroids
	public void createAsteroids(int numasteroids){
		myAsteroids=new Asteroid[numasteroids];
		for(int i=0; i<myAsteroids.length;i++){
			myAsteroids[i]=new Asteroid(random(500),random(-200,-10000),random(15,40),random(2,6),random(-6,6),true);
		}
	}
	//	enemyships
	public void createEnemyShips(int numenemyships,int enemyshipspeed,boolean status){
		myEnemyShips=new Ship[numenemyships];
		for(int i=0; i<myEnemyShips.length;i++){
			myEnemyShips[i]=new Ship(random(0,SIZEX),-1*random(50,1000),enemyshipspeed,status);
		}
	}
	//	lazers
	public void createPlayerLazers(int numPlayerLazers){
		myPlayerLazers=new Lazer[numPlayerLazers];
		for(int i=0; i<myPlayerLazers.length;i++){
			myPlayerLazers[i]=new Lazer(-20,-20,3,0,false);
		}
	}
}