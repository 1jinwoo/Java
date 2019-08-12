
public class P1 {

	public static void main(String[] args) {
		System.out.println(factorial(3));	// => 6
		System.out.println(factorial(5));	// => 120
	}
	
	public static int factorial(int n)	{
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		
		return result;
		
	}
	
}
