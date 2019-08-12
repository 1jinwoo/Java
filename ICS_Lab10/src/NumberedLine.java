import java.io.*;

public class NumberedLine {

	public static void main(String[] args) throws IOException {
		
		// TODO open a file by creating streams
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		// TODO read a file line-by-line
		// with line numbers printed!
		int counter = 0;
		String str;
		while ((str = br.readLine()) != null) {
			counter++;
			System.out.println(counter + ": " + str);
		}
		// TODO be sure to close a file stream!
		br.close();
	}

}
