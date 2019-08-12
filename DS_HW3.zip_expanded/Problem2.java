import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */

public class Problem2 {
	
	public static void main(String[] args) {
		
		AvlTree indexTree = new AvlTree();
		
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);

			String sCurrentLine;
            int i = 1; // line number starts at 1
			while ((sCurrentLine = br.readLine()) != null) {
				String[] words = processLine(sCurrentLine);
				for(int j = 0; j < words.length; j++) {
					indexTree.indexWord(words[j], i);
				}
				
				i++;
			}
			
			indexTree.printIndex();
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] processLine(String line) {
			/* from https://stackoverflow.com/questions/18830813/
			 how-can-i-remove-punctuation-from-input-text-in-java
			 ?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa */
		String[] result = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split(" ");

		return result;
	}
}