import java.io.*;
import java.net.*;
import java.util.*;

/*
 *
 */

public class LightPanel extends Thread
{
    private static Set idsUsed = new HashSet();

    private int id;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean isHigh = false;

	// Default constructor for a LightPanel object
    public LightPanel()
    {
	this("localhost", LightSystem.DEFAULT_PORT);
    }

	/*
	 * Constructor that creates a LightPanel object using a specified host and port
	 */
    public LightPanel(String host, int port)
    {
	// Generate the ids to be used for the LightPanels
	do {
	    id = LightSystem.getRandom().nextInt(15) + 1;
	} while (!idsUsed.add(new Integer(id)));

	// Try to connect to the server and start communicating with it
	try {
	    socket = new Socket(host, port);
	    out = new PrintWriter(socket.getOutputStream(), true);
	    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    start();
	}
	// We may have encountered errors while connecting to the server
	catch (UnknownHostException e) {
		// Host did not exist
	    throw new RuntimeException("Invalid host:  " + host);
	}
	catch (IOException e) {
		// LightSystem server on host was not found
	    throw new RuntimeException("Unable to connect to LightSystem");
	}
    }

	/*
	 * Turn on the LightSystem
	 */
    public void switchOn()
    {
	out.println(LightSystem.HIGH);
    }

	/*
	 * Turn off the LightSystem
	 */
    public void switchOff()
    {
	out.println(LightSystem.LOW);
    }

	/*
	 * Close the connection to the server
	 */
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

	/*
	 * Run the client and continue to remember what the status of the LightSystem is
	 */
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
		// If there was an error, notify the user that we have been disconnected
	    System.out.println("LightPanel disconnected");
	    throw new RuntimeException(e);
	}
    }

	// Returns true if the LightPanel is turned on
    public boolean isOn()
    {
	return isHigh;
    }

	// Get the id of the LightPanel as a string
    public String toString()
    {
	return "#" + id;
    }

	// Get the id of th eLightPanel as an int
    public int getID()
    {
	return id;
    }
}
