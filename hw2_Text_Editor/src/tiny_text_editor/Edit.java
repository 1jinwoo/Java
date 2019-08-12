package tiny_text_editor;

import java.io.IOException;

/**
 * @author Jin Woo Won jw3580
 *This class creates an instance of Talker to initialize the program.
 */
public class Edit {
	private Talker talker;
	
	public Edit() {
		talker = new Talker();
	}
	
	public void start() throws IOException {
		talker.startEdit(); 
		while(true) {
			talker.callCommand();
		}
		
	}
}
