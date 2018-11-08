/* This class displays a GUI from which you can send and receive Layer 2 frames.
 * 
 * by Josh Maguire
 * 4/23/2016
 */

/* INSTRUCTIONS
Create a class L3Display that functions similarly to the Layer2Display. The
documentation from my implementation explains it all.
 */
public class L3Display implements ActionListener, EventListener, L3Listener{
	/* Display 3 fields: a display field for putting status messages in 
	 * and displaying the values in received packets; a DestAddr field, 
	 * into which the user can type a destination address in the form x.y; a 
	 * payload field into which the user types a bit string (0s and 1s). 
	 * The title of the frame display's this endpoint's L3Address.
	 */
	public L3Display(L3Handler handler)
	{
		
	}
	//Called when the user hits enter in the GUI field, indicating that a L3 Packet should be created and sent.
	public void actionPerformed(ActionEvent e)
	{
		//Specified by:	actionPerformed in interface java.awt.event.ActionListener
	}
	
	/* Called when a frame is received in the handler from the layer below it. This
	 * function prints out info about the received frame in the displayField (where
	 * the packet came from and what payload it is carrying.
	 */
	public void packetReceived(L3Handler handler, L3Packet pkt)
	{
		//packetReceived in interface L3Listener
	}
}
