

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
		for (int i = 0;i < data.length; i++)	{
			for (int j = 0; j < data[0].length - arr.length + 1; j++)	{
				
				// TODO use another 'for statement' to compare characters 
				// of target word (in 'arr') and array characters in row
				boolean found = true;
				
				for (int k = 0; k < arr.length; k++)	{
					if (arr[k] != data[i][j+k])	{
						found = false;
						break;
					}
				}
				
				if (found)	{
					System.out.println("Found in (" + i + ", " + j + ")!");
					
					coord[0] = i;
					coord[1] = j;
					return coord;
				}
				
			}
		}
		
		System.out.println("Not Found!");
		return coord;
		
	}
	
	public int[] findWordHorizontalAlternative(String word)	{
		
		// NOTE if we extract matching characters part into "match()" method,
		
		word = word.toUpperCase();	// convert to uppercase; just in case
		char[] arr = word.toCharArray();
		
		int[] coord = new int[2];
		
		// TODO find this word in horizontal direction!
		for (int i = 0;i < data.length; i++)	{
			for (int j = 0; j < data[0].length; j++)	{	// NOTE upper limit of column index was moved to method match()
				
				// if characters from start point are desired word,
				if (match(i, j, arr))	{
					System.out.println("Found in (" + i + ", " + j + ")!");
					
					coord[0] = i;
					coord[1] = j;
					return coord;
				}
				
			}
		}
		
		System.out.println("Not Found!");
		return coord;
		
	}
	
	public boolean match(int i, int j, char[] arr)	{
		boolean found = true;
		
		// boundary condition
		if ((j + arr.length) > data[i].length)	{
			// if last character is placed out of word puzzle bound,
			return false;
		}
		
		// TODO use another 'for statement' to compare characters 
		// of target word (in 'arr') and array characters in row
		for (int k = 0; k < arr.length; k++)	{
			if (arr[k] != data[i][j+k])	{
				found = false;
				break;
			}
		}
		
		return found;
	}

}
