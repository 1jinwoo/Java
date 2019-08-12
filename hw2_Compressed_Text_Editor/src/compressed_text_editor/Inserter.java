package compressed_text_editor;

/**
 * @author Jin Woo Won jw3580
 * One of command classes that inserts new text into Text.
 * Collaborates with Cursor and Text to respond to Talker.
 */
public class Inserter {
	/**
	 * @param line
	 * Insert a new line after the current line.
	 */
	public Inserter(String line) {
		Cursor.goDownOneLine();
		int cursorLocation = Cursor.getCursorLocation();
		Text.addToIndex(cursorLocation, line);		
	}

}
