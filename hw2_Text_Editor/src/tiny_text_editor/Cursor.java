package tiny_text_editor;

/**
 * @author Jin Woo Won jw3580
 * Keeps track of cursor's location.
 * Gets and sets the location.
 * Contains methods that move cursor location.
 */
public class Cursor {
	private static int cursorLocation = -1;
	/**
	 * @return cursorLocation
	 */
	public static int getCursorLocation() {
		return cursorLocation;
	}
	/**
	 * Increments cursorLocation, thus going down one line.
	 */
	public static void goDownOneLine() {
		cursorLocation++;
	}
	/**
	 * Decrements cursorLocation, thus going up one line.
	 */
	public static void goUpOneLine() {
		cursorLocation--;
	}
	/**
	 * Sets cursorLocation to zero, thus going to the top.
	 */
	public static void goToTop() {
		cursorLocation = 0;
	}
	
}
