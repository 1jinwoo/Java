import java.applet.Applet;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.Timer;

/**
 * @author Jin Woo Won (jw3580) based on jrk
 * 
 * Applet subclass to relay html and Java for applet application
 * Fetches from html: - throw names
 * 					  - font size
 * 					  - start location
 * 					  - direction of movement
 * 
 * Delay of the timer is hard-coded.
 * The maximum number of throws is set to be 15.
 * 
 * Corner cases:
 * 	- Multiple throws colliding simultaneously
 * 		> Depending on the order of the system recognizing collision,
 * 		  which collision is executed first changes.
 *  - Invalid html input
 *  	> Depending on Java type mismatch, throw appropriate exception.
 *  - Throws colliding as it is first drawn
 *  	> Correctly shows BOOM! and removes the loser.
 *  - Winning throw collides due to its growth
 *  	> Correctly collides with appropriate BOOM! and effects.
 *  - No collision occurs for a while
 *  	> Since the game is intended for aesthetic pleasure, and one
 *  	  throw floating around is aesthetic enough, so the lone throw
 *  	  or everlasting throws continue on forever.
 *  - Two identical throws keep producing ties
 *  	> Two identical throws will keep producing ties, which causes
 *  	  a delay because every collision produces a delay and BOOM!
 *  	  However, the user cannot see the two objects.
 */
public class Playground extends Applet {
	private final int DELAY = 5;
	private Rock rock1;
	private Rock rock2;
	private Paper paper1;
	private Scissors scissors1;
	private Lizard lizard1;
	private Spock spock1;
	private Timer appletTimer;
	private ArrayList<Throws> objects;
	
	/**
	 * Fetches parameters from html.
	 * Fetched information is prefixed with "html".
	 * Creates the throws and the timer.
	 */
	public void init() {
		
		// fetching params for applet
		Moves.height = getHeight();
		Moves.width = getWidth();
		
		//fetching params
		String htmlRock = getParameter("rock");
		String htmlPaper = getParameter("paper");
		String htmlScissors = getParameter("scissors");
		String htmlLizard = getParameter("lizard");
		String htmlSpock = getParameter("spock");
		String htmlFontSize1 = getParameter("fontsize1");
		String htmlFontSize2 = getParameter("fontsize2");
		String htmlFontSize3 = getParameter("fontsize3");
		String htmlX1 = getParameter("x1");
		String htmlX2 = getParameter("x2");
		String htmlX3 = getParameter("x3");
		String htmlX4 = getParameter("x4");
		String htmlY1 = getParameter("y1");
		String htmlY2 = getParameter("y2");
		String htmlY3 = getParameter("y3");
		String htmlY4 = getParameter("y4");
		String htmlHorizontal1 = getParameter("horizontal1");
		String htmlHorizontal0 = getParameter("horizontal0");
		String htmlHorizontal_1 = getParameter("horizontal-1");
		String htmlVertical1 = getParameter("vertical1");
		String htmlVertical0 = getParameter("vertical0");
		String htmlVertical_1 = getParameter("vertical-1");
		
		Graphics2D g2D = (Graphics2D) getGraphics();

		rock1 = new Rock(htmlRock, htmlFontSize3, htmlX1, htmlY1, htmlHorizontal1, htmlVertical1);
		rock1.createThrow(g2D);
		rock2 = new Rock(htmlRock, htmlFontSize3, htmlX3, htmlY2, htmlHorizontal1, htmlVertical0);
		rock2.createThrow(g2D);
		paper1 = new Paper(htmlPaper, htmlFontSize3, htmlX3, htmlY3, htmlHorizontal1, htmlVertical_1);
		paper1.createThrow(g2D);
		scissors1 = new Scissors(htmlScissors, htmlFontSize1, htmlX1, htmlY4, htmlHorizontal0, htmlVertical1);
		scissors1.createThrow(g2D);
		lizard1 = new Lizard(htmlLizard, htmlFontSize1, htmlX2, htmlY3, htmlHorizontal_1, htmlVertical0);
		lizard1.createThrow(g2D);
		spock1 = new Spock(htmlSpock, htmlFontSize2, htmlX4, htmlY4, htmlHorizontal_1, htmlVertical_1);
		spock1.createThrow(g2D);

		objects = new ArrayList<Throws>();
		objects.add(rock1);
		objects.add(rock2);
		objects.add(paper1);
		objects.add(scissors1);
		objects.add(lizard1);
		objects.add(spock1);
		
		if (objects.size() > 15) {
			throw new UnsupportedOperationException("Cannot have more throws than 15.");
		}
				
		appletTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ruler ruler = new Ruler(objects);
				ArrayList<Throws> newObjects = ruler.getNewObjects(g2D);
				
				// remove ghost objects floating around
				for(Throws object : newObjects) {
					if(!objects.contains(object)){
						object.hide(g2D);
					}
				}
				
				for(Throws object : objects) {
					object.moveThrow();
				}
				
				repaint();				
			}
		});
	}

	public void start() {
		appletTimer.start();
	}

	public void paint(Graphics g) {
		// paint just the survivors
		for(Throws object : objects) {	
			object.paintThrow(g);
		}
	}

	public void stop() {
		appletTimer.stop();
	}

	public void destroy() {
	}
	
}
