
/*
 * Class to test the functionality of the LightSystem and LightDisplay classes at layer 2
 *		including the L2GCFrame, L2GCHandler, Layer2Listener, and Layer2Display classes
 * @author: Joel Stehouwer (jbs24)
 * Feb 16, 2016 for CS 332 at Calvin College 
 */

public class Test {

	public static void main(String[] args) {
		LightSystem system = new LightSystem();
		LightDisplay d1 = new LightDisplay(new LightPanel());

		// Create and display 3 Layer2Displays
		L2GCHandler hand = new L2GCHandler(1);
		Layer2Display disp = new Layer2Display(hand);
		L2GCHandler hand2 = new L2GCHandler(2);
		Layer2Display disp2 = new Layer2Display(hand2);
		L2GCHandler hand3 = new L2GCHandler(3);
		Layer2Display disp3 = new Layer2Display(hand3);
	}

}


