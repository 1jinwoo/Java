
import java.io.*;

public class P5 {

	public static void main(String[] args) throws IOException {
		String filename;
		int[] result;
		
		filename = "input/p5_e1.txt";
		int[] criteria = {20, 10, 5, 0};
		result = countBy(filename, criteria);
		Helper.print1DArray(result);	// => [3, 0, 5, 2]; refer to the data file
		
		filename = "input/p5_e2.txt";
		int[] criteria2 = {40, 20, 10, 5, 0};
		result = countBy(filename, criteria2);
		Helper.print1DArray(result);	// => [5, 2, 1, 7, 5]; refer to the data file
	}
	
	public static int[] countBy(String filename, int[] criteria) throws IOException	{
		
		int[] result = new int[criteria.length];
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		
		
		String str = br.readLine();
		int entries = Integer.parseInt(str);
		
		for (int i = 0; i < entries; i++) {
			String s = br.readLine();
			int conv = Integer.parseInt(s);
			for(int a = 0; a < criteria.length; a++) {
				if(conv >= criteria[a]) {
					result[a]++;
					break;
				}
			}
		}

		br.close();
		return result;
		
	}

}
