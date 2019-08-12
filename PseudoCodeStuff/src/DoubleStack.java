
public class DoubleStack {
	private int[] arr;
	
	private int top1;
	private int top2;
	
	public DoubleStack() {
		arr = new int[10];
		top1 = 0;
		top2 = arr.length - 1;
	}
	public void pushStackA (int inNumber) {
		if(top1 <= top2) {
			arr[top1] = inNumber;
			top1++;
		} else {
			throw new StackOverflowError();
		}
	}
	
	public void pushStackB (int inNumber) {
		if(top2 >= top1) {
			arr[top2] = inNumber;
			top2--;
		} else {
			throw new StackOverflowError();
		}
	}
	
	public int popStackA() {
		if (top1 < 0) {
			throw new UnsupportedOperationException();
		}
		return arr[--top1];
	}

	public int popStackB() {
		if (top2 > (arr.length - 1)) {
			throw new UnsupportedOperationException();
		}
		return arr[++top2];
	}
	
	public int peekStackA () {
		if(top1 <= 0) {
			throw new UnsupportedOperationException();
		}
		return arr[top1 - 1];
	}
	
	public int peekStackB () {
		if(top2 >= (arr.length - 1)) {
			throw new UnsupportedOperationException();
		}
		return arr[top2 + 1];
	}
}
