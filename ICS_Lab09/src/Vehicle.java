
public class Vehicle {
	private String sound;
	
	public Vehicle(String sound)	{
		this.changeSound(sound);
	}
	
	protected void changeSound(String sound)	{
		this.sound = sound;
	}
	
	protected void ring () {
		System.out.println(sound);
	}
	
}
