/**
 * Mark Vander Stel
 * mbv26@students.calvin.edu
 */

/**
 * TestHeadlessServer is a (custom) class for testing Layer 2 stuff without
 * having a GUI handy (ahem). It uses the Layer2Echo class to have a machine
 * echo anything sent to it on the wire.
 */
public class TestHeadlessServer {
    public static void main(String[] args) {
        int port = LightSystem.DEFAULT_PORT;
        LightSystem system = new LightSystem(port);
        Layer2Echo l1 = new Layer2Echo(new L2GCHandler("localhost", port, 0));
    }
}

