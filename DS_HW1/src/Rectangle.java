
public class Rectangle implements Comparable<Rectangle> {
    private int length;
    private int width;
    private int perimeter;
    
    public Rectangle(int length, int width) {
    	this.length = length;
    	this.width = width;
    	this.perimeter = length * 2 + width * 2;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getWidth(){
        return width;
    }
    
	@Override
	public int compareTo(Rectangle rec) {
		if(this.perimeter == rec.perimeter) {
			return 0;
		} else if(this.perimeter > rec.perimeter) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		return "(" + length + ", " + width + ")";
	}
}
