package helloWorld;



	


public class NameMaker {
	
	public NameMaker() {
		name = "name";
	}
	public NameMaker(String inName) {
		name = inName;
	}
	public NameMaker(String inName, String inSuffix) {
		name = inName;
		suffix = inSuffix;
		
	}
	public String whatToSay() {
		return name + " " + suffix;
	}
	private String name;
	private String suffix;

}
