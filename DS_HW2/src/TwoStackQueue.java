/* Following the specification in the README.md file, provide your 
 * TwoStackQueue class.
 */

public class TwoStackQueue<AnyType> implements MyQueue<AnyType> {
	private MyStack<AnyType> S1; // enqueue stack
	private MyStack<AnyType> S2; // dequeue stack
	private int theSize;
	
	public TwoStackQueue() {
		S1 = new MyStack<AnyType>();
		S2 = new MyStack<AnyType>();
		theSize = 0;
	}
	
    public void enqueue(AnyType x) {
    	S1.push(x);
    	theSize++;
    }

    // Performs the dequeue operation. For this assignment, if you
    // attempt to dequeue an already empty queue, you should return
    // null
    public AnyType dequeue() {
		if (theSize <= 0) {
			return null;
		} else {
			theSize--;
			if (S2.size() == 0) {
				while (!S1.isEmpty()) {
					S2.push(S1.pop());
				}
			}
			return S2.pop();
		}
	}

    public boolean isEmpty() {
    	return theSize == 0;
    }

    // Returns the number of elements currently in the queue
    public int size() {
    	return theSize;
    }
}