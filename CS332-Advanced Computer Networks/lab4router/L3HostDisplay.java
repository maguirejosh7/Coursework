import java.awt.event.*;
import javax.swing.*;

/**
 * This class displays a GUI from which you can send and receive Layer 3
 * frames.
 */
public class L3HostDisplay implements ActionListener, L3Listener
{
    private L3Iface iface;
    private JTextField displayField;
    private JTextField addressField;
    private JTextField payloadField;
    private L3Host host;

    /**
     * Display 3 fields: a display field for putting status messages in
     * and displaying the values in received packets; a DestAddr field,
     * into which the user can type a destination address in the form x.y;
     * a payload field into which the user types a character string.
     * The title of the frame display's this endpoint's L3Address.
     */
    public L3HostDisplay(L3Host host)
    {
	this.host = host;
	host.setListener(this);
	iface = host.getIface().get(0);

	JFrame frame = new JFrame("Host: " + host.toString() + " Address: " + iface.getAddr().toDottedDecimal());
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

	displayField = new JTextField(20);
	displayField.setEditable(false);
	frame.getContentPane().add(displayField);

	frame.getContentPane().add(new JLabel("DestAddr (x.y):"));

	addressField = new JTextField(20);
	addressField.addActionListener(this);
	frame.getContentPane().add(addressField);

	frame.getContentPane().add(new JLabel("Payload (char str):"));

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
		System.out.println("L3HostDisp: calling send to " + dest.toDottedDecimal() +
				   " from " + iface.getAddr().toDottedDecimal() );

		// This is a string of characters to convert.
		payload = convertAsciiString(payload);
		
		host.send(payload, dest);
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
    public void packetReceived(L3Handler iface, L3Packet pkt)
    {
	displayField.setText("From " + pkt.getSrcAddr().toDottedDecimal() +
			     ", Data " + binaryStringToAscii(pkt.getPayload()));
    }

    /**
     * Convert the given payload -- a string of ascii characters -- into a string
     * of bits.  Return that bit string.
     */
    private String convertAsciiString(String payload)
    {
	String res = "";
	for (int i = 0; i < payload.length(); i++) {
	    int val = (int) payload.charAt(i);
	    res += Layer2Frame.toBinary(val, 8);
	}
	return res;
    }

    /**
     * Convert the given payload -- a string of 0s and 1s -- into a string
     * of ascii characters.  Assumes the payload length is a multiple of 8.
     * Returns the ascii string.
     */
    private String binaryStringToAscii(String payload)
    {
	String res = "";
	for (int i = 0; i < payload.length() / 8; i++) {
	    int val = Layer2Frame.toDecimal(payload.substring(i * 8, (i+1) * 8));
	    char c = (char) val;
	    res += c;
	}
	return res;
    }
}
