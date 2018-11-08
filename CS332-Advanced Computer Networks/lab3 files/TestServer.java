/**
 * Mark Vander Stel
 * mbv26@students.calvin.edu
 */

/**
 * TestServer is a class to setup a LightSystem (wire) and a Layer 2 Display (machine)
 * so another machine can connect and talk. It also has a LightDisplay and BitDisplay
 * to make it easier to debug.
 */
public class TestServer {
    public static void main(String[] args) {
        LightSystem system = new LightSystem();
        LightDisplay d1 = new LightDisplay(new LightPanel());
        BitDisplay b1 = new BitDisplay(new BitHandler());
        Layer2Display l1 = new Layer2Display(new L2GCHandler("localhost", LightSystem.DEFAULT_PORT, 0));
    }
}

