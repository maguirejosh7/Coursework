
/* An L3Address represents a L3 source or destination
 * address, with its two parts: the network part and 
 * host part, each 1 octet long. (from Professor Normans Javadoc)
 *
 * @author: Josh Maguire
 * @date: 4/21/2016
 */

public class L3Address extends java.lang.Object
{
	//BCAST is defined to be an octet of all 1s, in each part of the address.
	public static final int BCAST_NET = 15;
	public static final int BCAST_HOST = 255;
	int netPart, hostPart;
	
	/* constructor for L3Address
	 * @param: net, the network part
	 * @param: host, the host part
	 */
	public L3Address(int net, int host)
	{
		netPart = net;
		hostPart = host;		
	}
	
	/* constructor L3Address from string of bits like 000100000011
	 * @param: bits, bits to be parsed
	 */	
	public L3Address(String bits)
	{
		String net = bits.substring(0, 4);		
		String host = bits.substring(4, 12);
		netPart = Integer.parseInt(net, 2);
		hostPart = Integer.parseInt(host, 2);
	}
	
	//getter for netPart
	public int getNetwork()
	{
		return netPart;
	}
	
	//getter for hostPart
	public int getHost()
	{
		return hostPart;
	}
	
	//returns true if this address is the broadcast address
	public boolean isBcast()
	{
		if(hostPart == BCAST_HOST && netPart == BCAST_NET)
			return true;
		return false;
					
	}
	
	//return true if this address is identical to the one given
	public boolean equals(L3Address other)
	{
		if (other.getNetwork()==netPart && other.getHost()==hostPart)
			return true;
		return false;
	}
	
	//convert to dotted decimal form of net.host
	public String toDottedDecimal()
	{
		return netPart + "." + hostPart;
	}
	
	//convert from dotted decimal form
	public void fromDottedDecimal(String in)
	{
		netPart = Integer.parseInt(in.substring(0, 4),2);		
		hostPart = Integer.parseInt(in.substring(5, 13),2);
	}
	
	// Converts address to a binary string for transmission over a network
	public String toString()
	{
		String netBits = Integer.toString(netPart, 2);
		while(netBits.length() < 4)
		{
			netBits = "0" + netBits;
		}
		String hostBits = Integer.toString(hostPart, 2);
		while(hostBits.length() < 8)
		{
			hostBits = "0" + hostBits;
		}
		return netBits + hostBits;
	}
	
}
