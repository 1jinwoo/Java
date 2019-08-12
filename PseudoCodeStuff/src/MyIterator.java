import java.util.Iterator;

public class MyIterator<AnyType> implements Iterator<AnyType> {
	private int current = -1;
	
	public MyIterator(){
		current = 0;
	}
	
	@Override
	public boolean hasNext() {
		
		return false;
	}

	@Override
	public AnyType next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
