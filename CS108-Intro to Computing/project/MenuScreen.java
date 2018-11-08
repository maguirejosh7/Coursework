package project;

/*
 * menu screen for game. imports image custom made by myself.
 * please take into account that the menu image 
 * took several hours to make.
 * 
 */
import processing.core.PApplet;
import processing.core.PImage;

public class MenuScreen extends PApplet{
	//instance vars
//	private final static String IMAGES_PATH = "C:\Users\magui\OneDrive\Documents\Archive\Calvin documents\Y1\1S\CS108\project";
	private PImage menuImage;
	
	public void setup(){
		size(500,600);
		background(100,100,100);
		smooth();
		menuImage=new PImage();
		menuImage=loadImage("menu.jpg");
//		= loadImage("menu.jpg");
	} 
	public MenuScreen(){
		
	}
	public void draw(){
		image(menuImage, 0, 0,500,600);
		fill(0,5,255);
		textSize(20);
		text("WASD keys to move, space to shoot, \n click to respawn at mouse location",10,550);
	
	}
}
