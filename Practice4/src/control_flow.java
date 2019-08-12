
public class control_flow {

	public static void main(String[] args) {
		int a = 1;
		int result = 1;
		while (a <= 4) {
			result = result*a;
			a++;
		}
		System.out.println(result);
		System.out.println(factorial(10));

	}
	public static int factorial (int n) {
		int i = 1;
		int result = 1;
		while (i <= n) {
			result = result*i;
			i = i + 1;
		}
		return result;
	}
	

}
