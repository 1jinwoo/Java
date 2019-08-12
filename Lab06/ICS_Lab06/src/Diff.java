
public class Diff {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		System.out.println(diffMaxMin(arr1));	// prints 4 (= 5 - 1)
		
		int[] arr2 = {3, 1, 6, 2, 8, 2, 5};
		System.out.println(diffMaxMin(arr2));	// prints 7 (= 8 - 1)
		
		int[] arr_random = Helper.getRandomArray(10, 10);
		System.out.println("\nFor random array:");
		Helper.print1DArray(arr_random);
		System.out.println();
		System.out.println(diffMaxMin(arr_random));
	}
	
	public static int diffMaxMin(int[] arr)	{
		int result = 0;
		int max = 0, min = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		min = max;
		for (int a = 0; a < arr.length; a++) {	
			if (arr[a] < min) {
				min = arr[a];
			}
		}
		result = max - min;
		return result;
		
	}
}
