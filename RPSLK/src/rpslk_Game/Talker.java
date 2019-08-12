package rpslk_Game;
import java.util.Scanner;

//to handle changing input, output specifications; to handle sloppy, ignorant, or malevolent humans
/**
 * @author Jin Woo Won
 * @param scanner
 * @return userInput
 * This class prints information on the program and returns userInput.
 */
public class Talker {

	public static String takeUserInput(Scanner scanner) {
		System.out.println("Enter one of the five: rock, paper, scissors, lizard, or spock"
							+ "\n"
							+ "Enter 'simple' to simulate 100 rounds using simulated human"
							+ "\n"
							+ "Enter 'smart' to simulate 100 rounds using AI and simulated human"
							+ "\n"
							+ "Enter 'z' to quit");
		String userInput = scanner.next();
		return userInput;
		
	}
	
	

}
