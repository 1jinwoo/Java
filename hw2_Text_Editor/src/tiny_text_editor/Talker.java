package tiny_text_editor;

import java.util.*;
import java.io.IOException;

/**
 * @author Jin Woo Won jw3580
 * Prompt user to input commands and relay and call commands to handle those events.
 */
public class Talker {
	public static boolean firstInsert = false;
	private Scanner scanner;
	/**
	 * Initialize Scanner to take in user input.
	 */
	public Talker() {
		scanner = new Scanner(System.in);
	}
	/**
	 * Prints initialization declaration.
	 */
	public void startEdit() {
		System.out.println("Start editing!");
	}
	/**
	 * Prints symbol to prompt user input.
	 */
	public void askForInput() {
		System.out.print(">");
	}
	
	/**
	 * Call command that corresponds to user's input if the input is valid.
	 * Prompts the user to try again if input is invalid.
	 * "q" - Quit command is not included as use case doesn't utilize it.
	 * @throws IOException 
	 */
	public void callCommand() throws IOException {
		boolean isValidInput = false;
		while(!isValidInput) {
			askForInput();
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("p")) {
				Printer.printAll();	
				isValidInput = true;
			} else if(input.equalsIgnoreCase("c")) {
				Printer.printCurrentLine();	
				isValidInput = true;
			} else if(input.equalsIgnoreCase("d")) {
				Deleter deleter = new Deleter();
				isValidInput = true;
			} else if(input.equalsIgnoreCase("t")) {
				Cursor.goToTop(); 
				isValidInput = true;
			} else if(input.equalsIgnoreCase("v")) {
				Cursor.goDownOneLine(); 
				isValidInput = true;
			} else if(input.equalsIgnoreCase("g")){
				Fetcher fetcher = new Fetcher();
				isValidInput = true;
			} else if(input.equalsIgnoreCase("s")) {
				Saver saver = new Saver();
				isValidInput = true;
			} else {
				String[] inputParts = input.split(" ");
				String command = inputParts[0];
				String line = extractCommand(inputParts);
				if(command.equalsIgnoreCase("g")) {
					Fetcher fetcher = new Fetcher(line);
					isValidInput = true;
				}else if(command.equalsIgnoreCase("i")) {
					Inserter inserter = new Inserter(line);
					isValidInput = true;
				} else if(command.equalsIgnoreCase("r")) {
					Replacer replacer = new Replacer(line);
					isValidInput = true;
				} else if(command.equalsIgnoreCase("s")) {
					Saver saver = new Saver(line);	
					isValidInput = true;
				} else {
					System.out.println("Invalid input. Try again.");
				}
			}
		}
	}
	/**
	 * @param inputParts
	 * @return extractedText
	 * This method strings together all the words that come after the first.
	 * In other words, it strings together the line to be inserted with spaces.
	 */
	private String extractCommand(String[] inputParts) {
		String extractedCommand;
		if (inputParts.length > 1) {
			extractedCommand = inputParts[1] + " ";
			for (int i = 2; i < inputParts.length; i++) {
				String partWithSpace = inputParts[i] + " ";
				extractedCommand += partWithSpace;
			}
		} else {
			extractedCommand = null;
		}
		return extractedCommand;
	}
}
