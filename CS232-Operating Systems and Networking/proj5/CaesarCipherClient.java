/* CaesarCipherClient.java
 * A client to a CaesarCipherServer.java
 * After sending the server a rotation amount, continiously 
 * sends and recieves text to and from the server to 
 * encrypt it. It takes in the server name and port as command 
 * arguments like: java CaesarCipherClient [host name] [port]
 * ,but if non are given then:
 *
 * 		hostName = "brooks.cs.calvin.edu";
 * 		port = 9876;
 *
 * By Josh Maguire
 * 5/12/2016
 * * * * * * * * * */

import java.io.*;
import java.net.*;

public class CaesarCipherClient
{
	
	public static void main (String[] args)
	{
		//declaring some stuff
		Socket caesarSocket = null;
		DataOutputStream os = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedReader stdIn = null;
		int port = 0;
		String hostName = "";
		String rotationAmount = "";
		String userInput;
		String serverResponse;


		//---get port and hostName from command line arguments---//
		if (args.length > 0)
		{
			try
			{
				port = Integer.parseInt(args[1]);
			} catch (NumberFormatException e)
			{
				System.err.println("Argument" + args[1] + " must be an integer.");
				System.exit(1);
			}
			//get hostName, not as strict
			hostName = args[0];
		} else
		{ //default  values
			hostName = "brooks.cs.calvin.edu";
			port = 9876;
		}
		System.out.println("Hostname: " + hostName);
		System.out.println("port: " + port);
		//-----done getting commandline args.------//

		//---try to open sockets and streams---//
		try
		{
			caesarSocket = new Socket(hostName, port);
			os = new DataOutputStream(caesarSocket.getOutputStream());
			isr = new InputStreamReader(caesarSocket.getInputStream());
			br = new BufferedReader(isr);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch (UnknownHostException e)
		{
			System.err.println("Don't know about host: hostname");
		} catch (IOException e)
		{
			System.err.println("Couldn't get I/O for the connection to: hostname");
		}

		if (caesarSocket != null && os != null && br != null) //if sockets and streams are open
		{
			try
			{				
				//welcome user, get rotation amount
				System.out.println("Welcome to the Caesar Cipher Client!");
				System.out.print("Please enter the rotation amount:");
				rotationAmount = stdIn.readLine();
				//ping server with rotation amount, assert the same response
				os.writeBytes(rotationAmount + "\n");
				serverResponse = br.readLine();
				System.out.println("Server response: " + serverResponse);
				assert serverResponse.equals(rotationAmount);
				//while loop to continously get text from user and send to server and print.
				while(true)
				{
					System.out.print("Enter text to encrypt: ");
					userInput = stdIn.readLine();
					if(userInput.equals("quit"))
						break; //hopefully this gets us to the cleanup
					os.writeBytes(userInput + "\n");
					serverResponse = br.readLine();
					System.out.println("Server response: " + serverResponse + "\n");
				}
				// clean up:
				// close all streams and sockets
				System.out.println("closing client.");
				os.close();
				isr.close();
				br.close();
				caesarSocket.close();   
			} catch (UnknownHostException e)
			{
				System.err.println("Trying to connect to unknown host: " + e);
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}//end if sockets and streams are open
	}//end of main

}//end of CaesarCipherClient class