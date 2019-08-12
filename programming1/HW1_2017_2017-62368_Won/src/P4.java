
public class P4 {

	public static void main(String[] args) {
		System.out.println(getRatioEmployee(2, 25));	// => 18
		System.out.println(getRatioEmployee(1, 33));	// => 30
	}
	
	/**
	 * return a (integer) %ratio of employees in specific range
	 * 
	 * @param a gender; 1 for man, 2 for woman
	 * @param b age
	 * @return %ratio of employees in specified range
	 */
	/* age       man       woman
	 * 25-29     32        36
	 * 30-34     60        42
	 * 35-40     20        10
	 */    
	public static int getRatioEmployee(int a, int b)	{
		//if block for men
		int result = 0;
		if (a == 1) {
			if ((b >= 25) && (b <= 29)) {
				result = 16;
			} else if ((b >= 30) && (b <= 34)) {
				result = 30;
			} else if ((b >= 35) && (b <= 40)) {
				result = 10;
			}
		} else if (a == 2) { //if block for women
			if ((b >= 25) && (b <= 29)) {
				result = 18;
			} else if ((b >= 30) && (b <= 34)) {
				result = 21;
			} else if ((b >= 35) && (b <= 40)) {
				result = 5;
			}
		} 
		return result;
	}

}
