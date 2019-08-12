import java.io.*;
import java.util.Iterator;

/**
 * @author Jin Woo Won - jw3580
 * Reads a .tsv file one record at a time.
 * Checks the record for proper form.
 * If grows filter is used, returns only the records that set a new record
 * on the specified column.
 * If compute filter is used, prints out the result of the computation.
 * If both grows and compute filters are used, compute filter only looks at
 * those records that passed grows filter.
 */
public class TSVPipeline extends TSVPipelineHelper{
	
	private static String makeup = "";
	private static int columns;
	private String[] columnNames;
	private int indexOfMatch = -1;
	private int indexOfComputation = -1;
	private BufferedReader reader = null;
	private static Writer writer = null;
	private InputRecord inputRecord = null;
	private String[] processedRecord;
	private OutputRecord outputRecord = null;
	
	private String fileName;
	private String outputFileName;
	private String growsName;
	private String computeName;
	private Terminal computation;
	
	/**
	 * @param myTSVFilter
	 * Fetches specifications from TSVFilter class instance.
	 * Loads the file.
	 * Initiates a file writer.
	 * Separates records by temporarily replacing \n with ~.
	 */
	public TSVPipeline (TSVFilter myTSVFilter) {
		fileName = myTSVFilter.getFileName();
		growsName = myTSVFilter.getGrowsName();
		computeName = myTSVFilter.getComputeName();
		computation = myTSVFilter.getComputation();
		outputFileName = myTSVFilter.getOutputFileName();
		
		try{		
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
		String inputStr = "";
		try {
			String sCurrentLine;
			while((sCurrentLine = reader.readLine()) != null) {
			inputStr += sCurrentLine + "~";
			}
		} catch (IOException e) {
			System.err.println("Input string cannot be read");
		}
		inputRecord = new InputRecord(inputStr);
		processedRecord = new String[inputRecord.getSize()];
		
		try {
			writer = new BufferedWriter(new FileWriter(outputFileName));
		} catch (IOException e){
			System.err.println("Unable to save file");
		}
	}
	
	/**
	 * Master method that processes the whole stream.
	 * Initializes iterators.
	 * Passes necessary data into processStream with a parameter.
	 * Writes and saves the output file.
	 */
	public void processStream() {
		Iterator<String> inputRecordIterator = inputRecord.createIterator();
		processStream(inputRecordIterator);
		outputRecord = new OutputRecord(processedRecord);
		Iterator<String> outputRecordIterator = outputRecord.createIterator();
		writeOutputRecord(outputRecordIterator, writer);
		saveFile(writer);
	}
	
	/**
	 * Checks the record for proper form.
	 * Applies filters.
	 * Computation methods are called.
	 */
	public void processStream(Iterator<String> inputRecordIterator) {
		//processing the first line
		String firstLine = (String)inputRecordIterator.next();
		processFirstLine(firstLine);

		//processing other lines
		for(int i = 1; i < inputRecord.getSize(); i++) {
			//loop starts from 1 because the first line is already processed
			String currentLine = inputRecordIterator.next();
			processedRecord[i] = processLine(currentLine);
		}
		if(indexOfComputation != -1) {
			concludeCompute();
		}
	}
	
	/**
	 * @param firstLine
	 * Column names are recorded from the first line.
	 * Filters' column specification is marked.
	 * If there are multiple columns with the same name, this method
	 * picks the last column with the same name.
	 */
	public void processFirstLine(String firstLine) {
		columnNames = splitRecord(firstLine);
		columns = columnNames.length;
		if(!growsName.isEmpty()) {
			for(int i = 0; i < columns; i++) {
				if(growsName.equals(columnNames[i])) {
					indexOfMatch = i;
				}
			}
			if (indexOfMatch == -1) {
				System.err.println("Invalid column name for grows");
			}
		} 
		if (!computeName.isEmpty()) {
			for (int i = 0; i < columns; i++) {
				if (computeName.equals(columnNames[i])) {
					indexOfComputation = i;
				}
			}
			if (indexOfComputation == -1) {
				System.err.println("Invalid column name for compute");
			}
		}
		processedRecord[0] = firstLine;
	}

	/**
     * @param inLine
     * Creates String[] for words and long[] for numerals.
     * Records and checks the form of record.
     * Processes just one record, applying grows and other filters.
     */
	public String processLine(String inLine) {
		String currentLine = "";
		String[] lineWords = splitRecord(inLine);
		long[] numerals = new long[lineWords.length];
		if (lineWords.length == columns) {
			for (int i = 0; i < lineWords.length; i++) {
				try {
					numerals[i] = Long.parseLong(lineWords[i]);
					lineWords[i] = "";
				} catch (NumberFormatException e) {
					numerals[i] = -1;
				}
			}
			if(makeup.isEmpty()) {
				makeup = recordLine(lineWords);
			}
			if (isValidLine(lineWords, makeup)) {	// checking the if the line follows the form
				if ((indexOfMatch == -1) && (indexOfComputation == -1)) {
					currentLine = combineStrLong(lineWords, numerals);
				} else if ((indexOfMatch != -1) && (indexOfComputation != -1)) {
					if (isGrowing(lineWords, numerals) && computeExists()) {
						computeLine(lineWords, numerals);
						currentLine = combineStrLong(lineWords, numerals);
					}
				} else if ((indexOfMatch != -1) && (indexOfComputation == -1)) {
					if (isGrowing(lineWords, numerals) && !computeExists()) {
						currentLine = combineStrLong(lineWords, numerals);
					}
				} else if ((indexOfMatch == -1) && (indexOfComputation != -1)) {
					if (computeExists() && growsName.isEmpty()) {
						computeLine(lineWords, numerals);
						currentLine = combineStrLong(lineWords, numerals);
					}
				} else if ((indexOfMatch == -1) && (indexOfComputation == -1)) {
					if (growsName.isEmpty()) {
						currentLine = combineStrLong(lineWords, numerals);
					}
				}

				 
			}
		}
		return currentLine;
	}
	
	/**
	 * @return true if computation filter is applied, otherwise false.
	 */
	public boolean computeExists() {
		boolean result = false;
		if(!(computeName.isEmpty())) {
			result = true;
		}
		return result;
	}
	
	
	private boolean isAllSame = true;
	private boolean isMostlySame = true;
	private int mostlySameCount = 0;
	private String previousStr = "";
	private long previousLong = -1;
	private int count = 0;
	private String min = "";
	private String minStr = "";
	private long minLong = -1;
	private String max = "";
	private String maxStr = "";
	private long maxLong = -1;
	private long sum = 0;
	
	/**
	 * @param lineWords
	 * @param numerals
	 * Does what is necessary to compute using one record.
	 */
	public void computeLine(String[] lineWords, long[] numerals) {
		String word = lineWords[indexOfComputation];
		long number = numerals[indexOfComputation];
		switch (computation) {
		case ALLSAME:
			// true if all elements in the selected column of selected records are the same
			if (isAllSame) {
				if (!word.equals("")) {
					if (previousStr.equals("")) {
						previousStr = word;
					} else if (word.equals(previousStr)) {
						isAllSame = true;
						previousStr = word;
					} else {
						isAllSame = false;
					}
				} else {
					if (previousLong == -1) {
						previousLong = number;
					} else if (number == previousLong) {
						isAllSame = true;
						previousLong = number;
					} else {
						isAllSame = false;
					}
				}
			}
			break;
		case MOSTLYSAME:
			// true if all elements in the selected column of selected records differ by less than 4
						if (isMostlySame) {
							if (!word.equals("")) {
								if (previousStr.equals("")) {
									previousStr = word;
								} else if (word.equals(previousStr)) {
									isMostlySame = true;
									previousStr = word;
								} else {
									mostlySameCount++;
								}
							} else {
								if (previousLong == -1) {
									previousLong = number;
								} else if (number == previousLong) {
									isMostlySame = true;
									previousLong = number;
								} else {
									mostlySameCount++;
								}
							}
						}
		case COUNT:
			// count how many records are selected
			count++;
			break;
		case MIN:
			if(!word.equals("")) {
				if (minStr.equals("")) {
					minStr = word;
				} else if (word.charAt(0) < minStr.charAt(0)) {
					minStr = word;
				}
				min = minStr;
			} else {
				if (minLong == -1) {
					minLong = number;
				} else if (number < minLong) {
					minLong = number;
				}
				min = Long.toString(minLong);
			}
			break;
		case MAX:
			if(!word.equals("")) {
				if (maxStr.equals("")) {
					maxStr = word;
				} else if (word.charAt(0) > maxStr.charAt(0)) {
					maxStr = word;
				}
				max = maxStr;
			} else {
				if (maxLong == -1) {
					maxLong = number;
				} else if (number > maxLong) {
					maxLong = number;
				}
				max = Long.toString(maxLong);
			}
			break;
		case SUM:
			if(!word.equals("")) {
				System.err.println("Cannot operate SUM on string");
			} else {
				sum += number;
			}
			break;
		}
	}
	
	/**
	 * Prints out the results of the various computations.
	 */
	public void concludeCompute() {
		switch (computation) {
		case ALLSAME:
			System.out.println("ALLSAME: " + isAllSame);
			break;
		case MOSTLYSAME:
			if(mostlySameCount < StreamTester.MOSTLYSAMECONST) {
				isMostlySame = true;
			} else {
				isMostlySame = false;
			}
			System.out.println("MOSTLYSAME: " + isMostlySame);
			break;
		case COUNT:
			System.out.println("COUNT: " + count);
			break;
		case MIN:
			System.out.println("MIN: " + min);
			break;
		case MAX:
			System.out.println("MAX: " + max);
			break;
		case SUM:
			System.out.println("SUM: " + sum);
			break;
		}
	}
	
	private String recordStr = ""; 
	private long recordLong = -1;
	
	/**
	 * @param lineWords
	 * @param numerals
	 * @return true if the record sets a new record in specified column
	 * Decision maker method for grows filter.
	 */
	public boolean isGrowing(String[] lineWords, long[] numerals) {
		boolean result = false;
		String word = lineWords[indexOfMatch];
		long number = numerals[indexOfMatch];
		if(!word.equals("")) {
			if (recordStr.equals("")) {
				recordStr = word;
				result = true;
			} else if (word.charAt(0) > recordStr.charAt(0)) {
				recordStr = word;
				result = true;
			}
		} else {
			if (recordLong == -1) {
				recordLong = number;
				result = true;
			} else if (number > recordLong) {
				recordLong = number;
				result = true;
			}
		}
		return result;
	}
    
    /**
     * @param inStringArr
     * @return true if valid, false is invalid
     * Determines if the line follows the form using the String makeup.
     * 1 is interpreted as String.
     * 0 is interpreted as long.
     */
    public boolean isValidLine(String[] inStringArr, String makeup) {
    	String lineRecord ="";
    	for (int i = 0; i < inStringArr.length; i++) {
    		if(inStringArr[i] != "") {
    			lineRecord += "1";
    		}else {
    			lineRecord += "0";
    		}
    	}
    	boolean isValidLine = false;
    	if(makeup.equals(lineRecord)) {
    		isValidLine = true;
    	}
    	return isValidLine;
    }
    
    /**
     * @param inStringArr
     * @return makeup
     * Records in makeup the makeup of one record.
     * String is recorded as 1.
     * Long is recorded as 0.
     */
    public static String recordLine(String[] inStringArr) {
    	String makeup ="";
    	for(int i = 0; i < inStringArr.length; i++) {
			if(inStringArr[i] != "") {
				makeup += "1";
			}else {
				makeup += "0";
			}
		}
		return makeup;
    }
}