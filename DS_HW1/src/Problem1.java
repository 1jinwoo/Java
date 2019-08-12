/* Problem1.java - fill in the main method as directed. */

/* Replace this comment with your name, uni and anything 
 * you need us to know about the program */

public class Problem1 {
  
  public static <AnyType extends Comparable<AnyType>>  AnyType findMax(AnyType[] arr) {
    int maxIndex = 0;
    for (int i = 1; i < arr.length; i++)
      if ( arr[i].compareTo(arr[maxIndex]) > 0 )
         maxIndex = i;
      return arr[maxIndex];
  }
  
  
  public static final void main(String[] args) {
	  Rectangle rec1 = new Rectangle(1, 1);
	  Rectangle rec2 = new Rectangle(1, 2);
	  Rectangle rec3 = new Rectangle(2, 1);
	  Rectangle rec4 = new Rectangle(2, 2);
	  Rectangle rec5 = new Rectangle(1, 3);
	  Rectangle rec6 = new Rectangle(5, 100);
	  
	  Rectangle[] arr = {rec1, rec2, rec3, rec4, rec5, rec6};
	  
	  System.out.println(findMax(arr));
  }
  
 
}



