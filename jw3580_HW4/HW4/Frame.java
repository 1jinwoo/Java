import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Jin Woo Won (jw3580) based on assignment 4 sample code
 * Frame class sets up JFrame and creates all the objects
 * that star in the animation.
 * Frame class also coordinates timers for the objects.
 *
 */
public class Frame {
	// preset constants
	private static final int UNIT = 40;
	private static final int ICON_W = 400;
	private static final int ICON_H = 800;
	
	// constants for slider
	private final int SPD_MIN = 0;
	private final int SPD_MAX = 500;
	private final int SPD_INIT = 0;
	
	private JSlider balloonSpeed = null;
	private int delay;
	
	private JFrame myFrame;
	final JPanel balloonPanel = new JPanel(new BorderLayout());

	
	/**
	 * Creates JFrame where all the objects are painted.
	 */
	public Frame () {
		myFrame = new JFrame();
	}
	
	/**
	 * @return a balloon with random size at random x location.
	 */
	private FloatingObject createRandomBalloon() {
		int x = (int) (Math.random() * ICON_W);
		int y = 400;
		int size = (int) (UNIT * 0.5 + (UNIT * Math.random() * 1.5));
		System.out.println("x is: " + x + "\n y is: " + y + "\n size is: " + size);
		return new HotAirBalloon(x, y, size);
	}
	
	/**
	 * @param FloatingObject
	 * @return MyIcon
	 * Creates MyIcon for the input object.
	 */
	private MyIcon createIcon(FloatingObject FloatingObject) {
		return new MyIcon(FloatingObject, ICON_W, ICON_H);
	}
	
	/**
	 * @param myIcon
	 * @return JLabel
	 * Creates JLabel for the input MyIcon.
	 */
	private JLabel createLabel(MyIcon myIcon) {
		return new JLabel(myIcon);
	}
	
	/**
	 * Creates 7 random balloons.
	 * Creates a mass and adds all 7 balloons to it.
	 * Paints the mass and the slider.
	 * Starts the timer for the mass.
	 */
	public void animateMassAscension() {
		// creating 7 balloons
		final FloatingObject balloon1 = createRandomBalloon();
		final FloatingObject balloon2 = createRandomBalloon();
		final FloatingObject balloon3 = createRandomBalloon();
		final FloatingObject balloon4 = createRandomBalloon();
		final FloatingObject balloon5 = createRandomBalloon();
		final FloatingObject balloon6 = createRandomBalloon();
		final FloatingObject balloon7 = createRandomBalloon();
		
		// mass of balloons
		final FloatingObject mass = new Mass(0, 500);
		mass.add(balloon1);
		mass.add(balloon2);
		mass.add(balloon3);
		mass.add(balloon4);
		mass.add(balloon5);
		mass.add(balloon6);
		mass.add(balloon7);
		
		// handling the painting
		final MyIcon myIcon = createIcon(mass);
		final JLabel myLabel = createLabel(myIcon);
		
		// slider setup
		setUpSlider();
		final JPanel sliderPanel = new JPanel();
		sliderPanel.add(balloonSpeed);
		
		balloonPanel.add(myLabel, BorderLayout.CENTER);
		balloonPanel.add(sliderPanel, BorderLayout.EAST);		
		handleGUIIdiom();
		
		Timers timers = new Timers(mass, myLabel);
		timers.startBalloonTimer();
		balloonSpeed.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e) {
				int speed = (((JSlider)e.getSource()).getValue());
				delay = 510 - speed; // default speed comes from here
				timers.balloonTimer.setDelay(delay);
				System.out.println(delay);
			}
		});
	}
	
	/**
	 * JSlider source: https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SliderDemoProject/src/components/SliderDemo.java
	 * Sets up the slider that controls the ascending speed of balloons.
	 */
	public void setUpSlider() {
		balloonSpeed = new JSlider(JSlider.VERTICAL, SPD_MIN, SPD_MAX, SPD_INIT);
		balloonSpeed.setMajorTickSpacing(250);
		balloonSpeed.setMinorTickSpacing(50);
		balloonSpeed.setPaintTicks(true);
		balloonSpeed.setPaintLabels(true);
		
	}
	
	/**
	 * @return bird with random length and random coordinates.
	 */
	private FloatingObject createRandomBird() {
		int x = (int) (Math.random() * ICON_W);
		int y = (int) (100 + Math.random() * 280);
		double length = UNIT * Math.random();
		return new Bird(x, y, length);
	}
	
	/**
	 * Creates 5 random birds.
	 * Creates a flock and adds all 5 birds to the flock.
	 * Paints and starts the timer for the flock.
	 */
	public void animateBirdFlock() {
		// creating 5 birds
		final FloatingObject bird1 = createRandomBird();
		final FloatingObject bird2 = createRandomBird();
		final FloatingObject bird3 = createRandomBird();
		final FloatingObject bird4 = createRandomBird();
		final FloatingObject bird5 = createRandomBird();

		final FlyingObject flock = new Flock(0, 200);
		flock.add(bird1);
		flock.add(bird2);
		flock.add(bird3);
		flock.add(bird4);
		flock.add(bird5);
		
		final MyIcon myIcon = new MyIcon(flock, 400, 400);
		final JLabel myLabel = createLabel(myIcon);
		
		balloonPanel.add(myLabel, BorderLayout.NORTH);

		myFrame.add(balloonPanel);
		
		handleGUIIdiom();
		
		Timers timers = new Timers(flock, myLabel);
		timers.startBirdTimer();
	}
	
	/**
	 * Handles the Java GUI idiom.
	 */
	private void handleGUIIdiom() {
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
