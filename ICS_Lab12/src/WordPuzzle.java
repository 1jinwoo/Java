

public class WordPuzzle {

	public static void main(String[] args) {
		
		WordPuzzle wp = new WordPuzzle();
		
		int[] coord;
		
		String[] horizontalWords = { "WORD", "ARK", "OAT", "HOME", "TRIPLE" };
		for (int i = 0; i < horizontalWords.length; i++)	{
			System.out.println("Word: " + horizontalWords[i]);
			
			coord = wp.findWordHorizontal(horizontalWords[i]);
			Helper.print1DArray(coord);
			
			System.out.println();
		}
		
		// test by yourself!
		String word = "or";
		System.out.println("Word: " + word + ", is it exist in horizontal?");
		
		System.out.println(": Horizontal");
		
		coord = wp.findWordHorizontal(word);
		Helper.print1DArray(coord);
		
		System.out.println();
		
	}
	
	char[][] data;
	
	public WordPuzzle()	{
		/* 
         * HORIZONTAL
			ARK, OAT, HOME, WORD, TRIPLE
		 * VERTICAL (but won't find today)
			ALI, WAY, CROW, PERK, EAST
		 */
		char[][] data = { 
				{'L', 'C', 'O', 'I', 'A', 'R'}, 
				{'T', 'R', 'I', 'P', 'L', 'E'}, 
				{'H', 'O', 'M', 'E', 'I', 'A'}, 
				{'Y', 'W', 'O', 'R', 'D', 'S'}, 
				{'C', 'A', 'R', 'K', 'O', 'T'}, 
				{'E', 'Y', 'C', 'O', 'A', 'T'} };
		this.data = data;
	}
	
	public int[] findWordHorizontal(String word)	{
		
		word = word.toUpperCase();	// convert to uppercase; just in case
		char[] arr = word.toCharArray();
		
		int[] coord = new int[2];
		
		// TODO find this word in horizontal direction!
		for (int r = 0; r < data.length; r++)	{
			for (int c = 0; c < data[0].length; c++)	{
				// TODO use another 'for statement' to compare characters 
				// of target word (in 'arr') and array characters in row
				for(int a = 0; a < arr.length;a++) {
					if(arr[a] == )
				}
				
			}
		}
		
		System.out.println("Not Found!");
		return coord;
		
	}

}
