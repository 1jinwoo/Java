
public class SquareSum {

	public static void main(String[] args) {
				
		for (int i = 1; i <= 10; i++)	{
			System.out.println("(" + i + ") = " + squareSum(i));
		}
		System.out.println();
	}
	
	public static int squareSum(int size)	{
		
		int[] arr = new int[size];
		int sum = 0;	// will contain the summation result
		
		for (int n = 0; n < arr.length; n++) {
			arr[n] = n*n;
			sum += arr[n];
		}
		return sum;
		
	}

}
