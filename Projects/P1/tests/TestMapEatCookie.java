import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;
public class TestMapEatCookie extends TestCase{
	
	public void testMapEatCookie() throws FileNotFoundException {
		// Creating A Map
		NoFrame frame = new NoFrame();

		PacMan p1 = frame.addPacMan(new Location(0,0));
		assertTrue(frame.getMap().eatCookie("pacman") == null);

		PacMan p2 = frame.addPacMan(new Location(1,1));
		assertTrue(frame.getMap().eatCookie("pacman") != null);
	}
}
