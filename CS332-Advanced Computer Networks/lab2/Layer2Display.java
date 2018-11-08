
/* Layer2Display
 * 
 * written by Josh Maguire
 * 3/23/2016
 * 
 * GUI for sending and receiving frames using text fields. 
 * */

import java.awt.event.*;
import javax.swing.*;

public class Layer2Display implements ActionListener, Layer2Listener {
	private L2GCHandler handler;
	private JTextField displayField;
	// add in other fields you need for your frame
	private JTextField addressField;
	private JTextField payloadField;

	public Layer2Display(L2GCHandler handler) {
		this.handler = handler;
		handler.setListener(this);

		JFrame frame = new JFrame(handler.toString());
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

		displayField = new JTextField(20);
		displayField.setEditable(false);
		frame.getContentPane().add(displayField);

		frame.getContentPane().add(new JLabel("Address:"));

		addressField = new JTextField(20);
		addressField.addActionListener(this);
		frame.getContentPane().add(addressField);

		frame.getContentPane().add(new JLabel("Payload:"));

		payloadField = new JTextField(20);
		payloadField.addActionListener(this);
		frame.getContentPane().add(payloadField);

		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		displayField.setText("Sending...");
		new Thread() {
			public void run() {
				L2GCFrame cf1 = new L2GCFrame(handler.getMacAddr(), 0, Integer.parseInt(addressField.getText()),
						payloadField.getText().length(), payloadField.getText());
				try {
					handler.send(cf1);
				} catch (CollisionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void frameReceived(L2GCHandler h, L2GCFrame f) {
		displayField.setText(f.getPayload());
	}

}