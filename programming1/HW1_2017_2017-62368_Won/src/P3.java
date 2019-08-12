
public class P3 {

	public static void main(String[] args) {
		System.out.println(within8(7));		// => true 
		System.out.println(within8(13));	// => false
		System.out.println(within8(17));	// => true
	}
	
	public static boolean within8(int n)	{
		boolean result = false;
		int remainder = n%8;
		if ((remainder <= 2) || ((n >= 6) && (n <= 10) ) ) {
			result = true;
		} else {
			result = false;
		}
		return result;
		
	}

}
