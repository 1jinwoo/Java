
public class P4 {

	public static void main(String[] args) {
		int[] q1 = {5};
		double[] p1 = {100.0};
		
		System.out.println(totalPrice(q1, p1));	// => 500.0
		
		int[] q2 = {1, 2, 4};
		double[] p2 = {100.0, 30.0, 2.0};
		
		System.out.println(totalPrice(q2, p2));	// => 168.0
		
		int[] q3 = {21};
		double[] p3 = {100.0};
		
		System.out.println(totalPrice(q3, p3));	// => 1680.0 (not 2100.0, because 20% discount)
		
		int[] q4 = {1, 20, 21};
		double[] p4 = {100.0, 30.0, 2.0};	// => 733.6 (=1 * 100.0 + 20 * 30.0 + 21 * 2.0 * (1 - 0.8))
		
		System.out.println(totalPrice(q4, p4));
		
		int[] q5 = {1, 2, 21};
		double[] p5 = {10.0, 7.0, 1.0};
		
		System.out.println(totalPrice(q5, p5));	// => 40.8
		
		int[] q6 = {3, 1, 2};
		double[] p6 = {5.0, 7.0, 3.0};
		
		System.out.println(totalPrice(q6, p6));	// => 28.0
	}
	//computer total price by multiplying price and quantity (discount the price by 20% if more than 20)
	public static double totalPrice(int[] quantity, double[] price)	{
		// NOTE assume the sizes of two arrays (quantity, price) are equal
		double total = 0;
		if (quantity.length != price.length)	{
			System.out.println("Sizes of two arrays are different!");
			return -1;
		} else {
			for (int i = 0; i < quantity.length; i++) {
				if (quantity[i] > 20) {
					price[i] = price[i] * 0.8;
				}
				total = total + price[i] * quantity[i];
				}
			}
		
		
		
		return total;
		
	}
	
}
