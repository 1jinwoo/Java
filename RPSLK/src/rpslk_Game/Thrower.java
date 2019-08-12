package rpslk_Game;
import java.util.concurrent.ThreadLocalRandom;

//the strategy of throwing
/**
 * @author Jin Woo Won
 *  This class is ....
 */
public class Thrower {
	//throwing strategy: random
	private static int min = 0;
	private static int max = 4;
	private static int randomNum = 0;

	//random number generator from https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	public static String randomThrow() {
		String cpuThrow = "default";
		randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		if(randomNum == 0) {
			cpuThrow = "rock";
		} else if (randomNum == 1) {
			cpuThrow = "paper";
		} else if (randomNum == 2) {
			cpuThrow = "scissors";
		} else if (randomNum == 3) {
			cpuThrow = "lizard";
		} else if (randomNum == 4) {
			cpuThrow = "spock";
		}
		return cpuThrow;
	}
	/*public static String intelligentThrow() {
	}*/
	
	
}
