import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jin Woo Won - jw3580
 * Implementation of Record. Stores output records.
 */
public class OutputRecord implements Record {
	private ArrayList<String> outputRecord = null;
	
	/**
	 * @param processedRecord
	 * Calls removeEmptyFrom to generate outputRecord.
	 */
	public OutputRecord(String[] processedRecord) {
		this.outputRecord = removeEmptyFrom(processedRecord);
	}
	
	/*
	 * @see Record#createIterator()
	 * Creates java.util.Iterator.
	 */
	@Override
	public Iterator<String> createIterator(){
		return outputRecord.iterator();
	}
	
	/*
	 * @see Record#getSize()
	 * Gets the size of outputRecord.
	 */
	@Override
	public int getSize() {
		return outputRecord.size();
	}
	
	/**
     * @param processedRecord
     * @return outputRecord
     * Generates outputRecord by removing null elements from processedRecord
     */
    public static ArrayList<String> removeEmptyFrom(String[] processedRecord) {
    	ArrayList<String> outputRecord = new ArrayList<String>();
    	for(int i = 0; i < processedRecord.length; i++) {
    		if(processedRecord[i] != "") {
    			outputRecord.add(processedRecord[i]);
    		}
    	}
    	System.out.println(outputRecord);
    	return outputRecord;
    }
}
