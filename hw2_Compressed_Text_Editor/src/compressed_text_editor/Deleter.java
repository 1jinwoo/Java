package compressed_text_editor;

/**
 * @author Jin Woo Won jw3580
 * One of Editor subclasses that deletes text from Text.
 * Collaborates with Cursor and Text to respond to Talker.
 */
public class Deleter {
	public static String cutLine = null;
	/**
	 * Deletes the current line and moves up one line.
	 * Saves the cut part in cutLine to later paste.
	 */
	public Deleter() {
		int cursorLocation = Cursor.getCursorLocation();
		cutLine = Text.getFromIndex(cursorLocation);
		Text.removeFromText(cursorLocation);
		Cursor.goUpOneLine();
	}
	/**
	 * Similar to Inserter but only inserts what is stored in cutLine.
	 */
	public static void paste() {
		int cursorLocation = Cursor.getCursorLocation();
		Text.addToIndex(cursorLocation, cutLine);
		Cursor.goDownOneLine();
	}
	
}
