
/* This class represents our Layer 3 packet:
 * shim header: Indicates type of layer 3 protocol: 0 = L3IP (defined below), 1 = ARP, else unused
 * 				| service type 2 bits | payload (layer 3 header below) |
 * Layer 3 header:
 * 				| Dest addr 12 bits | src addr 12 bits | hopsleft 3 bits | length 8 bits | l4type 2 bits | parity 1 bit | payload (layer 4 data) |
 * 
 *
 * @author: Josh Maguire
 * @date: 4/23/2016
 */
public class L3Packet extends java.lang.Object
{
	L3Address srcAddr, destAddr;
	int hopsleft, length, l4type, parity; 
	String payload;
	
	/* Constructor for our packet, also computes length field from payload
	 * @param:dest, destination address in form of L3Address type
	 * @param:src, sounce address...
	 * @lyr4type, indicates layer 4 payload type; 0 = raw data; other values to be assigned later.
	 * @pl, layer 4 data
	 */
	public L3Packet(L3Address dest, L3Address src, int lyr4type, String pl)
	{
		//create a packet from the field values
		destAddr = dest; 
		srcAddr= src; 
		l4type = lyr4type;
		payload = pl;
		//set hops left to default value
		hopsleft = 7;
		//compute the length field from the payload in 8 bit bytes
		length = pl.length()/8;
		//compute parity of header
		parity = 0;
		String string = this.toString();
		parity = computeParity(string);
	}
	
	//getter for source address
	public L3Address getSrcAddr()
	{
		return srcAddr;
	}
	
	//getter for destination address
	public L3Address getDestAddr()
	{
		return destAddr;
	}
	
	//getter for hopsleft
	public int getHopsLeft()
	{
		return hopsleft;
	}
	
	//getter for payload
	public String getPayload()
	{
		return payload;
	}
	
	//getter for L4Type
	public int getL4Type()
	{
		return l4type;
	}
	
	//getter for parity
	public int getParity()
	{
		return parity;
	}
	
	//compute parity
	public int computeParity(String s)
	{
		int i = (s.replace("0", "").length() % 2 == 0) ? 0 : 1;
		return i;
	}
	
	//converts an int to a padded binary
	public static String toBinary(int value, int length)
	{
		String binary = Integer.toString(value, 2);
		while(binary.length() < length)
		{
			binary = "0" + binary;
		}
		return binary;
	}
	
	//create binary string of this packet
	public String toString()
	{
		String string = "";
		string += destAddr.toString();
		string += srcAddr.toString();
		string += toBinary(hopsleft,3);
		string += toBinary(length,8);
		string += toBinary(l4type,2);
		string += parity;
		return string;
	}
}
