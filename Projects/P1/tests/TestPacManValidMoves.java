import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException {
		// Creating A Map
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display

		// A pacman at location 0,0 should be able to move somewhere since that is where
		// the game starts
		Ghost pacman = frame.addPacMan(new Location(0, 0));
		assertTrue(pacman.get_valid_moves().size() != 0);
	}
}
