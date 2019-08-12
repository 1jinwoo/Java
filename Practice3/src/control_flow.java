
public class control_flow {

	public static void main(String[] args) {
		gradeSwitch(5);
		whosBest(60,90);
		whosBest(50,85);
		whosBest(35,45);
		sugar(8.8);
		sugar(13.5);
		sugar(25.1);
		sugar(50.5);
	}
	public static void gradeSwitch (int grade) {
		switch (grade) {
		case 0 : System.out.println("Your grade is F");
			break;
		case 1 : System.out.println("Your grade is D");
			break;
		case 2 : System.out.println("Your grade is C");
			break;
		case 3 : System.out.println("Your grade is B");
			break;
		case 4 : System.out.println("your grade is A");
			break;
		case 5 : System.out.println("Your grade is A+");
			break;
		default: System.out.println("input some other grade to get correct result");
		}
		
	}
	public static void whosBest(double midtermExam, double finalExam) {
		double mid = midtermExam / 60;
		System.out.println(mid);
		double fin = finalExam / 90;
		System.out.println(fin);
		if(mid > fin) {
			System.out.println("Your mid-term grade is better");
		} else if (mid == fin) {
			System.out.println("The two grades are equivalent");
		} else {
			System.out.println("Your final exam grade is better");
		}
	}
	public static void sugar(double content) {
		if (content >= 8.6 && content <= 9.9) {
			System.out.println("watermelon");
		}
		else if (content >= 12.1 && content <= 14.1) {
			System.out.println("kiwi");
		}
		else if (content >= 20.8 && content <= 26.9) {
			System.out.println("banana");
		} 
		else {
			System.out.println("unknown");
		}
	}

}
