
public class VehicleTestDrive {

	public static void main(String[] args) {
		
		// instance references are declared
		Ambulance a;
		Firetruck f;
		
		// TODO create a instance for each subclass
		a = new Ambulance("AAAng!");
		f = new Firetruck("Urggg!");
		
		// TODO set dedicated property for each instance
		a.setAccom(2000);
		f.setHoseLength(20.0);
		
		// TODO call printInfo() to print information for each instance
		a.printInfo();
		f.printInfo();
		
		
		
		// TODO before departure, please change the siren of an ambulance
		a.changeSound("Dayumn!");
		
		// TODO now, go for a work!
		a.work();
		f.work();
		
		
		
		// there is some claims...
		// firetruck's siren is not that useful
		// TODO change firetruck's siren sound
		f.changeSound("shoot");
		
		// ambulance is not that large to accommodate those many people
		// TODO reduce ambulance's accommodation
		a.setAccom(555); 
		
		// TODO finally, print information of each vehicle once more
		a.printInfo();
		f.printInfo();
		
		
	}

}
