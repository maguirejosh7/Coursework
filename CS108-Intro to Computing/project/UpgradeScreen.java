package project;

/*
 * upgrade screen for after completed waves. will have buttons and stuff
 * that upgrade weapons and lives for the Spaceship Panel(using accessors and
 * mutators)... as previously described... yeah.
 * will also have background image and whatnot. the next wave button
 * will actually work too.
 */
import processing.core.PApplet;

public class UpgradeScreen extends PApplet{
	public void setup(){
		size(500,600);
		background(255);
		smooth();
		
	}
//empty constructor	
	public UpgradeScreen(){
		
	}
	public void draw(){
		fill(100,100,255);
		textSize(15);
		text("buttons for upgrades (number of lazers, shotgun lazers,  etc \n in the form of buttons... \n notice the potential on this panel... \n  next wave button starts new wave with more enimies, asteroids, etc. \n from here, the next wave button \n would take you to the next round \n with harder enemies and upgradaded lazeres...",10,100);
	}
}
