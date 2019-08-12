package tiny_text_editor;

/**
 * @author Jin Woo Won jw3580
 * One of command classes that deletes text from Text.
 * Collaborates with Cursor and Text to respond to Talker.
 */
public class Deleter {
	/**
	 * Deletes the current line and moves up one line.
	 */
	public Deleter() {
		int cursorLocation = Cursor.getCursorLocation();
		Text.removeFromText(cursorLocation);
		Cursor.goUpOneLine();
	}
}
