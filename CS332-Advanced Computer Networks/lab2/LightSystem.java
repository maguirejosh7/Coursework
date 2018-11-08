/* LightSystem.Java
 * 
 * Creates LightSystem that can interact with clients over a network on a port.
 * 
 * Created by a Calvin Professor
 * Copy Pasted by Josh Maguire on 2/17/2016
 * */
import java.io.*;
import java.net.*;
import java.util.*;

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

    public LightSystem()
    {
	this(DEFAULT_PORT);
    }

    public LightSystem(int port)
    {
	this.port = port;
	start();
    }

	/*try to establish an input and output stream to the clientsocket
	 *ServerSockets https://docs.oracle.com/javase/7/docs/api/java/net/ServerSocket.html
	 *Listening on port. When recieves something, calls LightSystemThread which, if the recieved string is "H" (LightSystem.HIGH),
	 *then it calls LightSystem.switchOn, which sets the bool to true, which ultimately turns the light on. 
	 */
     public void run()
    {
	try {
	    ServerSocket serverSocket = new ServerSocket(port);
	    while (true) {
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket + " connected");

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		outs.add(out);
		BufferedReader in =
		    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		LightSystemThread thread = new LightSystemThread(this, in);
		thread.start();
		notifyClient(out);
	    }
	}
	catch (BindException e) {
	    throw new RuntimeException("LightSystem/other already running on port");
	}
	catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    //turns the "light" on
    public void switchOn()
    {
	if (! isHigh) {
	    isHigh = true;
	    notifyClients();
	}
    }

    //turns "light" off
    public void switchOff()
    {
	if (isHigh) {
	    isHigh = false;
	    notifyClients();
	}
    }

    /*send "light" status to outsream / clients. They are listening, if you have friends that is. 
     *If you don't have friends, then you don't need this method. Just play with lights by yourself. 
     */	
    private void notifyClients()
    {
	Iterator it = outs.iterator(); //for each client in the outs hashmap?
	while (it.hasNext()) {
	    PrintWriter out = (PrintWriter) it.next();
	    notifyClient(out);
	}
    }

    //Notify a specific client
    private void notifyClient(PrintWriter out)
    {
	if (isHigh)
	    out.println(HIGH);
	else
	    out.println(LOW);
    }
}
