import java.util.Iterator;
import java.util.LinkedList;

/* Following the specification in the README.md file, provide your 
 * MyStack class.
 */

/**
 * @author Jin Woo Won
 *
 */
public class MyStack<AnyType> {
	private LinkedList<AnyType> list;
	
	
	public MyStack() {
		list = new LinkedList<AnyType>();
	}
	
	public void push(AnyType x) {
		list.addFirst(x);
	}
	
	public AnyType pop() {
		return list.removeFirst();
	}
	
	public AnyType peek() {
		return list.getFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
}
