
public class P2 {

	public static void main(String[] args) {
		System.out.println(fibonacci(3));	// => 2
		System.out.println(fibonacci(5));	// => 5
		System.out.println();
		
		for (int i = 1; i <= 10; i++)
			System.out.println("(" + i + ") = " + fibonacci(i));
		// [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ¡¦]
	}
	
	public static int fibonacci(int n)	{
		int result = 0;
		int a = 1;
		int b = 1;
		if (n <= 2) {
			result = 1;
		} else {
			for (int i = 2; i < n; i++) {
				result = a + b;
				a = b;
				b = result;
			}
		}
		/*int [] series = new int[n];
		series[0] = 1;
		series[1] = 1;
		for (int i = 2; i <= n; i++) {
			series[i] = series[i-2] + series[i-1];
		}
		result = series[n];
		*/
		return result;
		
	}
}
