import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	/**
	 * Ensures that a pacman at every possible position within a radius of
	 * 1 of a ghost reports that the ghost is in range
	 * 
	 * @throws FileNotFoundException
	 */
	public void testGhostInRange() throws FileNotFoundException {
		NoFrame frame = new NoFrame();

		// Create a ghost
		frame.addGhost(new Location(12, 12), "Pinky", Color.pink);
		
		// Test every position within a radius of 1 around the ghost
		// and make sure they all return true for a ghost being in range
		for (int x = 11; x <= 13; x++) {
			for (int y = 11; y <= 13; y++) {
				PacMan player = frame.addPacMan(new Location(x, y));

				assertTrue("PacMan at (" + x + ", " + y + ") reported no ghost "
						+  "in range", player.is_ghost_in_range());
			}
		}

		// Test a scenario where the pacman is in a corner of the map
		frame.addGhost(new Location(1, 2), "Pinky", Color.pink);
		PacMan player = frame.addPacMan(new Location(1, 1));

		assertTrue(player.is_ghost_in_range());
	}

	/**
	 * Ensures that a pacman that is not within a ghost's attack range
	 * correctly reports that there is no ghost in range
	 * 
	 * @throws FileNotFoundException
	 */
	public void testGhostInRangeAway() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		
		// Create a ghost
		frame.addGhost(new Location(3, 3), "Pinky", Color.pink);

		// Make sure a pacman just outside of the attack range does
		// not report that a ghost is in range
		PacMan player = frame.addPacMan(new Location(5, 3));
		assertFalse(player.is_ghost_in_range());
		
		// Test a scenario where the pacman is in a corner of the map
		PacMan playerCorner = frame.addPacMan(new Location(1, 1));
		assertFalse(playerCorner.is_ghost_in_range());
	}
}

