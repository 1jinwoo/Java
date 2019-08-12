
public class Fibo {

	public static void main(String[] args) {
		
		Fibo f = new Fibo();
		
		for (int i = 1; i <= 10; i++)	{
			int res = f.fib(i);
			System.out.println("fib(" + i + ") = " + res);
		}
		// [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...]
		
		String a = "";
		a.toCharArray();
		
	}
	
	public int fib(int n)	{
		
		// TODO compute fibonacci series in recursion style
		// TODO base part
		int res = 0;
		if((n == 1) || (n == 2)) {
			res = 1;
		} else {
			res = fib(n - 2) + fib(n - 1);
		}
		// TODO recursive part
		// TODO delete below and write your code!
		return res;
		
	}

}
