
/* L2GCHandler defines the handler for the group C layer 2 protocol
 * @author: Joel Stehouwer (jbs24)
 * @date: 3-9-2016
 */

public class L2GCHandler implements BitListener {

	BitHandler bitHandle;
	Layer2Listener layer2Listener;
	int myMac;

	/* Constructor using a specified mac address
	 * @param: macAddr, the mac address for this handler
	 */
	public L2GCHandler(int macAddr) {
		bitHandle = new BitHandler("localhost", LightSystem.DEFAULT_PORT);
		bitHandle.setListener(this);
		myMac = macAddr;
	}

	/* Constructor using a specified host, port, and mac address
	 * @param: host, the host to connect to to communicate
	 *		   port, the port to connect to on the host
	 *		   macAddr, the mac address for this handler
	 */
	public L2GCHandler(String host, int port, int macAddr) {
		bitHandle = new BitHandler(host, port);
		bitHandle.setListener(this);
		myMac = macAddr;
	}

	/* Send the frame via broadcast to the host
	 * @param: frame, the frame to be sent
	 */
	public void send(L2GCFrame frame) {
		// Wait for the wire to be open before sending
		while (!bitHandle.isSilent()) {
			bitHandle.pause(BitHandler.HALFPERIOD);
		}

		// Try to send the frame, and if there is a collision, recursively try to send the frame again
		try {
			bitHandle.broadcast(frame.toString());
		} catch (CollisionException e) {
			send(frame);
		}
	}

	/*
	 * Display the sequence of bits that was received from the BitHandler.
	 * @param h: The BitHandler that we received bits from.
	 * @param bits: The sequence of bits that was received.
	 */
    public void bitsReceived(BitHandler h, String bits)
    {
		try {
			L2GCFrame frame = new L2GCFrame(bits);
			int[] dests = frame.getDestInDecimal();
			for (int i = 0; i < dests.length; i++) {
				if (myMac == dests[i] || dests[i] == 255) {
                    if (dests[i] == 255 && frame.getSrcInDecimal() == myMac) {
                        continue;  // Don't accept broadcast from self
                    }
					if (layer2Listener != null) {
						layer2Listener.frameReceived(this, frame);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/* Set the Layer2Listener
	 * @param: l, the listener that we want to set our listener to
	 */
    public void setListener(Layer2Listener l) {
		layer2Listener = l;
	}

	// Get the mac address for the L2GCHandler as an int
	public int getMacAddr() {
		return myMac;
	}

	// Get the mac address for the L2GCHandler as a string
	public String toString() {
		return myMac + "";
	}

}
