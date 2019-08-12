
public class Palindrome {

	public static void main(String[] args) {
		"aa".toCharArray();
		
		boolean result;
		String w;
		char[] w_arr;
		
		w = "mom";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
		
		w = "dad";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
		
		w = "noon";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);	// false
		
		w = "repaper";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
		
		w = "wowowowowow";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
		
		w = "nolemonnomelon";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
		
		w = "person";
		w_arr = w.toCharArray();
		result = palindrome(w_arr, 0, w_arr.length - 1);
		System.out.println(w + " -> " + result);
	}
	
	public static boolean palindrome(char[] word, int s, int e)	{
		// TODO base part: if there is nothing left to be compared
		boolean res = false;
		if(word[s] == word[e]) {
			res = true;
		}// TODO recursive part: compare two characters
		else if (word[s] == word[e]) {
			palindrome(word, s + 1, e - 1);
		}
		// TODO delete below and write your code!
		return res;	
	}

}
