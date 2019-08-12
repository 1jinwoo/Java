import java.util.ArrayList;
import java.util.LinkedList;

/* Following the specification in the README.md file, provide your 
 * ExpressionTree class.
 */

public class ExpressionTree {
	
	private class ExpressionNode {
		private String theElement;
		private ExpressionNode left;
		private ExpressionNode right;
		
		public ExpressionNode(String theElement) {
			this(theElement, null, null);
		}
		
		public ExpressionNode(String theElement, ExpressionNode left, ExpressionNode right) {
			this.theElement = theElement;
			this.left = left;
			this.right = right;
		}
	}
	
	private LinkedList<ExpressionNode> stack;
	private final ArrayList<String> operators;
	private ExpressionNode root;
	
	public ExpressionTree(String expression) {
		
		String[] theElements = expression.split(" ");
		stack = new LinkedList<ExpressionNode>();
		operators = new ArrayList<>();
		
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		
		// constructing ExpressionTree
		for(String element : theElements) {
			
			if(operators.contains(element)) {
				if(!stack.isEmpty()) {
					ExpressionNode secondOperand = stack.pop();
					ExpressionNode firstOperand = stack.pop(); 
					
					// constructing ExpressionTree with height of 1
					ExpressionNode operator = new ExpressionNode(element, firstOperand, secondOperand);

					stack.push(operator);
				} else {
					System.err.println("Invalid expression");
				}
				
			} else {				
				ExpressionNode operand = new ExpressionNode(element);
				stack.push(operand);
			}
		}
		
		root = stack.pop();
		
		if(!stack.isEmpty()) {
			System.err.println("Invalid expression");
		}
		
	}
	
	public int eval() {
		return eval(root);
	}
	
	public String postfix() {
		return postfix(root);
	}
	
	public String prefix() {
		return prefix(root);
	}
	
	public String infix() {
		return infix(root);
	}
	
	private int eval(ExpressionNode root) {
		int result = 0;

		if (root.theElement.equals("+")) {
			result += eval(root.left) + eval(root.right);
		} else if (root.theElement.equals("-")) {
			result += eval(root.left) - eval(root.right);
		} else if (root.theElement.equals("*")) {
			result += eval(root.left) * eval(root.right);
		} else if (root.theElement.equals("/")) {
			result += eval(root.left) / eval(root.right);
		} else {
			result = Integer.parseInt(root.theElement);
		}
		return result;
	}
	
	private String postfix(ExpressionNode root) {
		String result = "";
		if(root != null) {
			result += postfix(root.left);
			result += postfix(root.right);
			result += root.theElement + " ";
		}
		
		return result;
	}
	
	private String prefix(ExpressionNode root) {
		String result = "";
		if(root != null) {
			result += root.theElement + " ";
			result += prefix(root.left);
			result += prefix(root.right);
		}
		
		return result;
	}
	
	private String infix(ExpressionNode root) {
		String result = "";
		if(root != null) {
			result += "(" + infix(root.left);
			result += root.theElement;
			result += infix(root.right) + ")";
		}
		
		return result;
	}
}