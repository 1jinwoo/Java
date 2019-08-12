import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author Jin Woo Won (jw3580)
 * Part of the composite scheme.
 * Flock can include other flock of birds or just birds.
 */
public class Flock implements FlyingObject {
	private int x;
	private int y;
	private ArrayList<FlyingObject> birds;
	
	/**
	 * @param x
	 * @param y
	 * Passes in the input coordinates.
	 */
	public Flock(int x, int y) {
		this.x = x;
		this.y = y;
		birds = new ArrayList<FlyingObject>();
	}
	
	@Override
	public void approachUser(double lengthChange) {
		for(FlyingObject bird : birds) {
			bird.approachUser(lengthChange);
		}
	}
	
	@Override
	public void add(FloatingObject bird) {
		birds.add((FlyingObject) bird);
	}
	
	@Override
	public void draw(Graphics2D g2D) {
		for(FlyingObject bird : birds) {
			bird.draw(g2D);
		}
	}
	
	@Override
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
		for(FlyingObject bird : birds) {
			bird.translate(xChange, yChange);
		}
	}
}
