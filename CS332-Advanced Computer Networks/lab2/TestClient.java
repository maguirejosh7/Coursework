import java.util.*;

public class TestClient {
	public static void main(String[] args){
		//Client
		LightPanel l1 = new LightPanel("153.106.116.61", LightSystem.DEFAULT_PORT);
		BitHandler b1 = new BitHandler("153.106.116.61", LightSystem.DEFAULT_PORT);
		BitDisplay g1 = new BitDisplay(b1);
		
	}
} 
