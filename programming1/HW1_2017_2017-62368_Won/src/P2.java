
public class P2 {

	public static void main(String[] args) {
		System.out.println(roundNumber(4.49));	// => 4
		System.out.println(roundNumber(4.5));	// => 5
		System.out.println(roundNumber(4.51));	// => 5
		System.out.println(roundNumber(-1.51));	// => -2
		System.out.println(roundNumber(-1.5));	// => -1
		System.out.println(roundNumber(-1.49));	// => -1
	}
	
	public static double roundNumber(double val)	{
		// NOTE you should not use methods Math.ceil(), Math.floor(), Math.round()
		// HINT use '%' to extract fractional part from the number 'val'
		double result = 0;
		double decimal = val%1;
		double whole = val - decimal;
		if ((val > 0) && (decimal < 0.5)) {
			result = whole;
		} else if ((val > 0) && (decimal >= 0.5)){
			result = whole + 1;
		} else if ((val < 0) && (decimal >= -0.5)) {
			result = whole;
		} else if ((val < 0) && (decimal < -0.5)) {
			result = whole - 1;
		}
		return result;
	}

}
