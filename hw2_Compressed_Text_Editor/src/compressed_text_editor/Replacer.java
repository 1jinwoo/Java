package compressed_text_editor;

/**
 * @author Jin Woo Won jw3580
 * One of Editor subclasses that replaces some text with new text in Text.
 * Collaborates with Cursor and Text to respond to Talker.
 */
public class Replacer {
	public Replacer() {
		Deleter deleter = new Deleter();
	}
	/**
	 * @param line
	 * Replaces current line with new line.
	 */
	public Replacer(String line) {
		int cursorLocation = Cursor.getCursorLocation();
		Text.setToIndex(cursorLocation, line);
	}
}
