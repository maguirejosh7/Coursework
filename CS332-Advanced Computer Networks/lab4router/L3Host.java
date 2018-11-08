/* This class represents a host with 1 or more interfaces. Packets
 * received on one interface are not routed to other interfaces.
 *
 * Written by Josh Maguire using Professor Normans Javadoc
 * 5/5/2016
 * * * */

import java.util.ArrayList;

public class L3Host extends java.lang.Object implements L3Listener
{
	private ArrayList<L3Iface> ifaces = new ArrayList<>();
	private RoutingTable rt = new RoutingTable();
	String myName = "";
	private L3Listener listener;    // we'll inform this listener if we receive a packet


	// just take the human-readable name and save it in an instance variable.
	public L3Host(String name)
	{
		myName = name;
	}

	/* add an L3Iface to this router, so that the
	 * router can route to/from it. Store the iface
	 * in our internal list of interfaces, and make
	 * this object a listener for packets from that
	 * interface. Also, add a direct route to the
	 * routing table for this interface.
	 * * * * */
	public void addL3Iface(L3Iface iface)
	{
		ifaces.add(iface);
		iface.setListener(this); 
		rt.addDirectRoute(iface.getAddr().getNetwork(), iface);

	}

	/* Called when this interface receives a packet from the network.
	 * Doesn't do anything except pass it on to a registered L3Listener like the L3HostDisplay
	 * * * * * * */
	public void packetReceived(L3Handler handler, L3Packet pkt)
	{
		System.out.println("L3Host.packetReceived: try sending it to a listener on this iface");
		listener.packetReceived(handler,pkt);
	}

	/* Send the given bits to the given destination address. Run this dest through the routing table to 
	 * get the next-hop address and outgoing interface. Check if the routing table entry is for a directly
	 * connected network (isLocal is true). If so, use the dest as the nextHop. Create an L3Packet from
	 * the bits and pass down to the L3Iface from the routing table entry to send() the packet.
	 * * * * * * * */
	public void send(String bits, L3Address dest)
	{
		//run dest through rt to find the right iface and nexthop
		RoutingTable.Entry e = rt.route(dest);
		if(e.isLocal)
			e.nextHop = dest;
		// e.iface.send(new L3Packet(bits),e.nextHop);
		L3Packet pkt = new L3Packet(e.nextHop,ifaces.get(0).getAddr(), 0, bits);
		e.iface.send(pkt,e.nextHop);
		//I need to create a packet with a payload of bits...
	}

	public void setListener(L3Listener l)
	{
		assert listener == null;
		listener = l;
	}

	//Just return the interface object.
	public ArrayList<L3Iface> getIface()
	{
		return ifaces;
	}

	//add/update the default route to use the given nextHop.
	public void addDefaultRoute(L3Address nextHop)
	{
		rt.addDefaultRoute(nextHop, ifaces);
	}

	//add/update the default route to use the given nextHop.
	public void addDefaultRoute(String nextHopDottedDecimal)
	{
		// rt.addDefaultRoute(new L3Address(nextHopDottedDecimal), ifaces);
		L3Address adr = new L3Address(0,0);
		adr.fromDottedDecimal(nextHopDottedDecimal);
		System.out.println("L3Host.AddDefaultRoute: " + adr.toDottedDecimal());
		rt.addDefaultRoute(adr, ifaces);
	}

	//return the hostname of this host
	public String toString()
	{
		return myName;
	}
}