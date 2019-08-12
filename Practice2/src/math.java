
public class math {
	public static void main (String[] args) {
		solveQuad(4, 5, 1);
		solveQuad(1, -12, 32);
	}
	public static String solveQuad (double a, double b, double c) { //quadratic roots method
		double answer1 = (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
		double answer2 = (-b - Math.sqrt(b*b - 4*a*c)) / (2*a);
		String answers = answer1 + ", " + answer2;
		System.out.println("Answers: " + answer1 + ", " + answer2);
		return answers;
	}
}
