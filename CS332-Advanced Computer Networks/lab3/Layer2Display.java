
/* Layer2Display defines the UI for sending layer 2 messages for group C
 * @author: Joel Stehouwer (jbs24)
 * @date: 3-9-2016
 */

import java.awt.event.*;
import javax.swing.*;

public class Layer2Display implements ActionListener, Layer2Listener
{
    private L2GCHandler handler;
    private JTextField displayField;
    private JTextField addressField;
    private JTextField payloadField;
	private JTextField destinationField;
	private JTextField receiveField;

    public Layer2Display(L2GCHandler handler)
    {
		this.handler = handler;
		handler.setListener(this);

		// Build the UI
		JFrame frame = new JFrame(handler.toString());
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
								   BoxLayout.PAGE_AXIS));

		frame.setTitle(handler.getMacAddr() + "");

		displayField = new JTextField(20);
		displayField.setEditable(false);
		frame.getContentPane().add(displayField);

		frame.getContentPane().add(new JLabel("Destination(s):"));

		destinationField = new JTextField(20);
		destinationField.addActionListener(this);
		frame.getContentPane().add(destinationField);

		frame.getContentPane().add(new JLabel("Payload:"));

		payloadField = new JTextField(20);
		payloadField.addActionListener(this);
		frame.getContentPane().add(payloadField);

		frame.getContentPane().add(new JLabel("Message Received:"));

		receiveField = new JTextField(20);
		receiveField.addActionListener(this);
		receiveField.setEditable(false);
		frame.getContentPane().add(receiveField);

		frame.pack();
		frame.setVisible(true);
    }

	/* Upon request, attempt to send the message to the destinations
	 *
	 */
    public void actionPerformed(ActionEvent e)
    {
		displayField.setText("Sending...");
		new Thread()
		{
			public void run()
			{
				// Parse the values from the UI
				String[] dest = destinationField.getText().split(",");
				String multi = (dest.length > 1) ? "1" : "0";
				String multiLength = (multi == "1") ? L2GCFrame.toBinary(dest.length, 4) : "";
				String dests = "";
				
				// If there are multiple destinations, this will convert them
				for (int i = 0; i < dest.length; i++) {
					dests += L2GCFrame.toBinary(Integer.parseInt(dest[i]), 8);
				}
				
				// Build the frame and send it
				L2GCFrame l2gcFrame = new L2GCFrame(L2GCFrame.toBinary(handler.getMacAddr(), 8) + "", multi, multiLength, dests, payloadField.getText());
				handler.send(l2gcFrame);
				displayField.setText("");

			}
		}.start();
    }

	/* Upon receiving a frame, display the received message
	 *
	 */
	public void frameReceived(L2GCHandler h, L2GCFrame f) {
		String bits = f.getPayload();
		receiveField.setText(bits);
	}

}
