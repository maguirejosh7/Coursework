/*
 * Lab11 by Joshua Maguire
 * makes lots of balls that move
 */
package edu.calvin.jlm54.lab11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class ParticleController extends JFrame {

	private ParticlePanel myPPanel;
	private JButton myPause, myRestart;

	public ParticleController(){

		myPPanel = new ParticlePanel();
		myPPanel.init();
		add(myPPanel, BorderLayout.NORTH);
		setTitle("Particle Collider");
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		//control panel
		JPanel control = new JPanel(new FlowLayout());
		
		myPause = new JButton("Pause");
		myRestart = new JButton ("restart");
		
		control.add(myPause);
		myPause.setEnabled(true);
		myPause.addActionListener(new PauseButtonListener());
		
		control.add(myRestart);
		myRestart.setEnabled(false);
		myRestart.addActionListener(new RestartButtonListener());
		add(control, BorderLayout.CENTER);

	}

	//LISTENERS
	class RestartButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myRestart.setEnabled(false);
			myPause.setEnabled(true);
			myPPanel.setRunningStatus(true);
		}
	}
	class PauseButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myPause.setEnabled(false);
			myRestart.setEnabled(true);
			myPPanel.setRunningStatus(false);
		}
	}

	public static void main(String[] args) {
		ParticleController P1 = new ParticleController();
		P1.pack();
		P1.setVisible(true);




	}
}