/* Following the specification in the README.md file, provide your 
 * Problem2 class.
 */

public class Problem2 {
    /** If implemented correctly, this code should output: 
     *  0
     *  99
     *  1
     *  98
     *  2
     *  3
     *  .
     *  .
     *  .
     *  98
     *  99
     *  true
     *  null
     *  null
     */
    public static final void main(String[] args) {

		TwoStackQueue<String> q = new TwoStackQueue<String>();
		System.out.println(q.size());

		for (int i = 1; i < 100; i++) {
			q.enqueue(String.valueOf(i));
		}
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.size());
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
