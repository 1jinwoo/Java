package compressed_text_editor;

import java.util.*;

/**
 * @author Jin Woo Won jw3580
 * Compresses the text using a dictionary.
 * Uncompresses the text when asked to return original text.
 */
public class Compressor {
	private static List<String> dictionary = new ArrayList<String>();
	/**
	 * @param line
	 * Creates a new dictionary if nothing is in dictionary.
	 * Adds words that are absent from dictionary if there are words in dictionary.
	 */
	public static void updateDictionary(String line) {
		String[] newWords = line.split(" ");
		for(String newWord: newWords) {
			dictionary.add(newWord);
		}
		Set<String> set = new LinkedHashSet<String>();
		set.addAll(dictionary);
		dictionary.clear();
		dictionary.addAll(set);
		//System.out.println(dictionary);
	}
	public static int[] compressLine(String line) {
		String[] words = line.split(" ");
		int[] result = new int[words.length]; 
		for(int i = 0; i < words.length; i++) {
			if(dictionary.contains(words[i])) {
				result[i] = dictionary.indexOf(words[i]);
			}else {
				System.out.println("dictionary error! Dictionary doesn't have enough!");
			}
		}
		return result;
	}
	public static String decompressLine(int[] compressedLine) {
		String[] decompressedWords = new String[compressedLine.length];
		String decompressedLine = "";
		for(int i = 0; i < compressedLine.length; i++) {//converts indices into words
			decompressedWords[i] = dictionary.get(compressedLine[i]);
		}
		for(int i = 0; i < decompressedWords.length; i++) {
			decompressedLine += decompressedWords[i] + " ";
		}
		return decompressedLine;
	}
	public static void clearDictionary() {
		dictionary.clear();
	}
	public static String getDictionaryLine() {
		String dictionaryLine = "";
		for(int i = 0; i < dictionary.size(); i++) {
			dictionaryLine += dictionary.get(i) + " ";
		}
		return dictionaryLine;
	}
}
