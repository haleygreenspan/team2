import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException {
		// Creating A Map
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display

		// A ghost at location 0,0 should be able to move somewhere since that is where
		// the game starts
		Ghost ghost1 = frame.addGhost(new Location(0, 0), "ghost1", Color.BLACK);
		assertTrue(ghost1.get_valid_moves().size() != 0);
	}
}
