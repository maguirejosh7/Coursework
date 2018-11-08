/* LightSystemThread.Java
 * 
 * Sends bits
 *
 * Created by a Calvin Professor
 * Copiedby Josh Maguire on 2/20/2016
 * */

import java.io.*;

public class LightSystemThread extends Thread
{
    private LightSystem system;
    private BufferedReader in;

    public LightSystemThread(LightSystem system, BufferedReader in)
    {
	this.system = system;
	this.in = in;
    }

    public void run()
    {
	try {
	    String line = in.readLine();
	    while (line != null) {
		if (line.equals(LightSystem.HIGH))
		    system.switchOn();
		else
		    system.switchOff();
		line = in.readLine();
	    }
	}
	catch (IOException e) {
	    throw new RuntimeException("LightPanel disconnected");
	}
    }
}
