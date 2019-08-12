
public class Animal {
    
    public static int TotalAnimals;
    
    public String name;

    public static void main(String[] args) {
        Animal rabbit = new Animal();
        rabbit.name = "Bugs Bunny";
        rabbit.introduce();
    }
        
    public void introduce() {
        System.out.println("My name is " + name + "!");
    }

}
