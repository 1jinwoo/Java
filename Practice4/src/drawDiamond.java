
public class drawDiamond {
	public static void main(String[] args) {
		drawDiamond(10);

	}
	/*draw Diamond should create for input of 10:
	 * " "-*
	 *  9-1
	 *  8-3
	 *  7-5
	 *  6-7
	 *  5-9
	 *  4-11
	 *  3-13
	 *  2-15
	 *  1-17
	 *  0-19
	 *  1-17
	 *  2-15
	 *  3-13
	 *  4-11
	 *  5-9
	 *  6-7
	 *  7-5
	 *  8-3
	 *  9-1
	 */ 
	public static void drawDiamond (int size) {
		//top part
		for (int i = 1; i < size; i++) {
			for (int a = size; i < a ; a--) {
				System.out.print(" ");
			}
			for (int b = 1; b < (i*2); b++) {
			System.out.print("*");
			}
			System.out.print("\n");
		
		}
		//the line of 19 stars
		for (int c = 2; c <= size*2; c++) {
			System.out.print("*");
		}
		System.out.println("");
		//bottom part
		for (int n = 0; n < size; n++) {
			for (int d = -1; d < n ; d++) {
				System.out.print(" ");
			}
			for (int e = size; n < e; e--) {
				System.out.print("*");
				System.out.print("*");
			}
			System.out.print("\n");
		
		}
	}

}

/*better way to program this:
 *program a method that takes two parameters (number of blanks, number of stars)
 *have the size be converted appropriately to the two parameters that go into the above method to produce correct diamond 
*/