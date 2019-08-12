import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Jin Woo Won (jw3580)
 * Creates and updates Timers to animate the objects.
 * Renders a realistic movement for birds by applying one-point
 * 	perspective equation.
 */
public class Timers {
	private int delay = 100; // milliseconds between timer ticks
	private int birdDelay = 100;
	private FloatingObject floatingObject;
	private FlyingObject flyingObject;
	private JLabel myLabel;
	public Timer balloonTimer;
	public Timer birdTimer;
	
	/**
	 * @param floatingObject
	 * @param myLabel
	 * Passes in the object and label for setting up a timer.
	 * This constructor is for balloons.
	 */
	public Timers(FloatingObject floatingObject, JLabel myLabel) {
		this.floatingObject = floatingObject;
		this.myLabel = myLabel;
	}
	
	/**
	 * Sets up and start a timer for a balloon object.
	 */
	public void startBalloonTimer() {
		balloonTimer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				floatingObject.translate(0, -1);
				myLabel.repaint();
			}
		});
		balloonTimer.start();
	}
	
	/**
	 * @param flyingObject
	 * @param myLabel
	 * Passes in the object and the label for setting up a timer.
	 * This constructor is for a bird object.
	 */
	public Timers(FlyingObject flyingObject, JLabel myLabel) {
		this.flyingObject = flyingObject;
		this.myLabel = myLabel;
	}
	
	// variables for rendering realistic bird movement
	private int counter = 0;
	private double approachVar = 0.1;
	
	/**
	 * Creates and starts bird timer that allow birds to move
	 * 	toward the user realistically.
	 */
	public void startBirdTimer() {
		birdTimer = new Timer(birdDelay, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				flyingObject.approachUser(approachVar);
				flyingObject.translate(0, - (int) approachVar);
				myLabel.repaint();
				counter++;
				System.out.println("counter = " + counter);
				if(counter < 100) {
					approachVar = (1 / (1 - 0.01 * counter));	// from 2.3.1 assignment4
				} else {
					approachVar = 10000;
				}
			}
		});
		birdTimer.start();
	}
}
