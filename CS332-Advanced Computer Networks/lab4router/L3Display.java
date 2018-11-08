import java.awt.event.*;
import javax.swing.*;

/**
 * This class displays a GUI from which you can send and receive Layer 3
 * frames.
 */
public class L3Display implements ActionListener, L3Listener
{
    private L3Handler handler;
    private JTextField displayField;
    private JTextField addressField;
    private JTextField payloadField;

    /**
     * Display 3 fields: a display field for putting status messages in
     * and displaying the values in received packets; a DestAddr field,
     * into which the user can type a destination address in the form x.y;
     * a payload field into which the user types a bit string (0s and 1s).
     * The title of the frame display's this endpoint's L3Address.
     */
    public L3Display(L3Handler handler)
    {
	this.handler = handler;
	handler.setListener(this);

	JFrame frame = new JFrame("Address: " + handler.getAddr().toDottedDecimal());
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

	displayField = new JTextField(20);
	displayField.setEditable(false);
	frame.getContentPane().add(displayField);

	frame.getContentPane().add(new JLabel("DestAddr (x.y):"));

	addressField = new JTextField(20);
	addressField.addActionListener(this);
	frame.getContentPane().add(addressField);

	frame.getContentPane().add(new JLabel("Payload (bit str):"));

	payloadField = new JTextField(20);
	payloadField.addActionListener(this);
	frame.getContentPane().add(payloadField);

	frame.pack();
	frame.setVisible(true);
    }

    /**
     * Called when the user hits enter in the GUI field, indicating that
     * a L3 Packet should be created and sent.
     */
    public void actionPerformed(ActionEvent e)
    {
	displayField.setText("Sending...");
	new Thread()
	{
	    public void run()
	    {
		L3Address dest = new L3Address(0, 0);
		dest.fromDottedDecimal(addressField.getText());
		String payload = payloadField.getText();
		System.out.println("L3Disp: calling send to " + dest.toDottedDecimal() +
				   " from " + handler.getAddr().toDottedDecimal() );
		// TODO: change to use L3Host.send().
		// handler.send(new L3Packet(dest, handler.getAddr(), payload));
		displayField.setText("");
	    }
	}.start();
    }

    /**
     * Called when a frame is received in the handler from the layer below it.
     * This function prints out info about the received frame in the
     * displayField (where the packet came from and what payload it is
     * carrying.
     */
    public void packetReceived(L3Handler handler, L3Packet pkt)
    {
	displayField.setText("From " + pkt.getSrcAddr().toDottedDecimal() +
			     ", Data " + pkt.getPayload());
    }
}