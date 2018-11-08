import java.awt.event.*;
import javax.swing.*;

/*
 * Displays a window on screen for a user to type a sequence of 1's and 0's that will be
 * broadcast to the LightSystem.
 */

public class BitDisplay implements ActionListener, BitListener
{
    private BitHandler handler;
    private JTextField receiveField;
    private JTextField sendField;

/*
 * Creates and displays the window for the user to enter the sequence of bits to be broadcast.
 * @param handler: the BitHandler object that is used to broadcast to the LightSystem.
 */
    public BitDisplay(BitHandler handler)
    {
	this.handler = handler;

	//Create the window
	JFrame frame = new JFrame(handler.toString());
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

	receiveField = new JTextField(20);
	receiveField.setEditable(false);
	frame.getContentPane().add(receiveField);

	sendField = new JTextField(20);
	sendField.addActionListener(this);
	frame.getContentPane().add(sendField);

	// Display the window to the user
	frame.pack();
	frame.setVisible(true);
	handler.setListener(this);
    }

	/*
	 * Upon receiving a sequence of bits from the user, broadcast them to the LightSystem.
	 * @throws CollisionException
	 */
    public void actionPerformed(ActionEvent e)
    {
	new Thread()
	{
	    public void run()
	    {
			try {
	    		handler.broadcast(sendField.getText());
			} catch(CollisionException ex) {
				receiveField.setText("Collision!");
				System.out.println("Collision!");
			}
		// System.out.println("actionPerformed: done sending " + sendField.getText());
	    }
	}.start();
	sendField.selectAll();
    }

	/*
	 * Display the sequence of bits that was received from the BitHandler.
	 * @param h: The BitHandler that we received bits from.
	 * @param bits: The sequence of bits that was received.
	 */
    public void bitsReceived(BitHandler h, String bits)
    {
	receiveField.setText(bits);
    }
}
