

public class P4 {

	public static void main(String[] args) {
		
		// NOTE just for the testrun of Airplane class instance
		
		// assume lightweight plane :)
		Airplane a = new Airplane(10);
		
		a.addPassenger("Jack Black");
		a.addPassenger("Jude Law");
		a.addPassenger("Christian Bale");
		a.addPassenger("Scarlet Johansson");
		a.addPassenger("Joseph Gordon-Levitt");
		
		a.addPassenger("Tom Cruise");
		a.addPassenger("Will Smith");
		a.addPassenger("Anne Hathaway");
		a.addPassenger("Thomas Hardy");
		a.addPassenger("Gary Oldman");

		a.addPassenger("Morgan Freeman");	// has to reject, >10
		
		// print passengers
		a.printPassengers();
		
		
		
		// assume bigger plane :)
		Airplane b = new Airplane(20);
		
		b.addPassenger("Jack Black");
		b.addPassenger("Jude Law");
		b.addPassenger("Christian Bale");
		b.addPassenger("Scarlet Johansson");
		b.addPassenger("Joseph Gordon-Levitt");
		
		// print passengers
		b.printPassengers();
		
		
		
		// test passenger removal
		b.removePassenger(2);	// remove "Christian Bale"
		
		b.removePassenger(10);	// this time, operation must fail
		
		b.printPassengers();	// check if "Christian Bale" has removed
		
	}

}
