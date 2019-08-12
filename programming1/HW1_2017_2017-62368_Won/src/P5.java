
public class P5 {

	public static void main(String[] args) {
		
		// resultant value will be 1, 2, 4, 7, 11, 16
		System.out.println(pSum(1));
		System.out.println(pSum(2));
		System.out.println(pSum(3));
		System.out.println(pSum(4));
		System.out.println(pSum(5));
		System.out.println(pSum(6));
	}
	
	public static int pSum(int n)	{
		int result = 0;
		for (int i = 1; i < n; i++) {
			result += i;
		}
		result++;
		return result;
	}

}
