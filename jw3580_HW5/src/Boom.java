import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * @author Jin Woo Won (jw3580)
 * Creates and draws BOOM! animation.
 */
public class Boom {

	private int boomX;
	private int boomY;
	private Rectangle2D boomRectangle;
	private final String BOOM = "BOOM!";
	private Font boomFont;
	
	
	/**
	 * @param boomX
	 * @param boomY
	 * Passes in the location of the BOOM!
	 */
	public Boom(int boomX, int boomY) {
		this.boomX = boomX;
		this.boomY = boomY;
		
		boomFont = new Font("Stencil Std", Font.BOLD, 150);
	}
	
	/**
	 * @param g2D
	 * Paints the BOOM! and trims the Graphics2D to fit the string.
	 */
	public void paintBoom(Graphics2D g2D) {
		FontRenderContext throwContext = g2D.getFontRenderContext();
		boomRectangle = boomFont.getStringBounds(BOOM, throwContext);
		g2D.setFont(boomFont);
		g2D.setColor(Color.RED); 
		
		//updating rectangle for detecting collisions
		boomRectangle = new Rectangle(boomX, 
									boomY,
									(int) boomRectangle.getWidth(),
									(int) boomRectangle.getHeight());
		g2D.drawString(BOOM, boomX, boomY);
	}
	
	/**
	 * @param g2D
	 * Removes the BOOM!
	 */
	public void hide(Graphics2D g2D) {
		g2D.dispose();
	}
	
	
}
