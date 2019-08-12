

public class Candidate {
	
	// Complete this class once again!
	
	// TODO declare a "class variable" to count how many candidate instances have created!
	
	
	
	// declare instance variables  (in previous lab)
	public int index;
	public String name;
	public static int counter;
	// TODO make a constructor! 
	public Candidate() {
		counter++;
	}
	
	
	
	// declare instance methods: introduce()  (in previous lab)
	public void introduce()	{
		System.out.println("Hello, I'm No. " + index + " " + name + "!");
	}
	
	
	// declare class method: introduceStatic()
	public static void introduceStatic(int index, String name) {
		System.out.println("Hello, I'm No. " + index + " " + name + "!");
		// TODO fill this method body
		
	}
		
}
