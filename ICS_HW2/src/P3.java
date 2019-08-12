
public class P3 {

	public static void main(String[] args) {
		System.out.println(ruleCount(1));	// => 0
		System.out.println(ruleCount(2));	// => 1
		System.out.println(ruleCount(15));	// => 17, because
		// 15 -> 46 -> 23 -> 70 -> 35 -> 106 -> 53 -> 160 -> 80 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
	}
	// odd: 3*value + 1
	// even: value/2
	public static int ruleCount(int value)	{
		int count = 0;
		while (value != 1) {
			if(value%2 == 0) {
				value = value / 2;
				count++;
			} else {
				value = 3 * value + 1;
				count++;
			}
		}
		
		return count;
		
	}
	
}
