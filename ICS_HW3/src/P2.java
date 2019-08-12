

public class P2 {

	public static void main(String[] args) {
		System.out.println(findGCD(2, 3));	// => 1
		System.out.println(findGCD(2, 10));	// => 2
		System.out.println(findGCD(14, 245));	// => 7
	}
	public static int findGCD(int i, int j)	{
		if(i == j) {
			return i;
		} else if (i == 0) {
			return j;
		} else if (j == 0) {
			return i;
		} else if (i > j) {
			return findGCD(i%j, j);
		} else {
			return findGCD(i, j%i);
		}
	}
}