/**
 * Mark Vander Stel
 * mbv26@students.calvin.edu
 */

/**
 * TestClient is a simple test class to test connecting to a LightServer (cable)
 * and be able to send messages to another machine on that cable.
 */
public class TestClient {
    public static void main(String[] args) {
        String address = "localhost";
        Layer2Display l1 = new Layer2Display(new L2GCHandler(address, LightSystem.DEFAULT_PORT, 16));
    }
}

