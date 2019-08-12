package compressed_text_editor;

import java.util.*;

/**
 * @author Jin Woo Won jw3580
 * Stores the private arrayList of String[]. Gets and sets the arrayList.
 * Collaborates with Cursor and command classes.
 * Contains commands "p" and "c".
 */
public class Text {
	private static ArrayList<int[]> compressedText = new ArrayList<int[]>();
	/**
	 * @param line
	 * Adds line string to the arrayList.
	 */
	public static void addToText(String line) {
		Compressor.updateDictionary(line);
		int[] compressedLine = Compressor.compressLine(line);
		compressedText.add(compressedLine);
	}
	/**
	 * @param compressedLine
	 * Adds compressed text with indices straight to compressedText.
	 * Used to get compressed file into the program memory.
	 */
	public static void addToCompressedText(String compressedLine) {
		String[] stringIndices = compressedLine.split(" ");
		int[] indices = new int[stringIndices.length];
		for(int i = 0; i < stringIndices.length; i++) {
			indices[i] = Integer.parseInt(stringIndices[i]);
		}
		compressedText.add(indices);
	}
	public static void addToIndex(int index, String line) {
		Compressor.updateDictionary(line);
		int[] compressedLine = Compressor.compressLine(line);
		compressedText.add(index, compressedLine);
	}
	public static void removeFromText(int cursorLocation) {
		compressedText.remove(cursorLocation);
	}
	public static void setToIndex(int index, String line) {
		Compressor.updateDictionary(line);
		int[] compressedLine = Compressor.compressLine(line);
		compressedText.set(index, compressedLine);
	}
	public static void clearText() {
		compressedText.clear();
	}
	public static int getSize() {
		int size = compressedText.size();
		return size;
	}
	public static String getFromIndex(int index) {
		int[] compressedLine = compressedText.get(index);
		String decompressedLine = Compressor.decompressLine(compressedLine);
		return decompressedLine;
	}
	public static String getCompressedFromIndex(int index) {
		int[] compressedWords = compressedText.get(index);
		String compressedLine = "";
		for(int i = 0; i < compressedWords.length; i++) {
			compressedLine += compressedWords[i] + " ";
		}
		return compressedLine;
	}
	public static boolean isEmpty() {
		boolean emptiness = compressedText.isEmpty();
		return emptiness;
	}
}
