import java.util.Arrays;

/* Following the specification in the README.md file, provide your 
 * Problem2.java class.
 */

public class Problem2{
    public static final void main(String[]args){
      // hard-coded rectangle objects
	  Rectangle rec1 = new Rectangle(1, 1);
	  Rectangle rec2 = new Rectangle(1, 3);
	  Rectangle rec3 = new Rectangle(2, 1);
	  Rectangle rec4 = new Rectangle(2, 2);
	  Rectangle rec5 = new Rectangle(1, 3);
	  Rectangle rec6 = new Rectangle(5, 7);
	  Rectangle rec7 = new Rectangle(5, 100);
	  
      // rectangle arrays for testing
	  Rectangle[] arr1 = {rec1, rec2, rec3, rec4, rec5, rec6};
	  Rectangle[] arr2 = {rec1, rec2, rec3, rec4, rec5};
      Rectangle[] arr3 = {rec1, rec2, rec3, rec4};
      Rectangle[] arr4 = {rec1, rec2, rec3};
      Rectangle[] arr5 = {rec1, rec2};
      Rectangle[] arr6 = {rec1};
      
      Arrays.sort(arr1);
      System.out.println(binarySearch(arr1, rec2));
    }
    
    public static <AnyType extends Comparable<AnyType>>       
     int binarySearch(AnyType[] a, AnyType x){
        return binarySearch(a, x, 0, a.length - 1);
    }
    
    public static <AnyType extends Comparable<AnyType>>
     int binarySearch(AnyType[] a, AnyType x, int start, int stop){
        if (start <= stop) {
        	int mid = start + (stop - start) / 2;
        	if (a[mid].compareTo(x) == 0) {
        		return mid;
        	} else if (a[mid].compareTo(x) == -1) {
        		return binarySearch(a, x, mid + 1, stop);
        	} else {
                return binarySearch(a, x, start, mid - 1);
        	}
        } else {
        	System.out.println("x = " + x + " start = " + start + " stop = " + stop);
        	return -1;
        }
    }

    
}