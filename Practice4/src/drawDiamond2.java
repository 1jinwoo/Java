
public class drawDiamond2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void drawForm (int size) {
		int p1, p2;
		p1 = size;
		p2 = size;
		int a, b;
		a = -1;
		b = 1;
		for (a = 0; a < size*2 - 1; a++) {
			drawStars(p1, p2);
			if (p1 == 1) {
				a = 1;
				b = -1;
			}
			p1 += a;
			p2 += b;
		}
	}
	public static void drawStars (int pos1, int pos2) {
		for (int i = 0; i <= pos2; i++) {
			if (i == pos1 || i == pos2) {
				System.out.println("*");
			} else {
				System.out.println(" ");
			}
		}
		System.out.println();
	}
}
