import java.awt.*;

/**
 * @author Jin Woo Won (jw3580) based on assignment 4 sample code
 * Composite interface for balloons. 
 */
public interface FloatingObject {
	
	/**
	 * @param floatingObject
	 * Adds a FloatingObject.
	 */
	void add(FloatingObject floatingObject);
	
	/**
	 * @param g2D
	 * Draws a FloatingObject.
	 */
	void draw(Graphics2D g2D);
	
	/**
	 * @param xChange
	 * @param yChange
	 * Translates a FloatingObject.
	 */
	void translate(int xChange, int yChange);
}