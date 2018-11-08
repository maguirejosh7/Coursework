/* Layer 3 Shim Listener
 * by Josh Maguire
 * 4/23/2016
 */

public interface L3ShimListener {//
	void packetReceived(L2GCHandler l2h, String pktString);	
}
//loose coupling 