import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/**
 * @author Jin Woo Won - jw3580
 * Helper class for TSVPipeline class.
 */
public class TSVPipelineHelper {
	/**
     * @param inString
     * @return String[] with split words from the input string.
     * Splits inputed string at \t.
     */
    protected static String[] splitRecord(String inString) {
    	String[] words = inString.split("\t");
    	return words;
    }
    
    /**
     * @param inStringArr
     * @param inLongArr
     * @return combined line as string
     * Combines string[] and long[] to form a line with tabs in between.
     */
    protected static String combineStrLong(String[] inStringArr, long[] inLongArr) {
    	String line = "";
    	for(int i = 0; i < inStringArr.length; i++) {
    		if(inStringArr[i] != "") {
    			line += inStringArr[i] + "\t";
    		}else if(inStringArr[i] == "") {
    			line += inLongArr[i] + "\t";
    		}
    	}
    	return line;
    }
    
    /**
	 * @param outputRecordIterator
	 * Writes the records stored in OutputRecord using outputRecordIterator.
	 */
	public void writeOutputRecord(Iterator<String> outputRecordIterator, Writer writer) {
		String outputStr = "";
		while (outputRecordIterator.hasNext()) {
			outputStr = outputRecordIterator.next();
			try {
				writer.write(outputStr);
				((BufferedWriter) writer).newLine();
			} catch (IOException e) {
				System.err.println("Output string cannot be written");
			}
		}
	}
	
	/**
	 * @param writer
	 * Completes file writing by closing BufferedWriter.
	 * Saves the file.
	 */
	public void saveFile(Writer writer) {
		try {
			writer.close();
		} catch (IOException e) {
			System.err.println("Output string cannot be written");
		}
	}
}
