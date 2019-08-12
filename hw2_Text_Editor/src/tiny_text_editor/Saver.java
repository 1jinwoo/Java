package tiny_text_editor;

import java.io.*;

/**
 * @author Jin Woo Won jw3580
 * Class for command "s"
 * Sets file to the directory.
 * Names the file as well as append ".txt" to the end automatically.
 * Because the use case does not use "q" - Quit to quite,
 * Saver also terminates the program.
 */
public class Saver {
	public static final String EXTENSION = ".txt";
	public static final String DEFAULTPATH = "C:\\Users\\justi\\Documents\\Justin Won\\Columbia\\2017 Fall\\HonorsCS\\jw3580_HW2\\.txt files";
	/**
	 * Called when no file name is specified.
	 * Saves the file as "default.txt" in the DEFAULTPATH.
	 */
	public Saver() {
		String fileName = DEFAULTPATH + "\\default.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			String content;
			for (int i = 0; i < Text.getSize(); i++) {
				content = Text.getFromIndex(i) + "\n";
				bw.write(content);
			}
			System.out.println("default written.   Goodbye!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @param line
	 * Called when file name is specified.
	 * Saves the file as line in the DEFAULTPATH.
	 */
	public Saver(String line) {
		String fileName = DEFAULTPATH + "\\" + line + ".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			String content;
			for (int i = 0; i < Text.getSize(); i++) {
				content = Text.getFromIndex(i);
				bw.write(content);
				bw.newLine();
			}
			System.out.println(line + " written.   Goodbye!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
