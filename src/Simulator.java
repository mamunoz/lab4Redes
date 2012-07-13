import models.Router0;
import models.Router1;
import models.Router2;
import models.Router3;


public class Simulator {
	private Router0 router0;
	private Router1 router1;
	private Router2 router2;
	private Router3 router3;

	/**
	 * @param packet
	 * @param dt0
	 */
	public Simulator() {
		router0 = new Router0();
		router1 = new Router1();
		router2 = new Router2();
		router3 = new Router3();
		
		router0.rinit0();
		router1.rinit1();
		router2.rinit2();
		router3.rinit3();
		
		
		System.out.println("                via     ");
		System.out.println("   R0 |    1     2    3 ");
		System.out.println("  ----|-----------------");
		System.out.println("     1|  " + router0.getCosts().get(1).get(1) +"   "+router0.getCosts().get(1).get(2)+"   "+router0.getCosts().get(1).get(3));
		System.out.println("dest 2|  " + router0.getCosts().get(2).get(1) +"   "+router0.getCosts().get(2).get(2)+"   "+router0.getCosts().get(2).get(3));
		System.out.println("     3|  " + router0.getCosts().get(3).get(1) +"   "+router0.getCosts().get(3).get(2)+"   "+router0.getCosts().get(3).get(3));
		
		System.out.println("                via     ");
		System.out.println("   R1 |    0     2    3 ");
		System.out.println("  ----|-----------------");
		System.out.println("     0|  " + router1.getCosts().get(0).get(0) +"   "+router1.getCosts().get(0).get(2)+"   "+router1.getCosts().get(0).get(3));
		System.out.println("dest 2|  " + router1.getCosts().get(2).get(0) +"   "+router1.getCosts().get(2).get(2)+"   "+router1.getCosts().get(2).get(3));
		System.out.println("     3|  " + router1.getCosts().get(3).get(0) +"   "+router1.getCosts().get(3).get(2)+"   "+router1.getCosts().get(3).get(3));
		
		System.out.println("                via     ");
		System.out.println("   R2 |    0     1    3 ");
		System.out.println("  ----|-----------------");
		System.out.println("     0|  " + router2.getCosts().get(0).get(0) +"   "+router2.getCosts().get(0).get(1)+"   "+router2.getCosts().get(0).get(3));
		System.out.println("dest 1|  " + router2.getCosts().get(1).get(0) +"   "+router2.getCosts().get(1).get(1)+"   "+router2.getCosts().get(1).get(3));
		System.out.println("     3|  " + router2.getCosts().get(3).get(0) +"   "+router2.getCosts().get(3).get(1)+"   "+router2.getCosts().get(3).get(3));
		
		System.out.println("                via     ");
		System.out.println("   R3 |    0     1    2 ");
		System.out.println("  ----|-----------------");
		System.out.println("     0|  " + router3.getCosts().get(0).get(0) +"   "+router3.getCosts().get(0).get(1)+"   "+router3.getCosts().get(0).get(2));
		System.out.println("     1|  " + router3.getCosts().get(1).get(0) +"   "+router3.getCosts().get(1).get(1)+"   "+router3.getCosts().get(1).get(2));
		System.out.println("     2|  " + router3.getCosts().get(2).get(0) +"   "+router3.getCosts().get(2).get(1)+"   "+router3.getCosts().get(2).get(2));
		
	}

}
