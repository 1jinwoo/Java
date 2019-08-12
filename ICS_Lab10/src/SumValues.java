import java.io.*;

public class SumValues {

	public static void main(String[] args) throws IOException {
		
		double result;
		
		result = sumValues("coffee.txt");	// => 7.8
		System.out.println("sumValues() method returns: " + result);
		
		System.out.println();
		
		result = sumValues("plants.txt");	// => 28.7
		System.out.println("sumValues() method returns: " + result);
		
	}
	
	public static double sumValues(String filename) throws IOException	{
		// NOTE assume that a textfile contains:
		// (first line): the number of elements
		// (for each two lines after the first line):
		//    one line for an entry name, and next line for the entry value
		// --e.g. in coffee.txt--
		// 2
		// Prim
		// 2.7
		// Sugar
		// 5.1
		// --------
		
		// TODO write your code!
		BufferedReader cof = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String f = cof.readLine();
		int first = 0;
		first = Integer.parseInt(f);
		double sum = 0;
		for(int i = 0; i < first; i++) {
			String name = cof.readLine();
			String value = cof.readLine();
			System.out.println(name+ " " + value);
			double a = Double.parseDouble(value);
			sum = sum + a;
		}
		
		
	
		cof.close();
		return sum;
		
	}

}
