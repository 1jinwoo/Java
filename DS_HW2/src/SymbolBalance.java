import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* Following the specification in the README.md file, provide your 
 * SymbolBalance class.
 */

public class SymbolBalance {

	private static ArrayList<Character> openSymbols = new ArrayList<>();
	private static ArrayList<Character> closeSymbols = new ArrayList<>();

	private static MyStack<Character> symbolStack = new MyStack<>();

	private static boolean isQuote = false;
	private static boolean isComment = false;
	private static boolean hasError = false;

	public static void main(String[] args) throws IOException {

		populateLists();

		checkSymbolBalance(args);
	}

	private static void checkSymbolBalance(String[] args) throws IOException {
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);
		int r;
		while ((r = br.read()) != -1) {
			char ch = (char) r;
			
			// process ch
			// ignore comment until it is closed
			if (ch == '/') {
				char next = (char) br.read();
				if (next == '*' && !isComment && !isQuote) {
					// needs to enter comment
					isComment = true;
					symbolStack.push(ch); // ch is the '/'
					symbolStack.push(next); // next is the '*'
					continue;
				}
			}
			
			if (ch == '*') {
				char next = (char) br.read();
				if (next == '/' && isComment && !isQuote) {
					// needs to exit comment
					isComment = false;
					char toBeAsterisk = symbolStack.pop();
					char toBeSlash = symbolStack.pop();
					if (toBeAsterisk != ch) {
						System.out.println("Unbalanced! Symbols "
					+ toBeAsterisk + " and " + ch + " are not matched. ");
						hasError = true;
						break;
					} else {
						if (toBeSlash != next) {
							System.out.println("Unbalanced! Symbols "
											+ toBeSlash + " and " 
											+ next + " are not matched. ");
							hasError = true;
							break;
						} 
					}
					continue;
					
				}
			}
			
			// ignore quote until it is closed
			if (ch == '"' && !isComment) {
				if (isQuote) {
					char partner = symbolStack.pop();
					if (partner != '"') {
						System.out.println("Unbalanced! Symbols " + 
					partner + " and " + ch + " are not matched. ");
						hasError = true;
						break;
					}
					isQuote = false;
					continue;
					
				} else {
					isQuote = true;
					symbolStack.push(ch);
				}
			}
			
			// push opening symbols
			if (openSymbols.contains(ch) && !isQuote && !isComment) {
				symbolStack.push(ch);				
			}

			// pop stack if closing symbol is encountered and check match
			if (closeSymbols.contains(ch) && !isQuote && !isComment) {
				
				// check if extra closing symbol is present
				if (symbolStack.isEmpty()) {
					System.out.println("Unbalanced! Symbol " 
										+ ch + " is mismatched. ");
					hasError = true;
					break;
				}
				
				char partner = symbolStack.pop();
				char expected = openSymbols.get(closeSymbols.indexOf(ch));
				if (partner != expected) {
					System.out.println("Unbalanced! Symbols "+ partner
										+ " and " + ch + " are mismatched. ");
					hasError = true;
					break;
				}
			}

		}
		
		// error handling
		if (!symbolStack.isEmpty() && !hasError) {
			char leftOver = symbolStack.pop();
			System.out.println("Unbalanced! Symbol "
								+ leftOver + " is mismatched. ");
		} else if (!hasError && symbolStack.isEmpty()) {
			System.out.println("No mismatch detected. ");
		}
		br.close();
	}
	
	private static void populateLists() {
		openSymbols.add('(');
		openSymbols.add('{');
		openSymbols.add('[');
		openSymbols.add('"');
		closeSymbols.add(')');
		closeSymbols.add('}');
		closeSymbols.add(']');
		closeSymbols.add('"');
	}

}