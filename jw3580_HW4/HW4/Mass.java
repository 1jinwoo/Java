import java.awt.*;
import java.util.ArrayList;

/**
 * @author Jin Woo Won (jw3580)
 * Part of the composite scheme.
 * Mass can include other mass of balloons or just balloons.
 */
public class Mass implements FloatingObject {
	private int x;
	private int y;
	private ArrayList<FloatingObject> balloons;
	
	/**
	 * @param x
	 * @param y
	 * Passes in the input coordinates.
	 */
	public Mass (int x, int y) {
		this.x = x;
		this.y = y;
		balloons = new ArrayList<FloatingObject>();
	}

	@Override
	public void add(FloatingObject balloon) {
		balloons.add(balloon);
	}

	@Override
	public void draw(Graphics2D g2D) {
		for(FloatingObject balloon : balloons) {
			balloon.draw(g2D);
		}
	}
	
	@Override
	public void translate(int xChange, int yChange) {
		x += xChange;
		y += yChange;
		for(FloatingObject balloon : balloons) {
			balloon.translate(xChange, yChange);
		}
	}
}
