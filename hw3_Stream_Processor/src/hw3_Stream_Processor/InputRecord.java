import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jin Woo Won - jw3580
 * Implementation of Record. Stores input records.
 */
public class InputRecord implements Record {
	private ArrayList<String> inputRecord = null;
	
	/**
	 * @param inStr
	 * Splits inStr with splitRecords method.
	 */
	public InputRecord(String inStr) {
		this.inputRecord = splitRecords(inStr);
	}
	
	/*
	 * @see Record#createIterator()
	 * Creates an iterator.
	 */
	@Override
	public Iterator<String> createIterator() {
		return inputRecord.iterator();
	}
	
	/*
	 * @see Record#getSize()
	 * gets the size of inputRecord.
	 */
	@Override
	public int getSize() {
		return inputRecord.size();
	}
	
	/**
	 * @param inStr
	 * @return ArrayList of split records.
	 * Splits lines at ~ because it was earlier encoded so that
	 * \n would be ~'s.
	 */
	public ArrayList<String> splitRecords(String inStr) {
		ArrayList<String> lineList = new ArrayList<String>();
		String[] lineArr = inStr.split("~");
		for(String word : lineArr) {
			lineList.add(word);
		}
		return lineList;
	}
}
