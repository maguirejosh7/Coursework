/* LightPanel.Java
 * 
 * Creates a Light Desplay GUI
 * Created by a Calvin Professor
 * Copy Pasted by Josh Maguire on 2/17/2016
 * */

import java.awt.event.*;
import javax.swing.*;

public class LightDisplay extends Thread implements ActionListener
{
    private LightPanel panel;
    private ImageIcon lightOffIcon;
    private ImageIcon lightOnIcon;
    private JLabel lightLabel;

    public LightDisplay(LightPanel panel)
    {
	this.panel = panel;
	//create window panel
	JFrame frame = new JFrame();
	frame.setTitle(panel.toString());

	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
	//loading images
	lightOffIcon = new ImageIcon("lightoff.gif");
	lightOnIcon = new ImageIcon("lighton.gif");

	lightLabel = new JLabel(lightOffIcon);
	lightLabel.setBorder(BorderFactory.createEtchedBorder());
	frame.getContentPane().add(lightLabel);
	//creating buttons
	JButton onButton = new JButton("ON");
	onButton.setMnemonic(KeyEvent.VK_N);
	onButton.setActionCommand("on");
	onButton.addActionListener(this);
	frame.getContentPane().add(onButton);

	JButton offButton = new JButton("OFF");
	offButton.setMnemonic(KeyEvent.VK_F);
	offButton.setActionCommand("off");
	offButton.addActionListener(this);
	frame.getContentPane().add(offButton);

	frame.pack();
	frame.setVisible(true);

	start();
    }

    //button listeners
    public void actionPerformed(ActionEvent e)
    {
	if (e.getActionCommand().equals("on")) 
	    panel.switchOn();
	else
	    panel.switchOff();
    }

    //updates light display with status of lightpanel
    public void run()
    {
	while (true) { // /forever loop
	    if (panel.isOn())
		lightLabel.setIcon(lightOnIcon);
	    else
		lightLabel.setIcon(lightOffIcon);
	    try { Thread.sleep(1); } catch (InterruptedException e) {}
	}
    }
}
