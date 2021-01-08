import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie {
	
	public void testMapEatCookie() {
		// Creating A Map
		NoFrame frame = new NoFrame();

		PacMan p1 = frame.addPacMan(new Location(0,0));
		assertTrue(p1.eatCookie == null);

		PacMan p2 = frame.addPacMan(new Location(1,1));
		assertTrue(p2.consume() != null);
	}
}
