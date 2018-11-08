/* This class represents a Layer 3 interface, used on a host
 * device. It differs from its super class only in that it
 * accepts packets that have a bcast destination L3addr or
 * its interface's L3 addr.
 * written by Josh Maguire using Professor Normans Javadoc
 * 5/3/2016
 * * * */

public class L3Iface extends L3Handler implements L3ShimListener
{
	//calls the super class constructer (L3Handler)
	public L3Iface(Layer2Endpoint l2e, int netPart)
	{
		super(l2e,netPart);
	}

	/* Drop any received packet that isn't for this interface.
	 * We'll override this in a router implementation that receives
	 * all packets and forwards packets not destined for it. 
	 * * */
	public boolean dropReceivedPacket(L3Packet pkt, String bits)
	{
		//overrides: dropReceivedPacket in class L3Handler
		//cut from L3Handler, which now just throws a run time exception

		// Drop any packet from me.
		if (pkt.getSrcAddr().equals(myAddr)) {
		    return true;
		}
		// Accept any packet with bcast address.
		if (pkt.getDestAddr().isBcast()) {
		    return false;
		}
		if (! pkt.getDestAddr().equals(myAddr)) {
		    return true;
		}
		return false;
	}
}