
public class DirectionSum {

	public static void main(String[] args) {
		
		int[][] myArray = { {1, 2, 3}, {2, 4, 6}, {3, 6, 9}, {4, 8, 12} };
		
		Helper.print1DArray(rowSum(myArray));	// => [6, 12, 18, 24]
		
		Helper.print1DArray(colSum(myArray));	// => [10, 20, 30]
		
	}
	
	public static int[] rowSum(int[][] arr)	{
		
		int[] result = new int[arr.length];
		
		// TODO write down your code
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				result[i] = result[i] + arr[i][j];
			}
		}
		
		return result;
		
	}
	
	public static int[] colSum(int[][] arr)	{
		
		int[] result = new int[arr[0].length];
		
		// TODO write down your code
		for(int j = 0; j < arr[0].length; j++) {
			for(int i = 0; i < arr.length; i++) {
				result[j] = result[j] + arr[i][j];
			}
		}
		
		return result;
		
	}

}
