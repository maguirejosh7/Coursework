/* This class represents a Layer 3 interface, used on
 * a router. It differs from the L3Handler only in that 
 * it does not drop any incoming packets. Instead, packets
 * that are not destined for it are passed up the listener
 * object to be routed.
 * created by Josh Maguire using Professor Normans Javadoc
 * 5/3/2016
 * * * * */

public class L3RoutedIface extends L3Handler implements L3ShimListener
{
	//calls the super class constructor (L3Handler)
	L3RoutedIface(Layer2Endpoint l2e, int netPart)
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