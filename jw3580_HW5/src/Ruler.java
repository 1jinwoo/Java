import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jin Woo Won (jw3580) based on HW1_solutions by Kimberly Tao
 * 
 * Recognizes collisions, decides the winner, and indicates the losers.
 * Displays BOOM! animation when collisions occur.
 * Ties still cause BOOM! animations, but their delay is much shorter.
 */
public class Ruler {
	private ArrayList<Throws> objects;
	private int boomX;
	private int boomY;
	private static Result[][] resultMatrix = {
															/* P1*/
							/*	Rock		Paper			Scissors		Lizard			Spock*/
			/*Rock*/		{ Result.TIE, Result.P1_WIN, Result.P2_WIN, Result.P2_WIN, Result.P1_WIN },
			/*Paper*/		{ Result.P2_WIN, Result.TIE, Result.P1_WIN, Result.P1_WIN, Result.P2_WIN },
/*P2*/		/*Scissors*/	{ Result.P1_WIN, Result.P2_WIN, Result.TIE, Result.P2_WIN, Result.P1_WIN },
			/*Lizard*/		{ Result.P1_WIN, Result.P2_WIN, Result.P1_WIN, Result.TIE, Result.P2_WIN },
			/*Spock*/		{ Result.P2_WIN, Result.P1_WIN, Result.P2_WIN, Result.P1_WIN, Result.TIE }
};
	
	/**
	 * @param objects
	 * Passes in objects, which contains the list of current survivors.
	 */
	public Ruler(ArrayList<Throws> objects) {
		this.objects = objects;
	}
	
	/**
	 * @param g2D
	 * @return hashset of losers
	 * Decides the losers, and displays the BOOM! when collision occurs.
	 * Grows throws when they survive.
	 */
	public Set<Throws> decideLosers(Graphics2D g2D) {		
		Set<Throws> losers = new HashSet<Throws>();
		for(Throws object : objects) {
			for(Throws compared : objects) {
				Rectangle2D r1 = object.getThrowRectangle();
				Rectangle2D r2 = compared.getThrowRectangle();
				if (r1.intersects(r2) && (object.hashCode() != compared.hashCode())) {
					boomX = (int) ((r1.getCenterX() + r2.getCenterX()) / 2);
					boomY = (int) ((r1.getCenterY() + r2.getCenterY()) / 2);
					if (getResult(object, compared) == Result.P1_WIN) {
						object.grow();
						losers.add(compared);
						try {
							Boom boom = new Boom(boomX, boomY);
							boom.paintBoom(g2D);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else if(getResult(object, compared) == Result.P2_WIN) {
						compared.grow();
						losers.add(object);
						try {
							Boom boom = new Boom(boomX, boomY);
							boom.paintBoom(g2D);
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						try {
							Boom boom = new Boom(boomX, boomY);
							boom.paintBoom(g2D);
							Thread.sleep(20);	// shorter delay to not annoy users.
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					
				} 
			}
		}
		return losers;
	}
	
	/**
	 * @param g2D
	 * @return newObjects
	 * Updates the objects arraylist to reflect the current
	 * survivors.
	 */
	public ArrayList<Throws> getNewObjects(Graphics2D g2D){
		Set<Throws> losers = decideLosers(g2D);
		objects.removeAll(losers);
		return objects;
	}
	
	/**
	 * @param object
	 * @return Move constant
	 * Returns the corresponding Move constant for each throw
	 * object.
	 */
	private Move getMove(Throws object) {
		Move move;
		if(object instanceof Rock) {
			move = Move.ROCK;
		} else if (object instanceof Paper) {
			move = Move.PAPER;
		} else if (object instanceof Scissors) {
			move = Move.SCISSORS;
		} else if (object instanceof Lizard) {
			move = Move.LIZARD;
		} else {
			move = Move.SPOCK;
		}
		return move;
	}
	
	/**
	 * @param object1
	 * @param object2
	 * @return Result
	 * Determines the winner of a collision.
	 */
	public Result getResult(Throws object1, Throws object2) {
		Move move1 = getMove(object1);
		Move move2 = getMove(object2);
		return resultMatrix[move2.getValue()][move1.getValue()];
	}
	
	
}
