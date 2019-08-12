import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Middle {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		for(int i = 0; i < 101; i ++) {
			list.add( new Integer(i).toString());
		}
		System.out.println(list);
		System.out.println("the index of the middle element is: " + middle(list));
		
	}
	
	public static float middle(LinkedList<String> list) {
		float middleIndex = 0;
		Iterator<String> slowIterator = list.iterator();
		Iterator<String> fastIterator = list.iterator();
		try {
			while(fastIterator.hasNext()) {
				slowIterator.next();
				fastIterator.next();
				fastIterator.next();
				middleIndex++;
			}
		} catch (NoSuchElementException e) {
			middleIndex += 0.5;
		}
		return middleIndex;
	}
}
