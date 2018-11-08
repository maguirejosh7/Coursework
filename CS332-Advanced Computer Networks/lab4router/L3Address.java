

/**
 * An L3Address represents a L3 source or destination address, with its
 * two parts: the network part and host part, each 1 octet long.
 */
public class L3Address
{
    private int net;
    private int host;

    /**
     * BCAST is defined to be an octet of all 1s, in each part of the address.
     */
    public static final int BCAST_NET = 0xf;
    public static final int BCAST_HOST = 0xff;

    /**
     * Create an address from the net part and host part.
     */
    public L3Address(int net, int host)
    {
	assert net > 0 && net <= 15 && host > 0 && host <= 255;
	this.net = net;
	this.host = host;
    }

    /**
     * Create an address from a 12-bit long string of 1s and 0s.
     */
    public L3Address(String bits)
    {
	assert bits.length() == 12;
	net = Layer2Frame.toDecimal(bits.substring(0, 4));
	host = Layer2Frame.toDecimal(bits.substring(4));
    }

    /**
     * Convert to a string of 0s and 1s for transmission over a network.
     */
    public String toString()
    {
	return Layer2Frame.toBinary(net, 4) + Layer2Frame.toBinary(host, 8);
    }

    /**
     * Convert to dotted-decimal form: net.host
     */
    public String toDottedDecimal()
    {
	return net + "." + host;
    }

    /**
     * Convert from dotted-decimal form.
     */
    public void fromDottedDecimal(String in)
    {
	int dotIdx = in.indexOf('.');
	net = Integer.parseInt(in.substring(0, dotIdx));
	host = Integer.parseInt(in.substring(dotIdx + 1));
    }

    /**
     * return true of this address is identical to the given one.
     */
    public boolean equals(L3Address other)
    {
	return net == other.getNetwork() && host == other.getHost();
    }

    /**
     * return true if this address is the bcast address, 15.255.
     */
    public boolean isBcast()
    {
	return net == BCAST_NET && host == BCAST_HOST;
    }

    /** getters */
    public int getNetwork() { return net; }
    public int getHost() { return host; }
}
