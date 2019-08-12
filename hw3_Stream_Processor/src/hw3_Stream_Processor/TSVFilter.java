
/**
 * @author Jin Woo Won - jw3580
 * Outer object class to create an object with all the options applied.
 */
public class TSVFilter {
	// make constructor for TSVFilter private to protect WhichFile pattern
	/**
	 * @param inWhichFile
	 * Private constructor that fetches all the information in WhichFile object.
	 */
	private TSVFilter(WhichFile inWhichFile) {
		fileName = inWhichFile.fileName;
		outputFileName = inWhichFile.outputFileName;
		computeName = inWhichFile.computeName;
		computation = inWhichFile.computation;
		growsName = inWhichFile.growsName;
	}

	/**
	 * @return fileName
	 * Gets fileName.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @return outputFileName
	 * Gets outputFileName.
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * @return growsName
	 * Gets growsName.
	 */
	public String getGrowsName() {
		return growsName;
	}
	
	/**
	 * @return computeName
	 * Gets computeName.
	 */
	public String getComputeName() {
		return computeName;
	}
	
	/**
	 * @return computation
	 * Gets computation, which is a Terminal constant.
	 */
	public Terminal getComputation() {
		return computation;
	}

	/* 
	 * @see java.lang.Object#toString()
	 * Prints out TSVFilter's variables.
	 */
	@Override
	public String toString() {
		return "TSVFilter " + "{ fileName = " + fileName + "\n"
							+ ", growsName = " + growsName + "\n"
							+ ", computeName = " + computeName + "\n"
							+ ", computation = " + computation + "\n }";
	}

	/**
	 * @author Jin Woo Won - jw3580
	 * Inner object class that builds options on its instance.
	 */
	public static class WhichFile {
		private final String filePath = "C:\\Users\\justi\\Documents"
										+ "\\Justin Won\\Columbia\\2017"
										+ " Fall\\HonorsCS\\jw3580_HW3\\";

		/**
		 * @param inFileName
		 * Builder method for required parameter.
		 * The constructor of the base.
		 */
		public WhichFile(String inFileName) {
			fileName = filePath + inFileName + ".tsv";
			outputFileName = filePath + inFileName.replaceFirst("input", "output") + ".tsv";
		}
		
		/**
		 * @param inGrowsName
		 * @return WhichFile object
		 * Constructs WhichFile object with growsName specified.
		 */
		public WhichFile grows(String inGrowsName) {
			growsName = inGrowsName;
			return this;
		}

		/**
		 * @param inComputeName
		 * @param terminal
		 * @return WhichFile object
		 * Constructs WhichFile object with computeName and computation specified.
		 */
		public WhichFile compute(String inComputeName, Terminal terminal) {
			computeName = inComputeName;
			computation = terminal;
			return this;
		}

		/**
		 * @return TSVFilter object with all the options applied.
		 */
		public TSVFilter done() {
			return new TSVFilter(this);
		}

		// required parameters for WhichFile
		private final String fileName;
		private final String outputFileName;
		// optional parameters
		private String growsName = "";
		private String computeName = "";
		private Terminal computation;
	}

	// required parameters for TSVFilter
	private final String fileName;
	private final String outputFileName;
	// optional parameters
	private final String growsName;
	private final String computeName;
	private final Terminal computation;
}
