
/*
 * Class to test the functionality of the LightSystem and LightDisplay classes from a remote host
 * @author: Joel Stehouwer (jbs24)
 * Feb 16, 2016 for CS 332 at Calvin College 
 */

public class TestRemote {

	public static void main(String[] args) {
		LightDisplay d1 = new LightDisplay(new LightPanel("153.106.116.89", LightSystem.DEFAULT_PORT));  
		LightDisplay d2 = new LightDisplay(new LightPanel("153.106.116.89", LightSystem.DEFAULT_PORT));

		BitHandler bit = new BitHandler("153.106.116.89", LightSystem.DEFAULT_PORT);
		try {
			bit.broadcastOne();
			bit.broadcastZero();
			bit.broadcastZero();
		} catch(CollisionException ex) {
		}

		// Give myself some time before moving on
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		try {
			bit.broadcast("0100110010");
		} catch(CollisionException ex) {
			System.out.println("caught");
		}

		// Give myself some time before moving on
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		BitDisplay bitDisp = new BitDisplay(bit);
	}

}
