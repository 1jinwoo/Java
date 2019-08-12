
public class P1 {

	public static void main(String[] args) {
		System.out.println(negAbs(2, 3));	// has to return 1
		System.out.println(negAbs(10, 5));	// has to return 5
	}
	
	public static int negAbs(int x, int y)	{
		// NOTE you can use Math.abs()
		int result = 0;
		result = Math.abs(x - y);
		return result;
	}
	
}
