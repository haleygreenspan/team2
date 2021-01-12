import junit.framework.*;
import static org.junit.Assert.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	/**
	 * Ensures that a ghost at every possible position within a radius of
	 * 1 of a pacman reports that the pacman is in range
	 * 
	 * @throws FileNotFoundException
	 */
	public void testPacManInRange() throws FileNotFoundException {
		NoFrame frame = new NoFrame();

		// Create a pacman
		frame.addPacMan(new Location(12, 12));
		
		// Test every position within a radius of 1 around the pacman
		// and make sure they all return true for a pacman being in range
		for (int x = 11; x <= 13; x++) {
			for (int y = 11; y <= 13; y++) {
				Ghost ghost = frame.addGhost(new Location(x, y),
											 "Pinky(" + x + ", " + y + ")",
											 Color.pink);

				assertTrue("Ghost at (" + x + ", " + y + ") reported no pacman "
						+  "in range", ghost.is_pacman_in_range());
			}
		}

		// Test a scenario where the ghost is in a corner of the map
		frame.addPacMan(new Location(1, 2));
		Ghost ghost = frame.addGhost(new Location(1, 1), "Pinky", Color.pink);

		assertTrue(ghost.is_pacman_in_range());
	}

	/**
	 * Ensures that a ghost that is not close enough to attack a pacman
	 * correctly reports that there is no pacman in range
	 * 
	 * @throws FileNotFoundException
	 */
	public void testPacManInRangeAway() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		
		// Create a pacman
		frame.addPacMan(new Location(3, 3));

		// Make sure a ghost just outside of the attack range does
		// not report that a pacman is in range
		Ghost ghost = frame.addGhost(new Location(5, 3), "Pinky", Color.pink);
		assertFalse(ghost.is_pacman_in_range());
		
		// Test a scenario where the ghost is in a corner of the map
		Ghost ghostCorner = frame.addGhost(new Location(1, 1), "Inky",
										   Color.cyan);

		assertFalse(ghost.is_pacman_in_range());
	}
}
