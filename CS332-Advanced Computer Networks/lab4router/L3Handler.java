
/**
 * This class represents a L3 object that can send and receive
 * L3 frames. It receives packets from "below" as an L3ShimListener and passes
 * packets up to any listener that has registered with it.
 */
public abstract class L3Handler implements L3ShimListener
{
    private L3Shim handler;
    private L3Listener listener;    // we'll inform this listener if we receive a packet
    L3Address myAddr;

    /**
     * Create a L3Handler, given a layer 2 endpoint, and the network part
     * of the L3Address.  The host part comes from the L2 address in the
     * layer 2 endpoint.  The code creates an L3Shim object (and storing it),
     * sets itself as a listener for that object, and creates and stores
     * the L3Address for this object, from the given netPart and layer 2's
     * unique Mac address.
     */
    public L3Handler(Layer2Endpoint l2e, int netPart)
    {
	handler = new L3Shim(l2e);
	handler.setListener(this, L3Shim.L3TYPE_L3);
	myAddr = new L3Address(netPart, l2e.getMacAddr());
    }

    /**
     * Store a reference to a listener for packets received
     * here.
     */
    public void setListener(L3Listener l)
    {
	assert listener == null;
	listener = l;
    }

    /**
     * Given a packet, and nextHop L3Address, convert the 
     * pkt to a string of bits and send the packet to the 
     * nextHop's L2 address via the L3Shim "below".
     */
    public void send(L3Packet pkt, L3Address nextHop)
    {
	String bits = pkt.toString();
	System.err.println("L3H.send: pkt bits = " + bits);
	// The host part of the destination address is its unique mac address!
	// If the host part is broadcast, the lower layer will use bcast, whether
	// the network part is bcast or not.  This is acceptable.
    handler.send(bits, L3Shim.L3TYPE_L3, nextHop.getHost());
    }

    /**
     * Drop any received packet that isn't for this interface.
     * We'll override this in a router implementation that receives all
     * packets and forwards packets not destined for it.
     */
    public boolean dropReceivedPacket(L3Packet pkt, String bits)
    {
        throw new RuntimeException("Shouldn't get here, this method is defined in L3Iface!");
    }

    /**
     * Called when the layer below receives bits successfully.  Like
     * the layer 2 implementation, it calls dropReceivedPacket to determine
     * if the received packet should be dropped, instead of passed on
     * through the listener packetReceived() callback to the higher layer.
     */
    public void packetReceived(Layer2Endpoint l2e, String bits)
    {
	try {
	    L3Packet pkt = new L3Packet(bits);

	    // Throw away the pkt if it is supposed to be filtered out.
	    // The default behavior here is to throw out all packets that
	    // are not destined for myAddr.  A router might override this
	    // function to accept all packets, and forward some.
	    if (dropReceivedPacket(pkt, bits)) {
		System.out.println("Dropping pkt for " + pkt.getDestAddr().toDottedDecimal());
		return;
	    }
	    if (listener != null) {
		listener.packetReceived(this, pkt);
	    }
	} catch (Exception e) {
	    System.err.println("Bad L3 packet.  Dropping..." + e);
	}
    }

    // getters
    public L3Address getAddr() { return myAddr; }

    public String toString()
    {
        return "this is the L3 handler with address " + this.myAddr.toDottedDecimal();
    }
}
