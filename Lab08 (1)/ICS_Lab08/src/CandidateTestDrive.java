import soln.Candidate;

public class CandidateTestDrive {

	public static void main(String[] args) {
		
		// for example, candidates in 2017 19th South Korea Presidential Election   
		int[] indexes = {1, 2, 3, 4, 5};
		String[] names = {
				"Moon Jae-in",
				"Hong Joon-pyo",
				"Ahn Cheol-soo",
				"Yoo Seung-min",
				"Shim Sang-jeong"
				};
		
		// test a class Candidate (in previous lab)
		Candidate c2 = new Candidate();
		
		c2.name = names[1];
		c2.setIndex(indexes[1]);
		
		c2.introduce();
		
		// do same things for other new instance (in previous lab)
		Candidate c3 = new Candidate();
		
		c3.name = names[2];
		c3.setIndex(indexes[2]);
		
		c3.introduce();
		
		// TODO 1. create array of instances
		Candidate candidates[] = new Candidate();
		for (int i = 0; i < candidates.length; i++) {
			
		}
		
		
		// TODO 2. test class method version of introduce()
		
		
		
		// TODO 3. check if 'total instance count' class variable increments expectedly
		//         print them!
		
		
		
	}

}
