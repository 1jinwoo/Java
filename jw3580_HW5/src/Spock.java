import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

/**
 * @author Jin Woo Won (jw3580)
 * Spock looks distinct from others.
 *
 */
public class Spock extends Moves implements Throws {

	/**
	 * @param htmlThrowName
	 * @param htmlFontSize
	 * @param htmlThrowX
	 * @param htmlThrowY
	 * @param htmlHorizontal
	 * @param htmlVertical
	 * Passes in parameters.
	 * Sets the font.
	 * Creates the Font object.
	 */
	public Spock(String htmlThrowName,
				String htmlFontSize,
				String htmlThrowX,
				String htmlThrowY,
				String htmlHorizontal,
				String htmlVertical) {
		this.htmlThrowName = htmlThrowName;
		this.htmlFontSize = Integer.parseInt(htmlFontSize);
		this.htmlThrowX = Integer.parseInt(htmlThrowX);
		this.htmlThrowY = Integer.parseInt(htmlThrowY);
		this.htmlHorizontal = Integer.parseInt(htmlHorizontal);
		this.htmlVertical = Integer.parseInt(htmlVertical);
	
		htmlFontName = "Times New Roman";
		
		throwFont = new Font(htmlFontName, Font.BOLD, this.htmlFontSize);
	}
	
	@Override
	public void paintThrow(Graphics g) {
		throwFont = new Font(htmlFontName, Font.BOLD, this.htmlFontSize);
		FontRenderContext throwContext = ((Graphics2D) g).getFontRenderContext();
		throwRectangle = throwFont.getStringBounds(htmlThrowName, throwContext);
		g.setFont(this.throwFont);
		g.setColor(Color.MAGENTA); 
		
		//for detecting collisions
		throwRectangle = new Rectangle(htmlThrowX,
									htmlThrowY,
									(int) throwRectangle.getWidth(),
									(int) throwRectangle.getHeight());
				
		g.drawString(htmlThrowName, htmlThrowX, htmlThrowY);
	}
}
