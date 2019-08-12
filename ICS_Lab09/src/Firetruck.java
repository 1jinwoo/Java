
public class Firetruck extends Vehicle {
	
	private double hoseLength;	// the length of a water hose
	
	public Firetruck(String sound) {
		super(sound);
		// TODO because there is no default constructor
		// in superclass of this, so you have to explicitly
		// call a constructor of the superclass!
		// HINT you can call another constructor
		// only at the first line of a constructor!
		// HINT use a 'super' keyword!
		
	}
	
	public void setHoseLength(double hoseLength) {
		// TODO assign the value of parameter to a appropriate instance variable 
		hoseLength = this.hoseLength;
	}
	
	public void changeSound ( String sound ) {
		// TODO change sound of this vehicle
		// HINT because 'sound' in superclass is marked as 'private',
		// you cannot access to it directly,
		// so you'll want to use Vehicle's setter method
		super.changeSound(sound);
	}

	public void work () {
		// TODO write out codes to print messages as a slide
		System.out.println("Firetruck departured!");
		ring();
		System.out.println("Fire had extinguished!");
		
		
		
	}
	
	public void printInfo () {
		// TODO print information of this vehicle
		// HINT refer to ambulance's print_info() method
		System.out.print(
				"Firetruck)\n"
				+ "Hose length = " + hoseLength + " m\n"
				+ "Siren = ");
		super.ring();
		System.out.println();
	}
}
