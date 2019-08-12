
public class Example {

	public static void main(String[] args) {
		// repeatMe();	// DO NOT execute this!
		
		System.out.println(sumOf(10));
		System.out.println();
		
		System.out.println(sumOfIter(10));	// same as above
		System.out.println();
		
		System.out.println(factorial(10));
		System.out.println();
		
		System.out.println(factorialExplained(10));
		System.out.println();
		
	}
	
	public static void repeatMe()	{
		// ...
		
		repeatMe();
		
	}
	
	public static int sumOf(int n)	{
		if (n <= 1)	{
			return 1;
		}
		return n + sumOf(n - 1); 
	}
	
	public static int sumOfIter(int n)	{
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}
	
	public static int factorial(int n)	{
		if (n <= 1)
			return 1;
		
		return n * factorial(n - 1);
	}
	
	public static int factorialExplained(int n)	{
		// same as slide version
		System.out.println("factorial(" + n + ") start!");
		
		int f;
		if (n == 1)	f = 1;
		else f = n * factorialExplained(n - 1);
		
		System.out.println("factorial(" + n + ") end!");
		
		return f;
	}

}
