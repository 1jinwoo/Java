
public class EratosSieve {

	public static void main(String[] args) {
		System.out.println("Primes found: " + EratosSieve(10));
		// there is 4 primes: 2 3 5 7
		
		// for larger case; algorithm used in this class is too primitive!
		// System.out.println("#Primes found: " + EratosSieve(1000));
	}
	
	/**
	 * find prime numbers <= bound, print them, return the number of found numbers
	 * 
	 * @param bound the search range
	 * @return the number of found prime numbers <= bound
	 */
	public static int EratosSieve(int bound)	{
		
		// NOTE use the fact that Java int array is initialized with value 0
		// for convenience, set length "+1" because array index starts from 0
		int[] sieve = new int[bound + 1];
		// NOTE boolean array could be a better choice 
		// - because we don't have to count how much each composite number marked
		
		// for each number; NOTE 1 is not a prime
		for (int i = 2; i <= bound; i++)	{
			sieve[i] = i;
			//need to remove multiple of 2, 3, 4, ... one before bound 
			// if marked as not a prime, skip below and "continue" to the next number!
			if (sieve[i] == 0) //0 is marker for non-prime numbers
				continue;	// keyword for skip remaining block, then move to next iteration
			
			// TODO for each multiple of current prime, mark as not a prime (or composite number)
			
			
			
		}
		
		int count = 0;
		System.out.println("Found primes are:");
		for (int i = 2; i <= bound; i++)	{
			// TODO if not a prime, continue to the next number			

			
			
			// TODO print a prime, count #primes found
			
			
			
		}
		System.out.println();
		
		return count;
		
	}
	
}
