/* A routing table that holds route entries and
 * a separate default route. Currently does not
 * support host-specific routes.
 *
 * by Josh Maguire using Professor Normans Javadoc
 * 5/4/2016
 * * * * * * */
import java.util.ArrayList;

public class RoutingTable
{

	private ArrayList<Entry> table = new ArrayList<>();
	private Entry defaultRoute = null;

	public class Entry //represents a single row in the table
	{
		//instance variables:
		public int destNet;
		public L3Address nextHop; //if 0, route is for locally connected machines
		public L3Handler iface; //L3RoutedIface or an L3Iface depending on whether routing table is instantiated on host or a router.
		public boolean isLocal; //true if entry is for machines on a local network
		
		/* Entry Constructor: given destNet, nextHop, and iface, just store them
		 * in instance variables. Compute isLocal by checking
		 * if nextHop equals 0.0.
		 * * * * */
		public Entry(int d, L3Address n, L3Handler i)
		{
			this.destNet = d;
			this.nextHop = n;
			this.iface = i;
			this.isLocal = nextHop.equals(new L3Address(0, 0));
		}

		//return a friendly string containing all the instance variables
		public String toString()
		{
			return ("Entry:\n-Destination Network: " + this.destNet + "\n-nextHop: " + nextHop.toDottedDecimal() + "\n-interface: " + iface.toString());
		}


	}//end of Entry class


	/* No code here. A Routing Table instance has an ArrayList instance variable, and a Entry instance
	 * variable to store a single default route.
	 * * * * */
	public RoutingTable()
	{
		
	}

	/* Find the best route to get to the given dest address. 
	 * Do this by iterating over all the routing table entries, 
	 * looking for the best match. Return the entry that is the 
	 * best match. (At this point, the only match will be the best 
	 * match -- so when a match is found, return it.) Return the 
	 * default route if no match is found. That default route might 
	 * be null if it hasn't been set.
	 * * * * * * ** */
	public RoutingTable.Entry route(L3Address dest) 
	{
		for(int i = 0; i < table.size(); i++)
		{
			if(table.get(i).destNet == dest.getNetwork())
				return table.get(i);
		}
		return defaultRoute;
	}

	/* Add an entry to the routing table to locally-connected machines on 
	 * connected LANs. The code uses 0.0 as the nextHop in these routes (aka local). Also, 
	 * print out a short message saying the route was added.
	 * * * * * * * */
	public void addDirectRoute(int d, L3Handler i)
	{
		Entry e = new Entry(d, new L3Address(0, 0), i);
		table.add(e);
		System.out.println("RoutingTable.addDirectRoute: Route added: " + e.toString());
	}

	/* Add an entry to the routing table. Use "0.0" for nextHop to indicate a 
	 * "local route" -- a route to locally-connected machines on connected LANs. 
	 * The code looks through the defined interfaces and finds the out interface
	 * to use to reach the nextHop. Also, print out a short message saying the
	 * route was added. Throw an IllegalArgumentException if the next hop is not 
	 * on any connected network.
	 * * * * * */
	public void addRoute(int d, L3Address n, ArrayList<L3Handler> ifaces)
	{
		for(int i = 0; i < ifaces.size(); i++)
		{
			if(d == ifaces.get(i).getAddr().getNetwork())
			{
				Entry e = new Entry(d, n, ifaces.get(i));
				table.add(e);
				System.out.println("RoutingTable.addRoute: Route added: " + e.toString());
			}
		}
		throw new IllegalArgumentException("RoutingTable.addRoute: next hop not found on any connected network!");
	}

	//Set the default route to use the given next hop. Use 0 for the destnet.
	public void addDefaultRoute(L3Address n, L3Handler i)
	{
		if(defaultRoute == null)
		{
			defaultRoute = new Entry(0,n,i);
		} else
		{	
			defaultRoute.nextHop = n;
			defaultRoute.iface = i;
			defaultRoute.destNet = 0;
		}
	}

	/* Set the default route. Look up the interface that has the nextHop on it 
	 * and use that interface in the route. The entry will have 0 as the destination
	 * network. Throw an IllegalArgumentException if the next hop is not on any
	 * connected network.
	 * * * * * * * */
	public void addDefaultRoute(L3Address n,  java.util.ArrayList<? extends L3Handler> ifaces)
	{
		System.out.println("RoutingTable.addDefaultRoute: Address: "+n.toDottedDecimal());
		for(int i = 0; i < ifaces.size(); i++)
		{
			System.out.println("addDefaultRoute FORLOOP");
			if(ifaces.get(i).getAddr().getNetwork() == n.getNetwork())
			{
				System.out.println("addDefaultRoute IF");
				if(defaultRoute == null)
				{
					defaultRoute = new Entry(0,n,ifaces.get(i));
					return;
				} else
				{	
					defaultRoute.nextHop = n;
					defaultRoute.iface = ifaces.get(i);
					defaultRoute.destNet = 0;
					return;
				}
			}
		}
		throw new IllegalArgumentException("RoutingTable.addDefaultRoute: Next hop not connected to network!");
	}
}