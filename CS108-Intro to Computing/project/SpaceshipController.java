/*
 * PENTA S (beta)
 * by Joshua Maguire
 * sort of completed on 12/12/2012
 * 
 * 2d space shooter simulator game. use WASD for movement and
 * space to shoot. uses this class(SpaceshipController.java) to communicate with
 * classes UpgradeScreen,MenuScreen, and SpaceshipPanel,
 *  which communicates with classes:
 * Asteroid, Lazer, Ship, Star.
 * 
 * 
 * TODO:
 * tests		
 * 	
 * 	fix pause and resume requiring keys to be held
 * 	quit and play doesn't restart the game	
 * 	next waves working properly. for now change "game variables**************"
 * 			in the SpaceshipPanel Class to change gameplay.
 * 	enemy lazers!!!
 * 
 * 
 * keylistener example:
 * http://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
 * 
 * requesting focus found at:
 * http://stackoverflow.com/questions/2135223/obtaining-focus-on-a-jpanel
 */

package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SpaceshipController extends JFrame{

	//instance variables
	//private mySPanels[] SpaceshipPanel;
	private SpaceshipPanel mySPanel;
	private MenuScreen myMenu;
	UpgradeScreen myUPanel;
	private JButton myPause, myResume,myStart,myQuit,myUpgrades,myNext;

	public SpaceshipController(){

		setTitle("PENTA S");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//main game panel
		mySPanel = new SpaceshipPanel();
		mySPanel.init();
		add(mySPanel, BorderLayout.NORTH);
		mySPanel.setVisible(false);
		mySPanel.setFocusable(true);//as seen at http://stackoverflow.com/questions/2135223/obtaining-focus-on-a-jpanel
		//		mySPanel.requestFocus();

		//upgrade panel
		myUPanel=new UpgradeScreen();
		myUPanel.init();
		add(myUPanel, BorderLayout.NORTH);
		myUPanel.setVisible(false);
		//menu panel
		myMenu=new MenuScreen();
		myMenu.init();
		add(myMenu, BorderLayout.NORTH);
		myMenu.setVisible(true);




		//control panel
		JPanel control = new JPanel(new FlowLayout());


		//buttons for control panel
		myPause = new JButton("Pause");
		myResume = new JButton("Resume");
		myStart=new JButton("Start");
		myQuit=new JButton("quit");
		myUpgrades=new JButton("Upgrades");
		myNext=new JButton("Next Wave");
		
		//Start Button
		myStart.setEnabled(true);
		myStart.setVisible(true);
		myStart.addActionListener(new StartListener());
		control.add(myStart);
		//pause button
		myPause.setEnabled(false);
		myPause.setVisible(false);
		myPause.addActionListener(new PauseButtonListener());
		control.add(myPause);

		//resume button
		myResume.setEnabled(false);
		myResume.setVisible(false);
		myResume.addActionListener(new ResumeButtonListener());
		control.add(myResume);
		//quit button
		myQuit.setEnabled(false);
		myQuit.setVisible(false);
		myQuit.addActionListener(new QuitListener());
		control.add(myQuit);
		//upgradebutton
		myUpgrades.setEnabled(false);
		myUpgrades.setVisible(false);
		myUpgrades.addActionListener(new UpgradesActionListener());
		control.add(myUpgrades);
		//nextwavebutton
		myNext.setEnabled(false);
		myNext.setVisible(false);
		myNext.addActionListener(new NextActionListener());
		control.add(myNext);
		
		
		add(control, BorderLayout.SOUTH);
	}


	//listeners
	//pause
	class PauseButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent pe){
			myResume.setEnabled(true);
			myResume.setVisible(true);
			myPause.setEnabled(false);
			myPause.setVisible(false);
			mySPanel.setRunningStatus(false);
			myQuit.setEnabled(true);
			myQuit.setVisible(true);
			if(mySPanel.getWaveComplete()){
				myUpgrades.setEnabled(true);
				myUpgrades.setVisible(true);
			}

		}
	}
	//resume
	class ResumeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent re){
			myPause.setEnabled(true);
			myPause.setVisible(true);
			myResume.setEnabled(false);
			myResume.setVisible(false);
			mySPanel.setRunningStatus(true);
			myQuit.setEnabled(false);
			myQuit.setVisible(false);
			mySPanel.requestFocus();
		}
	}
	//start
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent se){
			myMenu.setVisible(false);
			mySPanel.setVisible(true);
			mySPanel.setRunningStatus(true);
			myPause.setVisible(true);
			myPause.setEnabled(true);
			myStart.setVisible(false);
			myStart.setEnabled(false);
			mySPanel.requestFocus();


		}
	}
	//quit QuitButtonListener
	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent qe){
			mySPanel.setRunningStatus(false);
			mySPanel.setVisible(false);
			myPause.setVisible(false);
			myPause.setEnabled(false);
			myResume.setVisible(false);
			myResume.setEnabled(false);
			myStart.setVisible(true);
			myStart.setEnabled(true);
			myQuit.setEnabled(false);
			myQuit.setVisible(false);
			myMenu.setVisible(true);
		}
	}
	//upgrades listener
	class UpgradesActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ue){
			mySPanel.setRunningStatus(false);
			mySPanel.setVisible(false);
			myPause.setVisible(false);
			myPause.setEnabled(false);
			myResume.setVisible(false);
			myResume.setEnabled(false);
			myQuit.setEnabled(false);
			myQuit.setVisible(false);
			myUPanel.setVisible(true);
			myUpgrades.setEnabled(false);
			myUpgrades.setVisible(false);
			myNext.setVisible(true);
			myNext.setEnabled(true);
		}
	}
	//next listener
	class NextActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ne){
			myNext.setVisible(false);
			myNext.setEnabled(false);
			
			myMenu.setVisible(false);			
			myPause.setVisible(true);
			myPause.setEnabled(true);
			myStart.setVisible(false);
			myStart.setEnabled(false);
			
			/*
			 * was going to try and re-create the mySPanel and
			 * use its constructor, accessors and mutators (which I haven't
			 * made yet) to change the "game variables" -num enemies, lives, bullets, etc
			 * ...from there I could start to take advantage of the up-
			 * grade screen.
			 */
//			mySPanelnull(then make the same one over again
			//or...
//			i++
//			mySPanel[i] = new SpaceshipPanel(wavenum,enemies,lives,score,etc);
//			mySPanel[i].init();
//			add(mySPanel[i], BorderLayout.NORTH);
//			mySPanel[i].setEnabled(true);
//			mySPanel[i].setVisible(true);
//			mySPanel[i].setRunningStatus(true);
//			mySPanel[i].requestFocus();
//this would create a new SpaceshipPanel every round
		}
	}

	public static void main(String[] args) {
		SpaceshipController S1 = new SpaceshipController();
		S1.pack();
		S1.setVisible(true);

	}
}
