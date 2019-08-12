import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * @author Jin Woo Won (jw3580)
 * Superclass for all moves.
 * Contains shared methods used by all move classes.
 * Contains common field used by all move classes.
 */
public class Moves {
	//applet statics
	protected static int height;
	protected static int width;
	
	protected String htmlThrowName;
	protected int htmlFontSize;
	protected Rectangle2D throwRectangle;
	protected int htmlThrowX;
	protected int htmlThrowY;
	protected int htmlHorizontal;
	protected int htmlVertical;
	protected Font throwFont;
	protected String htmlFontName;
	
	/**
	 * @param g2D
	 * Creates the throw, making sure it is on the screen.
	 */
	public void createThrow(Graphics2D g2D) {

		FontRenderContext throwContext = g2D.getFontRenderContext();
		throwRectangle = throwFont.getStringBounds(htmlThrowName, throwContext);

		// making sure throwY is in the applet
		if ((htmlThrowY > height) || ((htmlThrowY - throwRectangle.getHeight()) < 0)) {
			htmlThrowY = 0 + (int) (throwRectangle.getHeight());
		}

		// making sure throwX is in the applet
		if (((htmlThrowX + throwRectangle.getWidth()) > width) || (htmlThrowX < 0)) {
			htmlThrowX = 0;
		}
	}
	
	/**
	 * @return throwRectangle
	 * Getter for rectangle object.
	 */
	public Rectangle2D getThrowRectangle() {
		return throwRectangle;
	}

	/**
	 * Moves the throw.
	 * Horizontal and vertical wrapping around implemented.
	 */
	public void moveThrow() {
		htmlThrowX += this.htmlHorizontal;
		htmlThrowY -= this.htmlVertical;
		
		// horizontal wrap-around
		if (htmlThrowX + throwRectangle.getWidth() < 0) {
			htmlThrowX = width;
		}
		if (htmlThrowX > width) {
			htmlThrowX = (int) -throwRectangle.getWidth();
		}
		
		// vertical wrap-around
		if (htmlThrowY - (int) (throwRectangle.getHeight()) > height){
			htmlThrowY = 0;
		}
		if (htmlThrowY < 0) {
			htmlThrowY = (int) height + (int) (throwRectangle.getHeight());
		}
	}
	
	/**
	 * Increases the size of the font by fixed number.
	 */
	public void grow() {
		htmlFontSize += 40;
	}
	
	/**
	 * @param g2D
	 * Gets rid of the throw graphics.
	 */
	public void hide(Graphics2D g2D) {
		g2D.dispose();
	}
}
