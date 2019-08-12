import java.awt.Point;

/**
 * @author Jin Woo Won
 * Composite interface for birds and flocks of birds.
 * Extends FloatingObject and uses the same Composite pattern scheme.
 */
public interface FlyingObject extends FloatingObject {
	
	/**
	 * Object is approaching the user: implemented as increasing in length.
	 */
	void approachUser(double lengthChange);
}
