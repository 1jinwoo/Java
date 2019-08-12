import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Jin Woo Won (jw3580)
 * Interfaces to generalize the throws.
 *
 */
public interface Throws {

	/**
	 * @param g2D
	 * Creates throw, making sure the move is in the screen.
	 */
	public void createThrow(Graphics2D g2D);
	
	/**
	 * Changes the parameters to move the throw.
	 */
	public abstract void moveThrow();
	
	/**
	 * @param g
	 * Paints the throw that reflects the parameters.
	 */
	public abstract void paintThrow(Graphics g);
	
	/**
	 * @return throwRectangle
	 * Getter for Rectangle object for the throw.
	 */
	public Rectangle2D getThrowRectangle();
	
	/**
	 * @param g2D
	 * Removes the object completely.
	 */
	public void hide(Graphics2D g2D);
	
	/**
	 * Increases the size the font to make it grow.
	 */
	public void grow();
}
