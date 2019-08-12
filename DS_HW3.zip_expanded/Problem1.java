/* Following the specification in the README.md file, provide your 
 * Problem1 class.
 */

public class Problem1 {
	
	public static void main(String[] args) throws Exception {
		ExpressionTree t1 = new ExpressionTree("34 2 - 5 *");
		ExpressionTree t2 = new ExpressionTree("1 3 + 4 * 4 /");
		ExpressionTree t3 = new ExpressionTree("150 75 - 5 - 10 - 100 - 1 -");
		ExpressionTree t4 = new ExpressionTree("1 1 + 1 + 1 + 1 + 1 +");
		
		System.out.println("Result for t1: " + t1.eval());
		System.out.println(t1.postfix());
		System.out.println(t1.prefix());
		System.out.println(t1.infix());
		
		System.out.println("Result for t2: " + t2.eval());
		System.out.println(t2.postfix());
		System.out.println(t2.prefix());
		System.out.println(t2.infix());
		
		System.out.println("Result for t3: " + t3.eval());
		System.out.println(t3.postfix());
		System.out.println(t3.prefix());
		System.out.println(t3.infix());
		
		System.out.println("Result for t4: " + t4.eval());
		System.out.println(t4.postfix());
		System.out.println(t4.prefix());
		System.out.println(t4.infix());
				
	}
}