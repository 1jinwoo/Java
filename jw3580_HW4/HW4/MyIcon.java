import java.awt.*;
import javax.swing.*;

/**
 * @author Jin Woo Won (jw3580) based on assignment4 sample code
 * Implements Java API's Icon to create specific icons for this
 * 	program.
 */
public class MyIcon implements Icon {
	private int w;
	private int h;
	private FloatingObject obj;
	
	/**
	 * @param obj
	 * @param w
	 * @param h
	 * Passes in the parameters.
	 */
	public MyIcon(FloatingObject obj, int w, int h) {
		this.obj = obj;
		this.w = w;
		this.h = h;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconWidth()
	 */
	@Override
	public int getIconWidth() {
		return w;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconHeight()
	 */
	@Override
	public int getIconHeight() {
		return h;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		obj.draw(g2D);
	}
}
