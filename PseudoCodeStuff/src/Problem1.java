import java.util.Iterator;
import java.util.LinkedList;

public class Problem1 {
	
	public static LinkedList<Integer> L = new LinkedList<>();
	public static LinkedList<Integer> P = new LinkedList<>();
	
	public static void printLots(LinkedList<Integer> L, LinkedList<Integer> P) {
		Iterator<Integer> liter = L.iterator();
		Iterator<Integer> piter = P.iterator();
		
		int idxL = 0;
		int idxP = 0;
		int currentL = liter.next();
		int currentP = piter.next();
		
		
		while ((idxP < P.size()) || (idxL < L.size())) {
			
			if(currentP == idxL) {
				System.out.println(currentL);
				currentP = piter.next();
				idxP++;
			} else if ((currentP < 0) || (currentP >= L.size() - 1)) {
				System.out.println("No such index exists in L.");
				if(piter.hasNext()) {
					currentP = piter.next();
					idxP++;
				} else {
					break;
				}
			} else {
				currentL = liter.next();
				idxL++;
			}
		}
		System.out.println("The loop terminated");

	}
	
	
	public static void main(String[] args) {
		L.add(0); // 0
		L.add(10);
		L.add(20); // 2
		L.add(30); // 3
		L.add(40); // 4
		L.add(50);
		L.add(60); // 6
		L.add(70);
		System.out.println(L);
		P.add(-1);
		P.add(0);
		P.add(2);
		P.add(2);
		P.add(3);
		P.add(4);
		P.add(6);
		P.add(12);
		System.out.println(P);
		
		printLots(L, P);
	}
}
