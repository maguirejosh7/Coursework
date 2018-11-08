
/**
 * This class represents a L3 packet, as defined in our class wiki.
 * The constructors allow you to create an L3 packet from a string of bits,
 * (as is done when an L3 packet is received), or to create one from values
 * for the fields (as is done when an L3 packet is being created).
 */
public class L3Packet
{

    private L3Address destAddr;		// 12 bits
    private L3Address srcAddr;		// 12 bits
    private int hopsleft;		// 3 bits
    private int length;			// 8 bits: value is # of bytes.
    private int l4type; 		// 2 bits: type of layer 4 data in the payload
    private int parity;			// 1 bit
    private String payload;

    /**
     * Create an L3Packet from field values.  Compute the length field
     * from the payload.
     */
    public L3Packet(L3Address dest, L3Address src, int l4type, String payload)
    {
	destAddr = dest;
	srcAddr = src;
	this.payload = payload;

	// The payload length must be a multiple of 8 bits.
	assert payload.length() % 8 == 0;
	this.length = payload.length() / 8;

	this.l4type = l4type;
	hopsleft = 7;		// max value is default value.
	parity = 0;
    }

    /**
     * Create an L3Packet from a string of bits.  Throw an exception if
     * the length of the payload is not the same as in the length field.
     */
    public L3Packet(String bits)
    {
	destAddr = new L3Address(bits.substring(0, 12));
	srcAddr = new L3Address(bits.substring(12, 24));
	hopsleft = Layer2Frame.toDecimal(bits.substring(24, 27));
	length = Layer2Frame.toDecimal(bits.substring(27, 35));

	l4type = Layer2Frame.toDecimal(bits.substring(35, 37));
	String parityStr = bits.substring(37, 38);

	if (! Layer2Frame.computeParity(bits.substring(0, 37), 1).equals(parityStr)) {
	    System.err.println("Layer3: bad parity value");
	    throw new IllegalArgumentException();
	}
	payload = bits.substring(38);
	if (payload.length() != length * 8) {		// payload length is in bytes, data is bits.
	    System.err.println("Bad length!");
	    throw new IllegalArgumentException();
	}
    }

    /**
     * Create the String of 0s and 1s representing the packet.
     */
    public String toString()
    {
	String res =
	    destAddr.toString() + 
	    srcAddr.toString() +
	    Layer2Frame.toBinary(hopsleft, 3) + 
	    Layer2Frame.toBinary(length, 8) +
	    Layer2Frame.toBinary(l4type, 2);
	res += Layer2Frame.computeParity(res, 1);
	return res + payload;
    }

    // getters
    public L3Address getSrcAddr()  { return srcAddr; }
    public L3Address getDestAddr() { return destAddr; }
    public String    getPayload()  { return payload; }
    public int       getHopsLeft() { return hopsleft; }
    public int       getL4Type()   { return l4type; }
    public int       getParity()   { return parity; }

    //decrement packet hops left field
    public void decrHopsLeft()
    {
        assert(this.hopsleft > 0);
        this.hopsleft --;
    }
}
