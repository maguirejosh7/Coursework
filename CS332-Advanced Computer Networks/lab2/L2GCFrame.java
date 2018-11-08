
/* L2GCFrame
 * 
 * written by Josh Maguire
 * 3/23/2016
 * 
 * A frame for Group 3's packet. More info in the readme. 
 * As of now, multiplexing doesn't work, must be set to 0.
 * 
 * */
import java.lang.*;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;

public class L2GCFrame {
	// Instance Variables for each field in this frame:
	private int sourceAddress;
	private int multicast;
	private int multicastLength;
	private int[] multicastAddressArray;
	private int destinationAddress;
	private int payloadLength;
	private static String payload;
	private int checkSum;
	public static int BCAST_ADDR = 0xff; // 1111 1111 or 255

	public L2GCFrame() {
	}

	// Provide a constructor that takes in values you need
	public L2GCFrame(int s, int m, int d, int pl, String p) {
		sourceAddress = s; // string to int...
		multicast = m;
		destinationAddress = d;
		payloadLength = pl;
		payload = p;
		// checkSum = c;//need to calc this
		checkSum = computeErrorCheck(this.toString());
	}

	// Provide a constructor that takes in values you need. This one
	// is for when we have multiple addresses (multiplexing).
	// NOT WORKING
	// public L2GCFrame(int s, int m, int ml, int[] ma, int pl, String p, int c)
	// {
	// sourceAddress = s; // string to int...
	// multicast = m;
	// multicastLength = ml;
	// int mLength = ml; //Convert from binary to int, the number of multicast
	// addresses
	// multicastAddressArray = new int[mLength];
	// for (int i = 0; i < mLength; i++) {
	// multicastAddressArray[i] = ma[i];
	// }
	// payloadLength = pl;
	// payload = p;
	// checkSum = c; // need to calculate this
	// }

	// Creates a frame out of a string of bits
	public L2GCFrame(String string) throws IllegalArgumentException {
		// System.out.println("Creating Frame from String...");
		StringBuilder sb = new StringBuilder(string);
		// System.out.println("error check bit: " +
		// sb.charAt(string.length()-1));
		// System.out.println("error check shld be: " +
		// computeErrorCheck(sb.substring(0, string.length()-1)));
		if (sb.charAt(0) != '0') // assert preamble is a 0 bit
		{
			System.out.println("preamble check failed!");
			throw new IllegalArgumentException();
		}
		// check parity bit
		if (sb.charAt(string.length() - 1) != sb.charAt(sb.length() - 1)) {
			System.out.println("error check failed!");
			throw new IllegalArgumentException();
		}
		// System.out.println("Parsing incoming string...");
		sourceAddress = toDecimal(sb.substring(1, 9));
		// System.out.println("source:"+sourceAddress);
		multicast = toDecimal(sb.substring(9, 10));
		// System.out.println("mcast:"+multicast);
		destinationAddress = toDecimal(sb.substring(10, 18));
		// System.out.println("dest:"+destinationAddress);
		payloadLength = toDecimal(sb.substring(18, 26));
		// System.out.println("pl length:"+payloadLength);
		int i = 26 + payloadLength;
		payload = sb.substring(26, i);
		// System.out.println("pl:"+payload);
		checkSum = toDecimal(sb.substring(i, i + 1));
		// System.out.println("checksum:"+checkSum);
		// System.out.println("Done parsing string.");
		// is length correct?
	}

	public int getSourceAddress() {
		return sourceAddress;
	}

	public int getMulticast() {
		return multicast;
	}

	public String getMulticastLength() {
		return toBinary(multicastLength, 4);
	}

	public String[] getMulticastAddressArray() {
		String[] s = new String[multicastAddressArray.length];
		for (int i = 0; i < multicastAddressArray.length; i++) {
			s[i] = toBinary(multicastAddressArray[i], 8);
		}
		return s;
	}

	public int getDestinationAddress() {
		return destinationAddress;
	}

	public int getPayloadLength() {
		return payloadLength;
	}

	public String getPayload() ////// This getter doesn't call toBinary!
	{
		return payload;
	}

	public int getCheckSum() {
		return checkSum;
	}

	/*
	 * Takes in an integer value and an integer length, and returns a string of
	 * bits of the given length representing the given value in binary. You may
	 * assume that the value will fit in the number of bits given by length.
	 */
	public static String toBinary(int value, int length) {
		String string;
		string = Integer.toString(value, 2);
		if (string.length() < length) {
			String padString = "";
			int pad = length - string.length();
			for (int i = 0; i < pad; i++) {
				padString = padString + "0";
			}
			return padString + string;
		}
		return string;
	}

	public static int toDecimal(String string) {
		return Integer.parseInt(string, 2);
	}

	/*
	 * create and return the bit string corresponding to the whole frame. Don’t
	 * forget to prepend the “0” preamble to the beginning of it.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("0"); // preamble
		sb.append(toBinary(sourceAddress, 8));
		sb.append(toBinary(multicast, 1));
		if (multicast > 0) {
			sb.append(getMulticastLength());
			String[] s = getMulticastAddressArray();
			for (int i = 0; i < multicastAddressArray.length; i++) {
				sb.append(s[i]);
			}
		} else {
			sb.append(toBinary(destinationAddress, 8));
		}
		sb.append(toBinary(payloadLength, 8));
		sb.append(getPayload()); //
		sb.append(checkSum);
		return sb.toString();
	}

	// A static method computeErrorCheck that takes in a bit String, and
	// computes the error checking value, of the correct number of bits.
	// This frame uses single bit parity: 1 for odd, 0 for even.
	public static int computeErrorCheck(String string) {
		int parityBit = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1')
				parityBit++;
		}
		return parityBit % 2;
	}

}