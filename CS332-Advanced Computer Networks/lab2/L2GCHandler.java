/*
 * Written by Josh Maguire
 * 3/23/2016
 * 
 * This handler will be responsible for 1) sending a given L2GXFrame to layer-1 to
 * be sent, and 2) receiving a string of bits from layer-1, and creating a L2GXFrame from
 * them. When receiving a frame from layer 1, this class will also decide if that frame
 * should be received or dropped and if received, passing the received frame to any object at
 * an upper layer that has requested to receive frames. 
 * */
public class L2GCHandler implements BitListener {
	private BitHandler handler;
	private Layer2Listener layer2Listener;
	private int macAddr;

	public L2GCHandler(int mac) {
		this("localhost", LightSystem.DEFAULT_PORT, mac);
	}

	public L2GCHandler(String host, int port, int mac) {
		macAddr = mac;
		handler = new BitHandler(host, port);
		handler.setListener(this);
		System.out.println("Handler created! Mac:" + macAddr);
	}

	// getter for mac address
	public int getMacAddr() {
		return macAddr;
	}

	// to string for our int mac address
	public String toString() {
		String string = macAddr + "";
		return string;
	}

	// Register layer 2 listener
	public void setListener(Layer2Listener l) {
		layer2Listener = l;
	}

	// sending the frame down a layer
	public void send(L2GCFrame frame) throws CollisionException {
		String string = frame.toString();
		while (!handler.isSilent()) {
			System.out.println("Waiting for isSilent...");
			// wait for halfperiods till handler.isSilent() == true
			try {
				this.wait(BitHandler.HALFPERIOD);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// done waiting, try send
		try {
			System.out.println("Sending Frame: " + string);
			handler.broadcast(string);
		} catch (CollisionException e) {
			System.out.println("Collision Detected!");
		}
	}

	// have this take in the bitListener that hear it and the string it
	// received,
	// then check it, create a frame... send the frame on.
	@Override
	public void bitsReceived(BitHandler handler, String bits) {
		L2GCFrame frame = new L2GCFrame(bits);
		System.out.println("bitsRecieved! Bits: " + bits);
		// if frame is for me,
		if (frame.getDestinationAddress() == macAddr || frame.getDestinationAddress() == 255) {
			System.out.println("match! -> " + macAddr);
			// if listener is registered
			// if(layer2Listener != null) //something like that

			// pass frame up to layer2 listener
			layer2Listener.frameReceived(this, frame);
		}
	}
}
