
public class Animal {
    
    public static int TotalAnimals = 0;
    
    public String name;

    public static void main(String[] args) {
        Animal rabbit = new Animal();
        rabbit.name = "Bugs Bunny";
        rabbit.introduce();
        
        System.out.println(Animal.TotalAnimals);
    }
    
    public Animal()	{
    	// increment to count the new instance creation
    	Animal.TotalAnimals++;
    }
    
    public Animal(String name)	{
    	this();
    	// in the first line of the constructor, 
    	// you can call another constructor declared in this class
    	
    	this.name = name;	// initialize name variable!
    }
        
    public void introduce() {
        System.out.println("My name is " + name + "!");
    }

    // class method version of introduce()
    public static void introduceStatic(Animal a)	{
    	System.out.println("My name is " + a.name + " from class method!");
    }
    
}
