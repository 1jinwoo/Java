

public class P3 {

	public static void main(String[] args) {
		
		int[] answer = {8, 5, 0};
		int[] trial1 = {0, 5, 8};
		
		int[] trial2 = {1, 2, 3};
		int[] trial3 = {8, 5, 1};
		int[] trial4 = {8, 5, 0};
		
		printDecision(decide(trial1, answer), trial1);
		printDecision(decide(trial2, answer), trial2);
		printDecision(decide(trial3, answer), trial3);
		printDecision(decide(trial4, answer), trial4);
	}
	
	public static int[] decide(int[] trial, int[] answer)	{
		int[] decision = new int[3];	// for storing Strike[0], Ball[1], Out[2] counts
		int strike = 0;
		int ball = 0;
		int out = 0;
		for(int i = 0; i < answer.length; i++) {
			if(trial[i] == answer[i]) {
				strike++;
			}else{
				for(int j = 1; j <= i; j++) {
					if(trial[j] == answer[j]) {
						ball++;
					}else {
						out++;
					}
				}
			}
		}
		decision[0] = strike;
		decision[1] = ball;
		decision[2] = out;
		return decision;
	}
	
	public static void printDecision(int[] decision, int[] trial)	{
		System.out.print("For trial [ ");
		for (int i = 0; i < trial.length; i++)	{
			System.out.print(trial[i] + " ");
		}
		System.out.println("]");
		System.out.println("Strike " + decision[0] + ", "
						+ "Ball " + decision[1] + ", "
						+ "Out " + decision[2]);
	}
}
