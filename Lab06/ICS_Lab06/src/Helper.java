import java.util.Random;

public class Helper {

	public static void print1DArray(int[] arr)	{
		print1DArray(arr, false);
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
			printNewline();
	}
	
	public static void printNewline()	{
		System.out.println();
	}
	
	public static int[] getRandomArray(int size, int range)   {
        int[] x = new int[size];
        
        // randomly generate the arrays
        Random random = new Random();
        for (int i = 0; i < size; i++)  {
            x[i] = random.nextInt(range) + 1;
        }
        
        return x;
	}
}
