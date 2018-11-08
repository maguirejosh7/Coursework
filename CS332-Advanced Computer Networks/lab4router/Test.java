public class Test
{
    final static int LAN1PORT = LightSystem.DEFAULT_PORT;
    final static int LAN2PORT = LightSystem.DEFAULT_PORT + 1;
    final static int LAN3PORT = LightSystem.DEFAULT_PORT + 2;
    final static int LAN4PORT = LightSystem.DEFAULT_PORT + 3;

    
    public static void main(String[] args)
    {
	// testSwitch();
	// testLayer3();
	// testLayer3ThruSwitch();
	testRouting();
    }

    public static void testLayer3()
    {
	new LightSystem();
	// 1 is the mac address
	Layer2Endpoint le1 = new Layer2Endpoint("localhost", LAN1PORT, 1);
	// 1 is the network part.  thus the address is 1.1.
	new L3Display(new L3Iface(le1, 1));			    

	// L3 endpoint with address 1.2
	Layer2Endpoint le2 = new Layer2Endpoint("localhost", LAN1PORT, 2);
	new L3Display(new L3Iface(le2, 1));

	Layer2Endpoint le3 = new Layer2Endpoint("localhost", LAN1PORT, 3);
	new L3Display(new L3Iface(le3, 1));
	
    }

    public static void testSwitch()
    {
	new LightSystem();
	//	new LightDisplay(new LightPanel("LAN 1"));

	new LightSystem(LAN2PORT);
	//	new LightDisplay(new LightPanel("LAN 2", "localhost", LAN2PORT));

	new LightSystem(LAN3PORT);
	//	new LightDisplay(new LightPanel("LAN 3", "localhost", LAN3PORT));
	
	new LightSystem(LAN4PORT);
	//	new LightDisplay(new LightPanel("LAN 4", "localhost", LAN4PORT));

	Switch sw = new Switch(8);	// 8 port switch
	new SwitchDisplay(sw);

	// A switch port connected to LightSystem sys1 (DEFAULT_PORT) on the switch's
	// port 0.
	sw.attachPort(new SwitchPort(0),
		      new SwitchLightPanel("LAN 1", "localhost", LAN1PORT));

	// A host on LightSystem 1.
	new Layer2Display(new Layer2Endpoint(17));
	
	// Create a 2nd switch port, connected to the 2nd Light System, and attached
	// to our switch's port 1.
	sw.attachPort(new SwitchPort("localhost", LAN2PORT, 1),
		      new SwitchLightPanel("LAN 2", "localhost", LAN2PORT));

	// 2 Hosts on light system 2.
	new Layer2Display(new Layer2Endpoint("localhost", LAN2PORT, 18));
	new Layer2Display(new Layer2Endpoint("localhost", LAN2PORT, 19));
	
	// Create a 3rd switch port, connected to the 3rd Light System, and attached
	// to our switch's port 2.
	sw.attachPort(new SwitchPort("localhost", LAN3PORT, 2),
		      new SwitchLightPanel("LAN 3", "localhost", LAN3PORT));

	// 2 Hosts on light system 3.
	new Layer2Display(new Layer2Endpoint("localhost", LAN3PORT, 20));
	new Layer2Display(new Layer2Endpoint("localhost", LAN3PORT, 21));

	// Create a 4th switch port, connected to the 4th Light System, and attached
	// to our switch's port 3.
	sw.attachPort(new SwitchPort("localhost", LAN4PORT, 3),
		      new SwitchLightPanel("LAN 4", "localhost", LAN4PORT));

	// 2 Hosts on light system 4.
	new Layer2Display(new Layer2Endpoint("localhost", LAN4PORT, 22));
	new Layer2Display(new Layer2Endpoint("localhost", LAN4PORT, 23));

    }


    public static void testLayer3ThruSwitch()
    {
	// Create two LANs.
	
	new LightSystem();
	new LightSystem(LAN2PORT);

	// Create a switch and 2 SwitchPorts.
	Switch sw = new Switch(8);	// 8 port switch
	new SwitchDisplay(sw);

	// A switch port connected to LightSystem (DEFAULT_PORT) on the switch's
	// port 0.
	sw.attachPort(new SwitchPort("localhost", LAN1PORT, 0),
		      new SwitchLightPanel("LAN 1", "localhost", LAN1PORT));

	// A switch port connected to LightSystem 2 on the switch's port 1.
	sw.attachPort(new SwitchPort("localhost", LAN2PORT, 1),
		      new SwitchLightPanel("LAN 2", "localhost", LAN2PORT));

	// Create a host on each LAN.

	// L3 endpoint with address 3.18 on switch port 0
	Layer2Endpoint le1 = new Layer2Endpoint("localhost", LAN1PORT, 18);
	new L3Display(new L3Iface(le1, 3));

	// L3 endpoint with address 3.20 on switch port 1
	Layer2Endpoint le2 = new Layer2Endpoint("localhost", LAN2PORT, 20);
	new L3Display(new L3Iface(le2, 3));
    }

    
    /* h1 (1.19) <--> net 1 <--> (1.11) r1 (3.33) <--> net 3 <--> (3.22) r2 (2.222)
       <--> net 2 <--> (2.21) h2 */
    
    /* r1's interfaces are 1.11 and 3.33.
       r2's interfaces are 3.22 and 2.222 */
    public static void testRouting()
    {
	new LightSystem();          /* net 1 */
	new LightSystem(LAN2PORT);  /* net 2 */
	new LightSystem(LAN3PORT);  /* net 3 */

	new LightDisplay(new LightPanel("lan1", "localhost", LAN1PORT));
	new LightDisplay(new LightPanel("lan2", "localhost", LAN2PORT));
	new LightDisplay(new LightPanel("lan3", "localhost", LAN3PORT));

	/* A router on the 1 and 3 networks. */
	Router r1 = new Router("r1");
	r1.addL3Iface(new L3RoutedIface(new Layer2Endpoint("localhost", LAN1PORT, 11), 1));
	r1.addL3Iface(new L3RoutedIface(new Layer2Endpoint("localhost", LAN3PORT, 33), 3));
	r1.addDefaultRoute("3.22");	// toward r2 

	Router r2 = new Router("r2");
	r2.addL3Iface(new L3RoutedIface(new Layer2Endpoint("localhost", LAN3PORT, 22), 3));
	r2.addL3Iface(new L3RoutedIface(new Layer2Endpoint("localhost", LAN2PORT, 222), 2));
	r2.addDefaultRoute("3.33");  	// toward r1

	/* host 1.19 */
	Layer2Endpoint le1 = new Layer2Endpoint("localhost", LAN1PORT, 19);
	L3Host h1 = new L3Host("h1");
	h1.addL3Iface(new L3Iface(le1, 1));
	h1.addDefaultRoute("1.11");
	new L3HostDisplay(h1);

	/* host 2.21 */
	Layer2Endpoint le2 = new Layer2Endpoint("localhost", LAN2PORT, 21);
	L3Host h2 = new L3Host("h2");
	h2.addL3Iface(new L3Iface(le2, 2));
	h2.addDefaultRoute("2.222");
	new L3HostDisplay(h2);
    }
}
