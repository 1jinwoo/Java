
public class P5 {

	public static void main(String[] args) {
		int[] arr1 = {6, 1, 4};
		System.out.println(median(arr1));	// => 4
		
		int[] arr2 = {1, 2, 3, 4};
		System.out.println(median(arr2));	// => 2 (= floor((2+3)/2) )
		
		int[] arr3 = {8, 16, 3, 9, 14, 61, 37};
		System.out.println(median(arr3));	// => 14
		
		int[] arr4 = {8, 16, 3, 9, 14, 37};
		System.out.println(median(arr4));	// => 11 (= floor((9+14)/2) )
		

	}

	public static int median(int[] arr)	{
		int result = 0;
		//sorting
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr.length - i - 1; a++) {
				if(arr[a] > arr[a+1]) {
					exchange(arr, a, a+1);
				}
			}
		}
		//finding the index of the median
		if (arr.length%2 == 0) {
			int index1 = arr.length / 2 - 1;
			int index2 = arr.length / 2;
			result = (int) Math.floor((arr[index1] + arr[index2]) / 2);  
		} else {
			int oddIndex = arr.length / 2;
			result = arr[oddIndex];
		}
		return result;
		
	}
	public static void exchange(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
		
}
