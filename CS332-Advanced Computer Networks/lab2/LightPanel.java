/* LightPanel.Java
 * 
 * Creates Light Panel that moniters if the light is on and turns it on or off.
 * Each Light Panel has a random ID ranged 1-15
 *
 * Created by a Calvin Professor
 * Copy Pasted by Josh Maguire on 2/17/2016
 * */

import java.io.*;
import java.net.*;
import java.util.*;

public class LightPanel extends Thread
{
    private static Set idsUsed = new HashSet(); //hashmap for Light Panels

    private int id;
    private Socket socket; // client socket
    private PrintWriter out;
    private BufferedReader in;
    private boolean isHigh = false;

    public LightPanel()
    {
	this("localhost", LightSystem.DEFAULT_PORT);
    }

    public LightPanel(String host, int port)
    {
	do { //get random id for light panel
	    id = LightSystem.getRandom().nextInt(15) + 1;
	} while (!idsUsed.add(new Integer(id)));

	try { //basically, connect light panel to system using a stream
	    socket = new Socket(host, port);
	    out = new PrintWriter(socket.getOutputStream(), true); //establish output
	    in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //establish input
	    start();
	}
	catch (UnknownHostException e) {
	    throw new RuntimeException("Invalid host:  " + host);
	}
	catch (IOException e) {
	    throw new RuntimeException("Unable to connect to LightSystem");
	}
    }

    //send LightSystem the string HIGH, which is "H"
    public void switchOn()
    {
	out.println(LightSystem.HIGH);
    }

    //... which is "L"
    public void switchOff()
    {
	out.println(LightSystem.LOW);
    }

    //close streams
    public void close()  
    {
	try {
	    out.close();
	    in.close();
	    socket.close();
	}
	catch(Exception e) {
	    throw new RuntimeException(e);
	}
    }
	
    //Reads in strings to check status of the LightSystem it's connected to. 
    public void run()
    {
	try {
	    String line = in.readLine();
	    while (line != null) {
		if (line.equals(LightSystem.HIGH))
		    isHigh = true;
		else if (line.equals(LightSystem.LOW))
		    isHigh = false;
		line = in.readLine();
	    }
	}
	catch (Exception e) {
	    System.out.println("LightPanel disconnected");
	    throw new RuntimeException(e);
	}
    }

    //basically returning the status of the light from this panel's perspective...
    public boolean isOn()
    {
	return isHigh;
    }

    //returns the id of this panel
    public String toString()
    {
	return "#" + id;
    }

    public int getID()
    {
	return id;
    }
}
