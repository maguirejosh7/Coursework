import java.awt.event.*;
import javax.swing.*;

/*
 * Defines the LightDisplay class which displays a window for each light
 * and allows the user to toggle the lights on and off.
 */

public class LightDisplay extends Thread implements ActionListener
{
    private LightPanel panel;
    private ImageIcon lightOffIcon;
    private ImageIcon lightOnIcon;
    private JLabel lightLabel;

	/*
	 * Constructor, creates a new Light in its own window.
	 * @param panel: a reference to the light panel that will be displayed.
	 */
    public LightDisplay(LightPanel panel)
    {
	this.panel = panel;

	// Create a new window and place the light and on/off buttons
	JFrame frame = new JFrame();
	frame.setTitle(panel.toString());

	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));

	lightOffIcon = new ImageIcon("lightoff.gif");
	lightOnIcon = new ImageIcon("lighton.gif");

	lightLabel = new JLabel(lightOffIcon);
	lightLabel.setBorder(BorderFactory.createEtchedBorder());
	frame.getContentPane().add(lightLabel);

	// Set characteristics of the on button
	JButton onButton = new JButton("ON");
	onButton.setMnemonic(KeyEvent.VK_N);
	onButton.setActionCommand("on");
	onButton.addActionListener(this);
	frame.getContentPane().add(onButton);

	// Set characteristics of the off button
	JButton offButton = new JButton("OFF");
	offButton.setMnemonic(KeyEvent.VK_F);
	offButton.setActionCommand("off");
	offButton.addActionListener(this);
	frame.getContentPane().add(offButton);

	// Display the window
	frame.pack();
	frame.setVisible(true);

	start();
    }

	/*
	 * onClick methods for the on/off buttons to toggle the lights.
	 * @param e: value of the button that was clicked.
	 */
    public void actionPerformed(ActionEvent e)
    {
	if (e.getActionCommand().equals("on"))
	    panel.switchOn();  // Turn the light on
	else
	    panel.switchOff();  // Turn the light off
    }

	/*
	 * Update the window once per second
	 */
    public void run()
    {
	while (true) {
	    if (panel.isOn())
		lightLabel.setIcon(lightOnIcon);
	    else
		lightLabel.setIcon(lightOffIcon);
	    try { Thread.sleep(1); } catch (InterruptedException e) {}
	}
    }
}
