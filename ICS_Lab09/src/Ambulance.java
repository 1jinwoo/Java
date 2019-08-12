
public class Ambulance extends Vehicle {

	private int accom;	// maximum accommodation
	
	public Ambulance(String sound) {
		super(sound);
		
		// TODO because there is no default constructor
		// in superclass of this, you have to explicitly
		// call a constructor of the superclass!
		// HINT you can call another constructor
		// only at the first line of a constructor!
		// HINT use a 'super' keyword!
		
	}
	
	public void setAccom(int accom) {
		// TODO assign the value of parameter to a appropriate instance variable
		accom = this.accom;
		
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
		System.out.println("Ambulance departured!");
		ring();
		System.out.println("Transferred a patient to the hospital!");
		
		
	}
	
	public void printInfo () {
		// print information of this vehicle
		System.out.print(
				"Ambulance)\n"
				+ "Accommodation = " + accom + " people\n"
				+ "Siren = ");
		super.ring();
		System.out.println();
	}
}
