package compressed_text_editor;

import java.io.IOException;

/**
 * @author Jin Woo Won jw3580
 *This class creates an instance of Talker to initialize the program.
 */
public class Edit {
	private Talker talker;
	
	/**
	 * Creates an instance of Talker class.
	 */
	public Edit() {
		talker = new Talker();
	}
	
	/**
	 * @throws IOException
	 * Initiates the editor.
	 */
	public void start() throws IOException {
		talker.startEdit(); 
		while(true) {
			talker.callCommand();
		}
		
	}
}
