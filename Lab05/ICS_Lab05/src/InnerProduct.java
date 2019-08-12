import java.util.Random;

public class InnerProduct {
	
	public static int innerProduct(int[] a, int[] b)	{
		
		// use arrays a, b in parameters to compute
		
		int result = 0;
		// TODO do compute inner product
		for (int i = 0; i < a.length; i++) {
			result += a[i] * b[i];
		}
		
		// TODO return the result rather than 0
		return result;
	}

	public static void main(String[] args) {
		
		// == for fixed arrays ==
		int[] a = {1, 2, 3};
		int[] b = {2, 3, 4};
		
		// print input arrays
		System.out.print("For simple case, A=");
		print1DArray(a);
		System.out.print(", B=");
		print1DArray(b);
		System.out.println();
		
		// call then print a result
		System.out.println("A ¡¤ B = " + innerProduct(a, b));
		
		// == for random arrays case ==
		int size = 3;
		int[] x = new int[size];
		int[] y = new int[size];
		
		// *DON'T HAVE TO KNOW!
		// randomly generate the arrays
		Random random = new Random();
		for (int i = 0; i < size; i++)	{
			x[i] = random.nextInt(10) + 1;
			y[i] = random.nextInt(10) + 1;
		}
		
		// show arrays
		System.out.print("For random case, X=");
		print1DArray(x);
		System.out.print(", Y=");
		print1DArray(y);
		System.out.println();
		
		// print result
		System.out.println("X ¡¤ Y = " + innerProduct(x, y));
	}
	
	public static void print1DArray(int[] arr)	{
		System.out.print("[");
		for (int i = 0; i < arr.length; i++)	{
			if (i > 0)
				System.out.print(", ");
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	
}
