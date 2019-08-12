import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * @author Jin Woo Won (jw3580)
 * Draws bird.
 * *The reference point is at the top end of the left wing.
 * 									(java absolute)
 * Dependencies:
 * 		x
 * 		-leftWing
 * 		-center
 * 		--rightWing
 * 		y
 * 		-yBot
 * 		--leftWingBot
 * 		--rightWingBot
 */
public class Bird implements FlyingObject {
	private int x;
	private int y;
	private double length;
	
	/**
	 * @param x
	 * @param y
	 * @param length
	 * Passes in input variables.
	 */
	public Bird(int x, int y, double length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
	
	@Override
	public void approachUser(double lengthChange) {
		length += lengthChange;
	}
	
	@Override
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
	}
	
	@Override
	public void add(FloatingObject floatingObject) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void draw(Graphics2D g2D) {
		// basic symmetry
		int xCenter = (int) (x + length / 2);
		int yBot = (int) (y + length / 2);
		
		// left wing
		int leftWingXTop = x;
		int leftWingYTop = y;
		int leftWingXBot = xCenter;
		int leftWingYBot = yBot;
		Line2D.Double leftWing = new Line2D.Double(leftWingXTop, leftWingYTop, leftWingXBot, leftWingYBot);
		
		// right wing
		int rightWingXTop = (int) (x + length * 2 / Math.sqrt(3.0));
		int rightWingYTop = y;
		int rightWingXBot = xCenter;
		int rightWingYBot = yBot;
		Line2D.Double rightWing = new Line2D.Double(rightWingXTop, rightWingYTop, rightWingXBot, rightWingYBot);
		
		GeneralPath bird = new GeneralPath();
		bird.append(leftWing, false);
		bird.append(rightWing, false);
		
		g2D.draw(bird);
	}
}
