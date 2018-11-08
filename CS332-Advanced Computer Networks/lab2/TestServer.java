/*
 * written by Josh Maguire
 * 3/23/2016
 * */

import java.util.*;

public class TestServer {
	public static void main(String[] args){
		//Host
		LightSystem system = new LightSystem();
		LightDisplay d1 = new LightDisplay(new LightPanel());
		BitHandler b1 = new BitHandler();
		BitDisplay g1 = new BitDisplay(b1);
		
	}
}
