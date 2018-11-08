/* BitDisplay.Java
 * 
 * Displays and controls a bitHandler handler
 *
 * Created by a Calvin Professor
 * Copiedby Josh Maguire on 2/20/2016
 * */
 
import java.awt.event.*;
import javax.swing.*;

public class BitDisplay implements ActionListener, BitListener
{
    private BitHandler handler;
    private JTextField receiveField;
    private JTextField sendField;

    public BitDisplay(BitHandler handler) 
    {//makin the gooie. goowie... guiy...goowey.
	this.handler = handler;

	JFrame frame = new JFrame(handler.toString());
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

	receiveField = new JTextField(20);
	receiveField.setEditable(false);
	frame.getContentPane().add(receiveField);
	//the text field!
	sendField = new JTextField(20);
	sendField.addActionListener(this);
	frame.getContentPane().add(sendField);

	frame.pack();
	frame.setVisible(true);
	handler.setListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
	new Thread()
	{
	    public void run()
	    {
	    	//try to send the textfield to the bitHandler broadcast method!
	    	try{
	    		handler.broadcast(sendField.getText()); //broadcast method calls broadcastOne/Zero, which could throw a collosionException, so we will catch it here.
	    	} catch (CollisionException e) {
	    		receiveField.setText("Collision!");
	    	}
		// System.out.println("actionPerformed: done sending " + sendField.getText());
	    }
	}.start();
	sendField.selectAll();
    }

    //set textfield to recieved bits!!!!
    public void bitsReceived(BitHandler h, String bits)
    {
	receiveField.setText(bits);
    }
    
    
}
