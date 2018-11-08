package edu.calvin.jlm54.lab12a;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






/**
 * AnimationController shows a multi-image animation with various controls for
 * speed and direction.
 * 
 * @author Joshua Maguire
 * @version 11/15/2012
 */
@SuppressWarnings("serial")
public class AnimationController extends JFrame {
//instance data
	private final static String IMAGES_PATH = "src/edu/calvin/jlm54/lab12a/images/";
	private AnimationPanel myPanel;
	private JButton myPlay,myPause,myReverse;
//constructor
	public AnimationController()  {
		myPanel=new AnimationPanel(IMAGES_PATH + "muybridgeHorse/");
		myPanel.init();
		add(myPanel, BorderLayout.NORTH);
		setTitle("Animation Controller");
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		//button code
		JPanel control = new JPanel(new FlowLayout());
		add(control,BorderLayout.CENTER);
		myPlay = new JButton(new ImageIcon(IMAGES_PATH + "buttons/" + "play.gif"));
		myPlay.addActionListener(new PlayButtonListener());
		control.add(myPlay);
		myPlay.setEnabled(false);

		myPause = new JButton(new ImageIcon(IMAGES_PATH + "buttons/" + "pause.gif"));
		myPause.addActionListener(new PauseButtonListener());
		control.add(myPause);

		myReverse = new JButton(new ImageIcon(IMAGES_PATH + "buttons/" + "reverse.gif"));
		myReverse.addActionListener(new ReverseButtonListener());
		control.add(myReverse);




	}

	//Listeners
	class PauseButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myPlay.setEnabled(true);
			myPause.setEnabled(false);
			myPanel.setrunninigStatus(false);
			myReverse.setEnabled(true);
			myPanel.setreverseStatus(false);
		}
	}
	class PlayButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myPlay.setEnabled(false);
			myPause.setEnabled(true);
			myPanel.setrunninigStatus(true);
			myReverse.setEnabled(true);
			myPanel.setreverseStatus(false);
		}
	}
	class ReverseButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myReverse.setEnabled(false);
			myPause.setEnabled(true);
			myPlay.setEnabled(true);
			myPanel.setrunninigStatus(false);
			myPanel.setreverseStatus(true);
			
		}
	}



	public static void main(String[] args)  {
		AnimationController application = new AnimationController();
		application.pack();
		application.setVisible(true);
		application.setLocation(100, 100);
	}

}
