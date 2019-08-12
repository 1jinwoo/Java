import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* Following the specification in the README.md file, provide your 
 * SpellChecker class.
 */

public class SpellChecker {
	
	private HashSet<String> dictionary;
	
	/**
	 * @param args
	 * Takes in two command-line arguments: 1. dictionary in .txt
	 * 										2. file to spellcheck in .txt
	 * Output all misspelled words and the line numbers in which
	 * they occur. Also, for each misspelled word, list any words in the dictionary that are
     * obtainable by applying any of the following rules:
     * 		a. Add one character.
     * 		b. Remove one character.
     * 		c. Exchange adjacent characters.
	 */
	public static void main(String[] args) {
				
		SpellChecker sc = new SpellChecker(args);
				
			// spellcheck
		int i = 0;
		try {
			FileReader fr = new FileReader(args[1]);
			BufferedReader br = new BufferedReader(fr);
			
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				sc.spellCheck(sCurrentLine, ++i);
			}
			
			br.close();
			fr.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public SpellChecker(String[] args) {
		dictionary = new HashSet<>();

		// process dictionary
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				dictionary.add(processLine(sCurrentLine));
			}
			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param line
	 * @return processed line that is lowercase and with all prefixed,
	 * 				and postfixed punctuations removed.
	 * For example, "!!!Carl!!!" would output "carl".
	 */
	private String processLine(String line) {
			
		return line.trim().toLowerCase().replaceFirst("[^a-z0-9]+", "")
				.replaceAll("[^a-z0-9]+$", "");
	}
	
	public void spellCheck(String line, int lineNumber) {
		String[] temp = line.split(" ");
		List<String> words = new ArrayList<>();
		
		for(String word : temp) {
			words.add(processLine(word));
		}
		
		for(String word : words) {
			if(!dictionary.contains(word)) {
				System.out.println(word + " in " + lineNumber + " " + findSuggestions(word));
			}
		}
	}
	
	public Set<String> findSuggestions(String word){
		Set<String> suggestions = new TreeSet<>();		
		
			// add one character
		char[] additions = "abcdefghijklmnopqrstuvwxyz'".toCharArray();
		for(char addition : additions) {
			for(int i = 0; i <= word.length(); i++) {
				StringBuilder str = new StringBuilder(word);
				str.insert(i, addition);

				if (dictionary.contains(str.toString())) {
					suggestions.add(str.toString());
				}
			}
		}
		
			// remove one character
		for(int i = 0; i < word.length(); i++) {
			StringBuilder str = new StringBuilder(word);
			str.replace(i, i + 1, "").trimToSize();;
			
			if (dictionary.contains(str.toString())) {
				suggestions.add(str.toString());
			}
		}
		
			// exchange adjacent characters
		char[] letters = word.toCharArray();
		for(int i = 0; i < word.length() - 1; i++) {
			char temp = letters[i];
			letters[i] = letters[i + 1];
			letters[i + 1] = temp;
			
			String candidate = "";
			
			for(int k = 0; k < letters.length; k++) {
				candidate += String.valueOf(letters[k]);
			}
			
			
			if (dictionary.contains(candidate)) {
				suggestions.add(candidate);
			}
			
			char tmp = letters[i + 1];
			letters[i + 1] = letters[i];
			letters[i] = tmp;
			
			
		}
		
		
		return suggestions;
	}
}