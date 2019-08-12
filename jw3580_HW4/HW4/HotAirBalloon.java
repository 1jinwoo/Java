import java.awt.*;
import java.awt.geom.*;

/**
 * @author Jin Woo Won (jw3580) based on assignment 4 coding sample
 * Draws HotAirBalloon object.
 * *The reference point for balloon is at top-left corner of the sphere.
 * 
 * Dependencies:
 * 		x
 * 		-envelope
 * 		--cable
 * 		---basket
 * 		y
 * 		-envelope
 * 		--cable
 * 		---basket
 *
 */
public class HotAirBalloon implements FloatingObject {
	private int x;
	private int y;
	private final int UNIT;
	
	/**
	 * @param x
	 * @param y
	 * @param UNIT
	 * Passes in the input variables.
	 */
	public HotAirBalloon (int x, int y, int UNIT) {
		this.x = x;
		this.y = y;
		this.UNIT = UNIT; // UNIT is the diameter of the envelope
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
		int xCenter = x + UNIT / 2;
		int yCenter = y + UNIT / 2;

		// envelope
		int envelopeXUpLeft = x;
		int envelopeYUpLeft = y;
		int envelopeSize = UNIT;
		Ellipse2D.Double envelope = new Ellipse2D.Double(envelopeXUpLeft, envelopeYUpLeft, envelopeSize, envelopeSize);
		int envelopeBot = envelopeYUpLeft + UNIT;

		// left cable
		int leftCableXTop = xCenter - UNIT / 4;
		int leftCableYTop = (int) (yCenter - UNIT * Math.sqrt(3.0) / 4);
		int leftCableXBot = xCenter - UNIT / 8;
		int leftCableYBot = envelopeBot + UNIT / 2;
		Line2D.Double leftCable = new Line2D.Double(leftCableXTop, leftCableYTop, leftCableXBot, leftCableYBot);

		// right cable
		int rightCableXTop = xCenter + UNIT / 4;
		int rightCableYTop = (int) (yCenter - (UNIT * Math.sqrt(3.0) / 4));
		int rightCableXBot = xCenter + UNIT / 8;
		int rightCableYBot = envelopeBot + UNIT / 2;
		Line2D.Double rightCable = new Line2D.Double(rightCableXTop, rightCableYTop, rightCableXBot, rightCableYBot);

		// basket
		int basketXUpLeft = leftCableXBot;
		int basketYUpLeft = leftCableYBot;
		int basketSize = rightCableXBot - leftCableXBot;
		Rectangle2D.Double basket = new Rectangle2D.Double(basketXUpLeft, basketYUpLeft, basketSize, basketSize);

		// aggregate hot air balloon using one GeneralPath
		GeneralPath hotAirBalloon = new GeneralPath();
		hotAirBalloon.append(envelope, false);
		hotAirBalloon.append(leftCable, false);
		hotAirBalloon.append(rightCable, false);
		hotAirBalloon.append(basket, false);

		// draw the figure, fill the basket and envelope
		g2D.fill(envelope);
		g2D.fill(basket);
		g2D.draw(hotAirBalloon);
	}
}
