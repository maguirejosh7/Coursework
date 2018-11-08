/* This class strips off the L3type field that is required to 
 * be at the front of each Layer 3 packet, and demultiplexes 
 * based on it -- calling the object that has registered as 
 * handling the packets of that type.
 * 
 * by Josh Maguire
 * 4/23/2016
 */

/* INSTRUCTIONS
The L3Shim has the same basic functionality as the Layer2Handler (and upcoming
L3Handler). The L3Shim layer is the layer in our model that handles the small 2-bit
field that all Layer 3 protocols must define as their first two bits – to uniquely identify the
type of protocol that follows those 2 bits. This is the class that will implement the
multiplexing and demultiplexing of layer 3 protocols within layer 2. Using the Javadoc
provided, implement L3Shim.java and L3ShimListener.java. Note that my
L3Shim class stores a 4-element array of L3ShimListeners. This size is hardcoded,
since we have defined the L3 shim to be 2 bits wide.
 */
public class L3Shim extends java.lang.Object implements Layer2Listener {
	
	//the uniquely-assigned identifier for the L3 protocol -- the main protocol for forwarding packets across multiple networks through routers.
	public static final int L3TYPE_L3 = 0; 
	public L3ShimListener listeners[] = new L3ShimListener[4]; 
	L2GCHandler handler;
	Layer2Listener layer2Listener;
	
	/* Create this object, storing the layer2 handler, and setting 
	 * this object as a listener of frames from that layer 2 object.
	 * @param: l, a L2GCHandler
	 */
	public L3Shim (L2GCHandler h)
	{
//		this.handler = h;
		handler = h;
		
		h.setListener(this); 
	}
	
	/* Called when a frame is received for this endpoint at layer 2. 
	 * This method checks the 2-bit layer 3 type field and calls an 
	 * object that has registered itself as being interested in 
	 * receiving packets of that type. If no object is interested, 
	 * the packet is dropped.
	 * @param: handler, a layer 2 handler
	 * @param: frame, a layer 2 frame
	 * specified in frameReceived in interface Layer2Listener
	 */
	public void frameReceived(L2GCHandler handler, L2GCFrame frame)
	{
		//check substring 0,2 of frame.payload and make sure it's == L3TYPE_L3
//		then send a frame (minus the 2 bits) using the handler
		
	}
	
	/* Given a string of bits to send, the layer 3 protocol these
	 * bits are part of, and the layer 2 destination to send the 
	 * data to, create the 2-bit layer 3 shim header, then create 
	 * the Layer2Frame and send the frame via layer 2.
	 * @param: bits, bit string to send
	 * @param: protocol we're using
	 * @param: destMac: destination mac address
	 */
	public void send(String bits, int protocol, int destMac)
	{
		//create a frame with protocol appended and bit string, send through our local handler "handler"
		
	}
	
	/* register a listener for the protocol with number protoType
	 * @param: protoType, the prototype we want to use
	 */
	public void setListener(L3ShimListener l, int protoType)
	{
		//make sure protocol type is valid (0-4)
		assert(protoType >= 0 && protoType <=4 );
		//make sure it's not used
		assert(listeners[protoType]==0);
		listeners[protoType] = l;
	}
}
