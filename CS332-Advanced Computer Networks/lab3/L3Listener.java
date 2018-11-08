/* Listener for layer 3
 * by Josh Maguire
 * 4/23/2016
 */

/* INSTRUCTIONS
Create an interface called L3Listener, which should require the implementation of the
method packetReceived(). This method should take in an L3Handler (the
handler that received the packet) and an L3Packet (the packet itself).
 */
public interface L3Listener {
	void packetReceived(L3Handler handler, L3Packet pkt);
}
