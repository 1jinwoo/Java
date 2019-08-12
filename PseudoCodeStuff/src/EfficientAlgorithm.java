
public class EfficientAlgorithm {

	private static int[] A = {1, 4, 5, 7, 11, 14, 16}; // sorted
	
	int i = 4;
	
	/**
	 * use the fact that the array is sorted
	 * @param A
	 * @return
	 */
	public static boolean binarySearch(int [] arr, int x) {
		int start;
		int stop;
		start = 0;
		stop = arr.length - 1;
		int mid;
		while(start <= stop) {
			mid = (start + stop) / 2;
			if(arr[mid] > x) {
				stop = mid - 1;
			} else if(arr[mid] < x) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		System.out.println(binarySearch(A, 10));
	}
}
