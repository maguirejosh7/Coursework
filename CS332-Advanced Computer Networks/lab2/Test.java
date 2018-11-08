
import java.util.*;

public class Test {
	public static void main(String[] args) {
		// Lab 2
		LightSystem system = new LightSystem();
		LightDisplay ldisp = new LightDisplay(new LightPanel());

		L2GCHandler l2h1 = new L2GCHandler(1);
		Layer2Display l2d1 = new Layer2Display(l2h1);

		L2GCHandler l2h2 = new L2GCHandler(2);
		Layer2Display l2d2 = new Layer2Display(l2h2);

		L2GCHandler l2h3 = new L2GCHandler(3);
		Layer2Display l2d3 = new Layer2Display(l2h3);

		// Lab 1
		// Host
		// LightSystem system = new LightSystem();
		// LightDisplay d1 = new LightDisplay(new LightPanel());

		// Client
		// LightPanel l1 = new LightPanel("153.106.116.81",
		// LightSystem.DEFAULT_PORT);
		// LightPanel l2 = new LightPanel("153.106.116.81",
		// LightSystem.DEFAULT_PORT);

		// BitHandler b1 = new BitHandler("153.106.116.81",
		// LightSystem.DEFAULT_PORT);
		// BitHandler b1 = new BitHandler();
		// BitDisplay g1 = new BitDisplay(b1);

		// try{
		// b1.broadcast("1101100101010111000");
		// } catch (CollisionException e){
		// System.out.println("WHAAAA");
		// }

	}
}
