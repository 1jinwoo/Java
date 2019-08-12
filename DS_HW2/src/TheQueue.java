
public class TheQueue<T> implements MyQueue<T> {
	
	private T[] theArray;
	private int theSize;
	private int front;
	private int back;
	
	public TheQueue() {
		theArray = (T[]) new Object[10];
		theSize = 0;
		front = -1;
		back = -1;
	}
	
	@Override
	public void enqueue(T x) {
		theArray[++front%theSize] = x;
	}

	@Override
	public T dequeue() {
		
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
