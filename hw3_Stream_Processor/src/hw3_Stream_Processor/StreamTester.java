
/**
 * @author Jin Woo Won - jw3580
 * Tests the Stream Processor.
 * The input file name must contain the word "input" in order
 * to produce output files that are named differently.
 * 
 * Overview:
 * 		- TSVFilter and WhichFile classes form a Builder pattern.
 * 		- TSVPipeline has the stream processing and other main methods, this class extends TSVPipelineHelper.
 * 		- TSVPipelineHelper has less important, helping methods.
 * 		- Record is an interface, which OutputRecord and InputRecord classes implement to form an Iterator pattern.
 * 		- Terminal is an enum of terminal computation constants.
 * 
 * Documentation:
 * 		- MOSTLYSAMECONST is set at 4; allows less than 4 different values.
 * 		- If the specified file does not exist, error message is displayed.
 * 		- The saved file has the same name as the input file except the word
 * 		  "input" is changed to "output".
 * 
 * Testing:
 * input file name						Filters					what it tests
 * ------------------------------------------------------------------------------------------------------------------------
 * input with nothing					none					shows blank input file error handling.
 * input without any records			none					shows handling of input file wiht just one line.
 * input with double tabs				none					filtering out only records with correct forms.					
 * input with short records				none					filtering out only records with correct number of columns.
 * input with long records				none					filtering out only records with correct number of columns.
 * input with strictly growing name		grows("Name")			grows also handles strings.
 * input with growing name				grows("Name")			chooses only the strings that set new record.
 * input with strictly increasing age	grows("Age")			grows handles long.
 * input with increasing age			grows("Age")			grows successfully handles irregularly increasing age.
 * input with 4 Franks					compute-Name,ALLSAME	filters out all records of correct form; false not all names are Frank
 * input with just Franks				compute-Name,ALLSAME	true all names are Frank
 * input with multiple age 20			compute-Age,COUNT		no grows, so counts the number of records
 * input with increasing age			compute-Age,MIN			finds minimum age ("20")
 * input with growing name				compute-Name,MIN		finds name with minimum char ("Alex")
 * input with increasing age			compute-AGE,MAX			finds maximum age ("205")
 * input with growing name				compute-Name,MAX		finds name with maximum char ("Zyra")
 * input with growing name				compute-Zip Code, SUM			finds sum of zip codes ("293949") 
 * input with 4 Franks					compute-Name,MOSTLYSAME			determines if there are less than 4 variants in name ("false")
 * input with just Franks				compute-Name,MOSTLYSAME			determines if there are less than 4 variants in name ("true")
 * input with just Franks				grows("Name"), compute-Age,COUNT	grows and compute work together (COUNT: 1)
 * input with growing name				grows("Name"), compute-Age,SUM		grows and compute work together (SUM: 99)
 */
public class StreamTester {
	public static final int MOSTLYSAMECONST = 4;
	public static void main(String[] args) {
		TSVFilter myTSVFilter = new TSVFilter
				.WhichFile("input with growing name")
				.grows("Name")
				.compute("Age", Terminal.MAX)
				.done();
		System.out.println(myTSVFilter);
		new TSVPipeline(myTSVFilter).processStream();
	}

}
