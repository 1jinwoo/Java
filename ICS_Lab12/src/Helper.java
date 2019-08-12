

public class Helper {
	public static void print1DArray(int[] arr)	{
		print1DArray(arr, true);
	}
	
	public static void print1DArray(int[] arr, boolean newLine)	{
		System.out.print("[");
		for (int i = 0; i < arr.length; i++)	{
			if (i > 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.print("]");
		
		if (newLine)
			System.out.println();
	}
}
