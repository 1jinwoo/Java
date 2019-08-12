
public class Example {

	public static void main(String[] args) {
		
		// p. 8
		int[] myArray1 = new int[4];
		System.out.println("If you directly print 'myArray1'...");
		System.out.println(myArray1);
		// *DON'T HAVE TO KNOW! this prints "default object description" text
		// that is, type of a variable ([I : integer typed array), "hashed" internal address
		System.out.println();
		
		// p. 12
		int[] myArray2 = new int[4];	// integer array with 4 elements
		myArray2[0] = 4;
		myArray2[1] = 1;
		myArray2[2] = 3;
		myArray2[3] = 5;
		
		// pp. 12-13
		int[] myArray3 = {4, 1, 3, 5};	// initialize by an element list
		System.out.println("The elements of myArray3 is...");
		for (int i = 0; i < myArray3.length; i++)	{
			System.out.print(myArray3[i] + " ");
		}
		System.out.println("\n");
		
		// NOTE the size of array can be determined from an integer variable!
		int size = 10;
		int[] myArray4 = new int[size];
		System.out.println("size=" + size + ", Length of myArray4=" + myArray4.length);
		
	}

}
