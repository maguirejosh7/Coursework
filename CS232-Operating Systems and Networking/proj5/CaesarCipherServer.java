/* CaesarCipherServer.java
 * A server for our cipher program. 
 * As of now it just echo's back everything the client 
 * sends it. 
 *
 * Run with port number as command line arg, else default 
 * port will be 9876!
 *
 * by Josh Maguire
 * 5/12/2016
 * * * * * * * * */


import java.io.*;
import java.net.*;
import java.util.*;

public class CaesarCipherServer
{
	public static void main (String[] args)
	{
		ServerSocket ccServerSocket = null;
		Socket clientSocket = null;
		int port = 0;
		String line = "";
		DataInputStream is = null;
		PrintStream os = null;

		//get port from command args or use default port
		if (args.length > 0)
		{
			try
			{
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e)
			{
				System.err.println("Argument" + args[0] + " must be a valid part number (int).");
				System.exit(1);
			}
		} else
		{ //default  port 
			port = 9876;
		}
		System.out.println("port set as " + port);

		//open streams and sockets
		try 
		{
			ccServerSocket = new ServerSocket(port);
			clientSocket = ccServerSocket.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			while (true) 
			{

				line = is.readLine();
				os.println(line);
			}



			
			// cleanup
			// is.close();
			// os.close();
			// clientSocket.close();
			// ccServerSocket.close();
		}
		catch (IOException e) 
		{
			System.out.println(e);
		}


	} //end of main
}//end class