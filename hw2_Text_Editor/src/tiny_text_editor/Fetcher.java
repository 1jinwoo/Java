package tiny_text_editor;

import java.io.*;

/**
 * @author Jin Woo Won jw3580
 * Command class for "g" - Get file from directory Works
 * with Text to get file from directory or create a new file.
 */
public class Fetcher{
	public static final String EXTENSION = ".txt";
	public static final String DEFAULTPATH = "C:\\Users\\justi\\Documents\\Justin Won\\Columbia\\2017 Fall\\HonorsCS\\jw3580_HW2\\.txt files";
	/**
	 * Creates a new file because file name is not specified.
	 */
	public Fetcher() {
		Text.clearText();
		try {
			File file = new File(DEFAULTPATH + "\\default.txt");
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * @param line
	 * Fetch the specified file from the DEFAULTPATH. Keeps ask the user
	 * if the file does not exist. Source:
	 * https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
	 */
	public Fetcher(String line) {
		Text.clearText();
		BufferedReader br = null;
		FileReader fr = null;
		String fileName = DEFAULTPATH + "\\" + line + EXTENSION;
		boolean isValidInput = false;
		while (isValidInput != true) {
			try {
				br = new BufferedReader(new FileReader(fileName));
				fr = new FileReader(fileName);
				br = new BufferedReader(fr);
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					Text.addToText(sCurrentLine);
				}
				isValidInput = true;
			} catch (IOException e) {
				String defaultName = DEFAULTPATH + "\\default.txt";
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(defaultName))) {
					String content;
					for (int i = 0; i < Text.getSize(); i++) {
						content = Text.getFromIndex(i) + "\n";
						bw.write(content);
					}
				} catch (IOException ex) {
					e.printStackTrace();
					System.out.println("No such file exists. Try Again.");
				}
				
				break;
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (IOException ex) {
					isValidInput = true;
				}
			}
		}

	}
}
