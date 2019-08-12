package tiny_text_editor;

import java.io.IOException;

/**
 * @author Jin Woo Won jw3580
 * Test Examples:
 * 		1. "g" test: simply typing "g" and no other commands creates default.txt (0 KB).
 * 		2. "s" test: simply typing "s" and no other commands creates default.txt (0 KB).
 * 		3. myfile test: following all the command sequence of the example in the assignment
 * 			creates myfile.txt (1 KB) with New first line written in it.
 * 		4. YODA test: inserting the following text as specified the assignment sheet:
 * 				This is the first one
 * 				This is the second one
 * 				This is not the second one
 * 				This the first one is not says Yoda
 * 				Yoda is the one
 * 				the second is not first
 * 		   yields an uncompressed file with the size of: 1.60 KB
 * 		   yields a compressed file with the size of: 1.23 KB
 * 		5. Compressed bigger than uncompressed test: the file with the following inserted:
 * 				ab bc cd ef gh
 * 				hi jk lm no pq
 * 				rs tu wx yz
 * 		   yields an uncompressed file with the size of: 0.48 KB
 * 		   yields a compressed file with the size of: 0.82 KB
 * 		6. printing empty file ("p") prints nothing.
 * 		7. printing current line ("c") when empty prints nothing.
 * 		8. replacing ("r") without specifying simply deletes.
 * 		9. inserting nothing ("i") inserts "null"
 * 		10. going to top line ("t") when file is empty does nothing.
 * 		11. going down ("v") in an empty file does nothing.
 */
public class TTETester {
	/**
	 * @param args
	 * Creates an instance of Edit
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Edit myEdit = new Edit();
		myEdit.start();
	}
}
