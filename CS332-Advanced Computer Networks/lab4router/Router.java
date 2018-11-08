/* This class represents a Router that moves packets across
 * multiple Layer 3 interfaces, according to rules in a routing table.
 * 
 * Written by Josh Maguire using Professor Normans Javadoc
 * 5/5/2016
 * * * */
import java.util.ArrayList;

public class Router extends java.lang.Object implements L3Listener
{
	private ArrayList<L3Handler> ifaces = new ArrayList<>();
	private RoutingTable rt = new RoutingTable();
	String myName = "";

	// just take the human-readable name and save it in an instance variable.
	public Router(java.lang.String name)
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
	public void addL3Iface(L3RoutedIface iface)
	{
		ifaces.add(iface);
		iface.setListener(this); 
		rt.addDirectRoute(iface.getAddr().getNetwork(), iface);
	}

	//add a route to the destination network via the given nextHop.
	public void addRoute(int destNet, L3Address nextHop)
	{
		rt.addRoute(destNet, nextHop, ifaces);
	}

	//add/update the default route to use the given nextHop.
	public void addDefaultRoute(L3Address nextHop)
	{
		rt.addDefaultRoute(nextHop, ifaces );
	}

	//add/update the default route to use the given nextHop. recieves "3.22"
	public void addDefaultRoute(String nextHopDottedDecimal)
	{
		L3Address adr = new L3Address(0,0);
		adr.fromDottedDecimal(nextHopDottedDecimal);
		System.out.println("Router.AddDefaultRoute: " + adr.toDottedDecimal());
		rt.addDefaultRoute(adr, ifaces);
	}

	/* First, check if the hopsleft field is already 0. If it is, drop the packet. Otherwise, 
	 * decrement the hopsleft field by 1. Then, call rt.route() to get the route table
	 * entry that represents the best match from the routing table for the pkt's destination
	 * address. That entry may be null, in which case there is no route to the destination,
	 * so print a message and drop the packet. Check if the route table entry is a local
	 * route. If so, use the destination as the next hop. Use the route table entry's iface
	 * to send() the packet. In all cases, print messages, so we can tell what is going on.
	 * * * * * * * */
	public void route(L3Packet pkt, L3RoutedIface inIface)
	{
		if(pkt.getHopsLeft() < 1)
		{
			System.out.println("Router.route: Packet dropped because hopsLeft returned <1");
			return;
		}
		pkt.decrHopsLeft();
		RoutingTable.Entry e = rt.route(pkt.getDestAddr()); //Maybe I'm supposed to use RoutingTable.Entry here
		if(e == null)
		{
			System.out.println("Router.route: no route to destination " + pkt.getDestAddr().toDottedDecimal() + "! Dropping packet.");
			return;
		}
		if(e.isLocal)
		{
			System.out.println("Router.route: packet destined for local destination " + e.nextHop.toDottedDecimal() + ", calling send...");
			e.iface.send(pkt, pkt.getDestAddr());
			//send this to the packet destination addr!!!!!
		} else
		{
			System.out.println("Router.route: Routing packet to routing table nexthop");
			//else set the next hop to the routing tables next hop
			e.iface.send(pkt, e.nextHop);
		}
		System.out.println("ummmmmm");
	}


	/* Called when the L3RoutedIface object receives a packet from
	 * the lower layer. If the packet is destined for one of our 
	 * ifaces (or isBcast()), receive it and, theoretically, hand 
	 ( it up to layer 4 (if an object is registered to receive it).
	 * (NOTE: passing packets up to a listener at layer 4 does NOT
	 * have to be implemented yet. Just print a message saying the 
	 * packet was received and return.) Else, call route() to route 
	 * the packet.
	 * * * * * * */
	 public void packetReceived(L3Handler handler,
	 	L3Packet pkt)
	 {

	 	if(pkt.getDestAddr().isBcast())
	 	{
	 		System.out.println("Router.packetReceived: Packet recieved is broadcast!");
	 		// return;
	 	}
	 	for(int i = 0; i < ifaces.size(); i++)
	 	{
	 		if(pkt.getDestAddr().equals(ifaces.get(i).getAddr()))
	 		{
	 			System.out.println("Router.packetReceived: Packet received, destined for " + pkt.getDestAddr().toDottedDecimal());
	 			// return;
	 		}
	 	}
		route(pkt, (L3RoutedIface)handler); 
		System.out.println("Router.packetReceived: No match,routing!");
	}

}