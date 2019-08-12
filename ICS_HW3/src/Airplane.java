

public class Airplane {
	
	private int maxPassenger;
	private String[] passengerNames;
	
	private int passengers;
		
	public Airplane(int _maxPassenger)	{
		maxPassenger = _maxPassenger;
		passengers = 0;
		
		passengerNames = new String[maxPassenger];
	}
	
	public void addPassenger(String name)	{
		
		if (passengers >= maxPassenger)	{
			System.out.println("Airplane full!");
			return;
		}
		
		passengerNames[passengers++] = name;
	}
	
	public void printPassengers()	{
		
		for (int i = 0; i < passengers; i++)	{
			System.out.println((i+1) + "th: " + passengerNames[i]);
		}
		System.out.println("Total: " + passengers);
	}
	
	public void removePassenger(int index)	{
		if (passengers == 0)	{
			System.out.println("Target passenger is nonexistence!");
			return;
		}
		for (int t = index; t < passengers; t++)	{
			if (t == passengers - 1)	{
				passengerNames[t] = null;
			}	else	{
				for(; t - 1 < passengers; t++) {
					passengerNames[t] = passengerNames[t+1];
				}
				passengers--;
			}
		}
	}
}
