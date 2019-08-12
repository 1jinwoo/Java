
public class Example {

	public static void main(String[] args) {
		testArray();
	}
	
	public static void testArray()	{
		int[][] myArray = { {1, 2, 3}, {2, 4, 6}, {3, 6, 9}, {4, 8, 12} };
		
		for (int i = 0; i < myArray.length; i++)	{
			for (int j = 0; j < myArray[0].length; j++)	{
				System.out.print(myArray[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
