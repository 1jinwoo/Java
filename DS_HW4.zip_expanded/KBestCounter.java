import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int k) {
        heap = new PriorityQueue<>();
        this.k = k;
    }

    /**
     * @param x
     * keeps only k elements in the heap at one time
     */
    public void count(T x) {
       	if (heap.size() < k) {
       		heap.add(x);
       	} else if (x.compareTo(heap.peek()) > 0) {
       		heap.poll();
       		heap.add(x);
       	}
    }

    /**
     * @return list of k-largest elements
     * Runs in O(NlogN).
     * Restores the heap to original.
     */
    public List<T> kbest() {
    	LinkedList<T> temp = new LinkedList<>(); // used as a stack
    	LinkedList<T> result = new LinkedList<>();
    	
    	while(!heap.isEmpty()) {
    		temp.offer(heap.poll());
    	}
    	
    	while(!temp.isEmpty()) {
    		T holder = temp.poll();
    		result.addFirst(holder);
    		heap.add(holder);
    	}
    	
    	return result;
    }

}
