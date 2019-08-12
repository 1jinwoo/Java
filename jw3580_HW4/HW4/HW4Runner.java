/**
 * @author Jin Woo Won (jw3580) based on assignment 4 sample code
 * 
 * Initializes Frame instance and runs the program.
 * 
 * Cornercases:
 * 	- the slider at 0 -> balloons move up at default delay
 *  - the slider value is applied immediately regardless of the user
 *    manipulating the slider
 *  - enough time passes for birds to move at a maximum speed
 *    -> the maximum speed at which bird moves and grows is preset.
 *  - birds, balloons overlapping? -> birds and balloons are in
 *    separate icons, so they do not overlap.
 *  - random balloons drawn on top of each other? -> balloons are all
 *    drawn on the same icon, so they can overlap and the observer
 *    can see through the empty places of each balloon.
 *
 */
public class HW4Runner {
	public static void main(String[] args) {
		Frame myFrame = new Frame();
		myFrame.animateMassAscension();
		myFrame.animateBirdFlock();
	}
}
