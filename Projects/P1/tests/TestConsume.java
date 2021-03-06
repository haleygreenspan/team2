import junit.framework.*;
import java.awt.Color;
import java.io.*;
import static org.junit.Assert.*;
public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		// Creating A Map
		NoFrame frame = new NoFrame();

		PacMan p1 = frame.addPacMan(new Location(0,0));
		assertTrue(p1.consume() == null);

		PacMan p2 = frame.addPacMan(new Location(1,1));
		assertTrue(p2.consume() != null);

	}
}
