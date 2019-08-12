package tiny_text_editor;

/**
 * @author Jin Woo Won jw3580
 * This class handles printing commands.
 */
public class Printer {
	/**
	 * Prints all indices of the arrayList.
	 */
	public static void printAll() {
		for(int i = 0; i < Text.getSize(); i++) {
			System.out.println(Text.getFromIndex(i));
		}
	}
	/**
	 * Prints the element at where cursor is.
	 * Prints an error statement when text is empty.
	 */
	public static void printCurrentLine() {
		int cursorLocation = Cursor.getCursorLocation();
		if(Text.isEmpty()) {
			System.out.println("Invalid input. Please try again!");
		}else {
		System.out.println(Text.getFromIndex(cursorLocation));
		}
	}
}
