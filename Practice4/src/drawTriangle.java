public class drawTriangle{
	
	public static void main (String[] args){
		//sample triangle size: 4
		/*System.out.println("*");
		
		System.out.print("*");
		System.out.println("*");
		
		System.out.print("*");
		System.out.print(" ");
		System.out.println("*");
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.println("*");
		*/
		drawTriangle(13);
	}
	public static void drawTriangle(int size){
		System.out.println("*");
		//System.out.print("*");
		for(int i = 1; i < (size-1); i++) {
			System.out.print("*");
			for(int a = 2; a <= size; a++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for(int b = 1; b <= size; b++ ) {
			System.out.print("*");
		}
	}
}