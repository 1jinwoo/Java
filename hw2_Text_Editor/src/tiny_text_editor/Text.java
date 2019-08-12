package tiny_text_editor;

import java.util.*;

/**
 * @author Jin Woo Won jw3580
 * Stores the private arrayList of String[]. Gets and sets the arrayList.
 * Collaborates with Cursor and command classes.
 * Contains commands "p" and "c".
 */
public class Text {
	private static ArrayList<String> text = new ArrayList<String>();
	/**
	 * @param line
	 * Adds line string to the arrayList.
	 */
	public static void addToText(String line) {
		text.add(line);
	}
	public static void addToIndex(int index, String line) {
		text.add(index, line);
	}
	public static void removeFromText(int cursorLocation) {
		text.remove(cursorLocation);
	}
	public static void setToIndex(int index, String line) {
		text.set(index, line);
	}
	public static void clearText() {
		text.clear();
	}
	public static int getSize() {
		int size = text.size();
		return size;
	}
	public static String getFromIndex(int index) {
		String line = text.get(index);
		return line;
	}
	public static boolean isEmpty() {
		boolean emptiness = text.isEmpty();
		return emptiness;
	}
	
	
}
