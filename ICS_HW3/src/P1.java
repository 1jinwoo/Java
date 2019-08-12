

public class P1 {

	public static void main(String[] args) {
		printArrow(5);
	}
	/*   #-#-#-#-#
	 * 	 #-#-#-#
	 * and so on
	 */
	public static void printArrow(int l)	{
		// TODO print a line using iteration statement
		for (int i = 0; i < l - 1; i++) {
			System.out.print("#-");
		}
		System.out.println("#");
		// TODO if needed, call itself to print remaining lines
		if (l > 1)
			printArrow(l - 1);
	}

}
