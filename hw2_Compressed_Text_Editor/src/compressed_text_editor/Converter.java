package compressed_text_editor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Jin Woo Won jw3580
 * This class converts from and to TXT and CMP files.
 */
public class Converter {
	
	public static void convertToTXT(String fileName) {
		Fetcher fetcher = new Fetcher(fileName);
		String fileDirectory = "C:\\Users\\justi\\Documents\\Justin Won\\Columbia\\2017 Fall\\HonorsCS\\jw3580_HW2\\.txt files"
						+ "\\" + fileName + ".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileDirectory))) {
			String content;
			for (int i = 0; i < Text.getSize(); i++) {
				content = Text.getCompressedFromIndex(i);
				bw.write(content);
				bw.newLine();
			}
			System.out.println(fileName + " written.   Goodbye!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void convertToCMP(String fileName) {
		BufferedReader br = null;
		FileReader fr = null;
		List<String> text = new ArrayList<String>();
		String fileDirectory = "C:\\Users\\justi\\Documents\\Justin Won\\Columbia\\2017 Fall\\HonorsCS\\jw3580_HW2\\.txt files"
							+ "\\"
							+ fileName
							+ ".txt";
		boolean isValidInput = false;
		while (isValidInput != true) {
			try {
				br = new BufferedReader(new FileReader(fileDirectory));
				fr = new FileReader(fileDirectory);
				br = new BufferedReader(fr);
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					text.add(sCurrentLine);
				}
				isValidInput = true;
			} catch (IOException e) {
				String defaultName = "C:\\Users\\justi\\Documents\\Justin Won\\Columbia\\2017 Fall\\HonorsCS\\jw3580_HW2\\.txt files"
									+ "\\default.txt";
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
		//end of fetching
	Saver saver = new Saver(fileName);
	}
	
}

