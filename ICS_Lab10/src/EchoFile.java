import java.io.*;

public class EchoFile {

	public static void main(String[] args) throws IOException {
		
		// create a file stream
		FileInputStream fi = new FileInputStream("input.txt");
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		
		// read for each line
		String line;
		while ((line = br.readLine()) != null)	{
			System.out.println(line);
		}
		
		// close after finishing a file read
		br.close();
	}

}
