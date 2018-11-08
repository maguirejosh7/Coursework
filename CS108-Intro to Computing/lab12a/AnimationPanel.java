package edu.calvin.jlm54.lab12a;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.List;
import java.util.ArrayList;


/**
 * AnimationPanel is the Processing-based animation panel used by
 * AnimationController.
 * 
 * @author Joshua Maguire
 * @version 11/15/2012
 */
@SuppressWarnings("serial")
public class AnimationPanel extends PApplet {
//instance data
	private int frameCounter;
	private List <PImage> myHorseImages;
	private boolean myrunningStatus;
	private boolean myreverseStatus;
//constructor for anamation panel
	public AnimationPanel(String path) {
		myrunningStatus = true;
		myreverseStatus = false;
		frameCounter=0;
		myHorseImages = new ArrayList <PImage>();
		for(int i=1;i<16;i++){
			myHorseImages.add(loadImage(path + "Muybridge_race_horse_" + i + ".gif"));
		}
	}

	public void setup() {
		size(myHorseImages.get(0).width, myHorseImages.get(0).height);
		frameRate(20);
	}

	public void draw() {
		background(255);
		image(myHorseImages.get(frameCounter), 0, 0);
		if (myrunningStatus){
			frameCounter = (frameCounter+1) % myHorseImages.size();
		}
		/*
		else if(myreverseStatus){
			frameCounter = (frameCounter-1) % myHorseImages.size();
		}
		*/
		
		else if (myreverseStatus){
			frameCounter = (frameCounter-1);
			if (frameCounter == 0){
				frameCounter = 15;
			}
		}
		
	}
	//change running status
	public void setrunninigStatus(boolean runningStatus){
		myrunningStatus = runningStatus;
	}
	//change reverse status
	public void setreverseStatus(boolean reverseStatus){
		myreverseStatus = reverseStatus;
	}
}
