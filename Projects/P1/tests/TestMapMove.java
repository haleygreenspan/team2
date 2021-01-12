import junit.framework.*;
import java.awt.Color;
import java.io.*;

import static org.junit.Assert.*;

public class TestMapMove extends TestCase {

	public void testMapMove() throws FileNotFoundException {
		// Creating A Map
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		// For instance a ghost (or anything) should be able to move to the origin
		Ghost ghost1 = frame.addGhost(new Location(1, 2), "ghost1", Color.BLACK);
		// The move to the origin should be true
		assertTrue(frame.getMap().move("ghost1", new Location(1, 1), Map.Type.GHOST));
	}
}
