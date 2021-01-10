import java.awt.Color;
import java.io.*;

import static org.junit.Assert.*;
import junit.framework.*;

public class TestMapAttack extends TestCase {

	/**
	 * Ensures that a ghost in the range of pacman can be controlled
	 * to perform a successful attack, and that the game also ends
	 * after the attack
	 */
	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		
		frame.addPacMan(new Location(12, 12));
		frame.addGhost(new Location(13, 13), "Boo", Color.white);
		
		// Make sure that Boo is able to attack pacman
		assertTrue(frame.getMap().attack("Boo"));

		// Make sure that the game is now over
		assertTrue(frame.getMap().isGameOver());
	}

	/**
	 * Ensures that a map attack fails if the name of a non-existent or
	 * non-ghost entity (e.g. a wall or cookie name) is given
	 */
	public void testMapAttackInvalid() throws FileNotFoundException  {
		NoFrame frame = new NoFrame();

		frame.addPacMan(new Location(12, 12));

		// Make sure that a non-existent ghost can't attack pacman
		assertFalse(frame.getMap().attack("Boo"));

		// Make sure that a non-ghost entity can't attack pacman
		assertFalse(frame.getMap().attack("wall"));

		// Make sure that the game is not over
		assertFalse(frame.getMap().isGameOver());
	}

	/**
	 * Ensures that a map attack fails if the specified ghost is too far
	 * away from pacman
	 */
	public void testMapAttackAway() throws FileNotFoundException  {
		NoFrame frame = new NoFrame();

		frame.addPacMan(new Location(12, 12));
		frame.addGhost(new Location(15, 12), "Boo", Color.white);

		// Make sure that Boo can't attack pacman
		assertFalse(frame.getMap().attack("Boo"));

		// Make sure that the game is not over
		assertFalse(frame.getMap().isGameOver());
	}
}
