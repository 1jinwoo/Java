
public class Bubble {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 4, 5 };

		System.out.println("Before sort:");
		Helper.print1DArray(arr1);
		Helper.printNewline();

		bubble(arr1);

		System.out.println("After sort:");
		Helper.print1DArray(arr1);
		Helper.printNewline();
		Helper.printNewline();

		int[] arr2 = { 3, 1, 7, 5, 2 };

		System.out.println("Before sort:");
		Helper.print1DArray(arr2);
		Helper.printNewline();

		bubble(arr2);

		System.out.println("After sort:");
		Helper.print1DArray(arr2);
		Helper.printNewline();
		Helper.printNewline();

		// random case
		int[] arr_random = Helper.getRandomArray(10, 10);

		System.out.println("Before sort:");
		Helper.print1DArray(arr_random);
		Helper.printNewline();

		bubble(arr_random);

		System.out.println("After sort:");
		Helper.print1DArray(arr_random);
		Helper.printNewline();
		Helper.printNewline();
	}

	public static void bubble(int[] arr) {
		for (int a = 0; a < arr.length; a++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i+1]) {
					swap(arr, i, i+1);
				}
			}
		}

	}

	/**
	 * change positions of two elements (i, j) in an array "arr" 
	 */
	public static void swap(int []arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
