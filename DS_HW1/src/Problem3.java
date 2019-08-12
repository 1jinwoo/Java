/* Following the specification in the README.md file, provide your 
 * Problem3.java class.
 */


public class Problem3 {

	public static int fragment1 (int n) {
		int sum = 0;
		for ( int i = 0; i < 23; i ++)
		    for ( int j = 0; j < n ; j ++)
		        sum = sum + 1;
		return sum;
	}
	
	public static int fragment2 (int n) {
		int sum = 0;
		for ( int i = 0; i < n ; i ++)
		    for ( int k = i ; k < n ; k ++)
		        sum = sum + 1;
		return sum;
	}
	
	public static int foo(int n, int k) {
	    if(n<=k){
	        return 1;
        }
	    else {
	        return foo(n/k,k) + 1;
        }
	}
	
	
	/**
	 * @param args
	 * Tested n's are 
	 */
	public static void main(String[] args) {
        
        int[] ns = {100, 1000, 5000, 10000};
        
        for(int n : ns){
            long startTime = System.nanoTime();
            fragment1(n);
            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            System.out.println("N = " + n + " time = " + elapsed);
        }
        
        for(int n : ns){
            long startTime = System.nanoTime();
            fragment2(n);
            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            System.out.println("N = " + n + " time = " + elapsed);
        }
        
        long sTime = System.nanoTime();
        foo(100, 2);
        long eTime = System.nanoTime();
        System.out.println(eTime - sTime);
        for(int n : ns){
            long startTime = System.nanoTime();
            foo(n, 2);
            long endTime = System.nanoTime();
            long elapsed = endTime - startTime;
            System.out.println("N = " + n + " time = " + elapsed);
        }
		
	}
}
