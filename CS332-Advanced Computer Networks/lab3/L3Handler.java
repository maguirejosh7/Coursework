/* This class represents a L3 object that can send and 
 * receive L3 frames. It receives packets from "below" 
 * as an L3ShimListener and passes packets up to any \
 * listener that has registered with it.
 * 
 *  by Josh Maguire
 *  4/23/2016
 */

/*	INSTRUCTIONS
Create a new class called L3Handler, which should store an L3Address, an
L3Shim, and an L3Listener. The L3Shim variable is a reference to the object
“below” this layer and the L3Listener object is the object called back when a L3
packet is received at this object and needs to be passed up to the higher layer.
Implement all the methods, as documented from my implementation.
Write the L3ShimListener interface, which defines the packetReceived()
method. 
 */
public class L3Handler extends java.lang.Object implements L3ShimListener 
{
	/* Create a L3Handler, given a layer 2 endpoint, and the network 
	 * part of the L3Address. The host part comes from the L2 address 
	 * in the layer 2 Handler. The code creates an L3Shim object 
	 * (and storing it), sets itself as a listener for that object, and
	 * creates and stores the L3Address for this object, from the given 
	 * netPart and layer 2's unique Mac address.
	 *  
	 */
	public L3Handler(L2GCHandler l2h, int netPart)
	{
		
	}
	
	//store a reference to a listener for packets received here
	public void setListener(L3Listener l)
	{
		
	}
	
	//Given a frame, convert it to a string of bits and send it using the L3Shim on layer 2 "below".
	public void send(L3Packet pkt)
	{
		
	}
	
	/* Drop any received packet that isn't for this interface. We'll
	 * override this in a router implementation that receives all 
	 * packets and forwards packets not destined for it.
	 */
	public boolean dropReceivedPacket(L3Packet pkt, String bits)
	{
		
	}
	
	/* Called when the layer below receives bits successfully. Like the
	 *  layer 2 implementation, it calls dropReceivedPacket to determine
	 *  if the received packet should be dropped, instead of passed on 
	 *  through the listener packetReceived() callback to the higher layer.
	 */
	public void packetReceived(L2GCHandler l2h, String bits)
	{
		//specified by: packetReceived in interface L3ShimListener
		
	}
	
	//getter for Address
	public L3Address getAddr()
	{
		
	}
}
