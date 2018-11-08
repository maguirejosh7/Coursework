/**
 * This class strips off the L3type field that is required to be at the
 * front of each Layer 3 packet, and demultiplexes based on it -- calling
 * the object that has registered as handling the packets of that type.
 */
public class L3Shim implements Layer2Listener
{
    /**
     * L3TYPE_L3 is the uniquely-assigned identifier for the L3 protocol --
     * the main protocol for forwarding packets across multiple networks
     * through routers.
     */
    public static final int L3TYPE_L3 = 0;
    // Define other layer 3 protocols here.
    
    // 2 bits used to distinguish between up to 4 higher protocols.
    private L3ShimListener listeners[] = new L3ShimListener[4];

    private Layer2Endpoint l2e;

    /**
     * Create this object, storing the layer2 endpoint, and setting
     * this object as a listener of frames from that layer 2 object.
     */
    public L3Shim(Layer2Endpoint le)
    {
	l2e = le;
	l2e.setListener(this);
    }

    /**
     * Called when a frame is received for this endpoint at layer 2.
     * This method checks the 2-bit layer 3 type field and calls an
     * object that has registered itself as being interested in receiving
     * packets of that type.  If no object is interested, the packet is dropped.
     */
    public void frameReceived(Layer2Handler handler, Layer2Frame frame)
    {
	String payload = frame.getPayload();
	int protocol = Layer2Frame.toDecimal(payload.substring(0, 2));
	if (listeners[protocol] == null) {
	    System.err.println("Received packet for protocol " + protocol +
			       " but no listener registered to receive it. " +
			       "Dropping.");
	} else {
	    // Call the object registered to receive pkts for this protocol
	    // passing in the packet without the shim on the front. 
	    listeners[protocol].packetReceived(l2e, payload.substring(2));
	}
    }

    /**
     * Given a string of bits to send, the layer 3 protocol these bits
     * are part of, and the layer 2 destination to send the data to,
     * create the 2-bit layer 3 shim header, then create the Layer2Frame
     * and send the frame via layer 2.
     */
    public void send(String bits, int protocol, int destMac)
    {
	assert protocol >= 0 && protocol < 4;
	// Prepend the 2-bit L3type field value.
	bits = Layer2Frame.toBinary(protocol, 2) + bits;
	Layer2Frame fr = new Layer2Frame(destMac, l2e.getMacAddr(), l2e.getVlanId(), bits);
	l2e.send(fr);
    }

    /**
     * register a listener for the protocol with number protoType.
     */
    public void setListener(L3ShimListener l, int protoType)
    {
	assert protoType >= 0 && protoType < 4;
	assert listeners[protoType] == null;
	listeners[protoType] = l;
    }

}