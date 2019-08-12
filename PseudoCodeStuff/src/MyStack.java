
public class MyStack<T> {
	
	private T[] arr;
	private int top;
	
	public MyStack() {
		arr = (T[]) new Object[10];
		top = -1;
	}
	
	public void push (T t) {
		top++;
		arr[top] = t;
	}
	
	public T pop () throws Exception {
		if (top < 0) {
			throw new Exception("StackUnderflow");
		}
		return arr[top--];
	}
	
	public T peek () {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public static void main (String[] args) throws Exception {
		MyStack<Integer> myStack = new MyStack<>();
		
		myStack.push(1);
		myStack.push(20);
		
		System.out.println(myStack.peek());
		System.out.println(myStack.peek());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
		
	}
}
