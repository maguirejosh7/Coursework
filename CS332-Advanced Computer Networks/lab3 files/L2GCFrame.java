
/* L2GCFrame defines the layer 2 protocol for group C
 * @author: Joel Stehouwer (jbs24)
 * @date: 3-3-2016

Source Address Multicast [Multicast Length] Destination Address Payload Length    Payload     Parity
8 bits          1 bit         4 bits               8 bits           8 bits     1 - 256 bytes   1 bit

 */

public class L2GCFrame {

	public static int BCAST_ADDR = 255;
	public static int SERVER_ADDR = 0;

	String srcAddr;
	String destAddr;
	String multicast;
	String multicastLength;
	String payloadLength;
	String payload;
	String parity;

	/* Constructor for L2GBFrame objects
	 * @param:	src, the source address for the frame
	 *			multi, "1" if this frame should be multicast
	 *			multiLength, if multi==1 this specifies the number of hosts
	 *			dest, the destination address for the frame (or 11111 for broadcast)
	 *			pay, the payload of the frame
	 */
	public L2GCFrame(String src, String multi, String multiLength, String dest, String pay) {
		srcAddr = src;
		int destLength = dest.length() / 8;
		destAddr = "";

		// If there are multiple destinations, convert each to binary individually
		for (int i = 0; i < destLength; i++) {
			destAddr += toBinary(Integer.parseInt(dest.substring(0, 8), 2), 8);
			dest = dest.substring(8);
		}
		multicast = multi;
		multicastLength = multiLength;
		payload = pay;

		// Get the length of the payload
		payloadLength = toBinary(payload.length() / 8, 8);

		// Compute the parity for the bit string
		String wholeFrame = src + " " + multi + multiLength + " " + destAddr + " " + payloadLength + " " + pay;
		parity = (wholeFrame.replace("0", "").replace(" ", "").length() % 2 == 0) ? "0" : "1";
	}

	/* Constructor for L2GCFrame objects
	 * @param: bits, a string of bits that defines all parts of the frame
	 */
	public L2GCFrame(String bits) throws Exception {
		String bitsCopy = bits;
		if (bitsCopy.charAt(0) != '0') {  // If it does not begin with a 0 it is not a valid bit string
			throw new IllegalArgumentException();
		} else if (!bitsCopy.substring(bitsCopy.length() - 1).equals(computeErrorCheck(bitsCopy.substring(0, bitsCopy.length() - 1)))) {
			// Check that the parity bit is correct
			throw new IllegalArgumentException();
		} else {
			try {
				// Parse the bit string for the fields
				bitsCopy = bitsCopy.substring(1);
				srcAddr = bitsCopy.substring(0, 8);
				multicast = bitsCopy.substring(8, 9);
				if (multicast.equals("1")) {
					// Multicast, therefore read how many destinations and parse all of them
					multicastLength = bitsCopy.substring(9, 13);
					bitsCopy = bitsCopy.substring(13);
					destAddr = bitsCopy.substring(0, 8 * Integer.parseInt(multicastLength, 2));
					bitsCopy = bitsCopy.substring(8 * Integer.parseInt(multicastLength, 2));
				} else {
					// There is only one destination
					bitsCopy = bitsCopy.substring(9);
					destAddr = bitsCopy.substring(0, 8);
					bitsCopy = bitsCopy.substring(8);
				}

				// Parse the payload
				payloadLength = bitsCopy.substring(0, 8);
				payload = bitsCopy.substring(8, 8 + 8 * Integer.parseInt(payloadLength, 2));
				parity = computeErrorCheck(bits);
			} catch (StringIndexOutOfBoundsException e) {
				throw new IllegalArgumentException();
			}
		}
	}

	/* Converts an integer value to binary and pads the front of binary string with 0's
	 * @param: value, the integer to be converted into binary
	 *		   length, the length of the binary string that will be returned
	 * @return: binary, the binary representation of the integer
	 */
	public static String toBinary(int value, int length) {
		String binary = (value == 0) ? "0": "";
		while (value >= 1) {
			binary = (((value % 2) == 1) ? "1" : "0") + binary;
			value /= 2;
		}
		while (binary.length() < length) {
			binary = "0" + binary;
		}
		return binary;
	}

	/* Compute the parity bit for the bit string
	 * @param: bits, the bit string to have its even parity computed
	 @ return: var, the parity bit for the bit string
	 */
	public static String computeErrorCheck(String bits) {
		String var = bits;
		var = (var.replace("0", "").length() % 2 == 0) ? "0" : "1";
		return var;
	}

	/* Builds a bit string from the fields of the frame
	 * @return: bits, the bit string that represents the frame
	 */
	public String toString() {
		String bits = "0" + srcAddr;
		bits += multicast.equals("1") ? ("1" + multicastLength) : "0";
		bits += destAddr;
		bits += payloadLength + payload;
		bits += parity;
		return bits;		
	}

	/* Convert the destination addresses into an array of integers
	 * @return: ret, the int[] of destination addresses in decimal
	 */
	public int[] getDestInDecimal() {
		int[] ret = new int[destAddr.length() / 8];
		for (int i = 0; i < destAddr.length() / 8; i++) {
			ret[i] = Integer.parseInt(destAddr.substring(i*8, (i+1)*8), 2);
		}
		return ret;
	}
    
    public int getSrcInDecimal() {
		return Integer.parseInt(srcAddr);
	}

	// Getters for each of the instance variables
	public String getSrc() {
		return srcAddr;
	}

	public String getDest() {
		return destAddr;
	}

	public String getLength() {
		return payloadLength;
	}

	public String getPayload() {
		return payload;
	}

	public String getParity() {
		return parity;
	}
}





