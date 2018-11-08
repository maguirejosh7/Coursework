import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Defines the LightSystem class which runs a server that spawns a thread for each LightDisplay
 */
public class LightSystem extends Thread
{
    public static final int DEFAULT_PORT = 9223;
    public static final String HIGH = "H";
    public static final String LOW = "L";

    private static Random random = new Random();

    public static Random getRandom()
    {
	return random;
    }

    private Set outs = new HashSet();
    private boolean isHigh = false;
    private int port;

	// Default constructor for a LightSystem object
    public LightSystem()
    {
	this(DEFAULT_PORT);
    }

	// Constructor that creates a LightSystem object using a specified port
    public LightSystem(int port)
    {
	this.port = port;
	start();
    }

	/*
	 * Spawn the server and create a thread for each LightDisplay.
	 * Continue to communicate with each LightDisplay object.
	 */
    public void run()
    {
	try {
		// Create the server
	    ServerSocket serverSocket = new ServerSocket(port);
	    while (true) {
		// Accept connections to the server
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket + " connected");

		// Create buffers to communicate with the LightSystem and the client
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		outs.add(out);
		BufferedReader in =
		    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		// Create a new LightSystemThread object and run it
		LightSystemThread thread = new LightSystemThread(this, in);
		thread.start();

		// Notify the client that its LightSystem is running
		notifyClient(out);
	    }
	}
	catch (BindException e) {
		// We cannot use a port that is already in use
	    throw new RuntimeException("LightSystem/other already running on port");
	}
	catch (IOException e) {
		// We may experience communication errors with the LightSystem or client
	    throw new RuntimeException(e);
	}
    }

	/*
	 * Toggle the LightSystem on
	 */
    public void switchOn()
    {
	// Turn on the LightSystem on if it isn't already
	if (! isHigh) {
	    isHigh = true;
		// Notify the client that the LightSystem has been turned on
	    notifyClients();
	}
    }

	/*
	 * Toggle the LightSystem on
	 */
    public void switchOff()
    {
	// Turn on the LightSystem off if it isn't already
	if (isHigh) {
	    isHigh = false;
		// Notify the client that the LightSystem has been turned off
	    notifyClients();
	}
    }

	/*
	 * Send the buffered message to all of the clients
	 */
    private void notifyClients()
    {
	// Get the clients
	Iterator it = outs.iterator();
	// While there is a client to send to
	while (it.hasNext()) {
		// Write the message and send it
	    PrintWriter out = (PrintWriter) it.next();
	    notifyClient(out);
	}
    }

	/*
	 * Send the buffered message to a client
	 * @param out: the buffered message to be sent
	 */
    private void notifyClient(PrintWriter out)
    {
	if (isHigh)
	    out.println(HIGH);
	else
	    out.println(LOW);
    }
}
