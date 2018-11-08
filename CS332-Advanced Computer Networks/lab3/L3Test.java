/* Tester for Layer 3 lab
 * Josh Maguire
 * 4/23/2016
 * 
 */
public class L3Test {
	public static void main(String[] args) {
		//testing L3Address
		L3Address L3a = new L3Address ("000100000011");
		System.out.println("Address = 000100000011");
		System.out.println(" toString() = " + L3a.toString());
		System.out.println("to Dot Decimal: " + L3a.toDottedDecimal());
		L3a.fromDottedDecimal("1111.11111111");
		System.out.println("from Dot Decimal Bcast: getters: " + L3a.getNetwork() + "," + L3a.getHost());
		L3Address L3b = new L3Address ("111111111111");
		assert(L3b.equals(L3a)==true);
		assert(L3b.isBcast()==true);
		
		//testing L3Packet
		L3Address L3A1 = new L3Address ("001000000010");
		L3Address L3A2 = new L3Address ("000100000011");
		L3Packet L3P1 = new L3Packet(L3A1,L3A2,0,"1111111100000000");
		System.out.println(L3P1.getDestAddr());
		assert(L3P1.getDestAddr() == L3A1);
		System.out.println(L3P1.getSrcAddr());
		assert(L3P1.getSrcAddr()==L3A2);
		assert(L3P1.getHopsLeft()==7);
		System.out.println(L3P1.length);
		assert(L3P1.length==2);
		System.out.println(L3P1.getL4Type());
		assert(L3P1.getL4Type()==0);
		System.out.println(L3P1.getParity());
		assert(L3P1.getParity()==1);
		System.out.println(L3P1.getPayload());
		assert(L3P1.getPayload()=="1111111100000000");
	}
}
