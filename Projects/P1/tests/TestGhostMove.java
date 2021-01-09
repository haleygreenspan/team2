import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		//Creating A Map 
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		//Creating a Player
		Ghost ghost1 = frame.addGhost(new Location(0, 0), "name1", Color.red); //Creates a red ghost named "name" at location x,y
		assertEquals(false, ghost1.move());
		Ghost ghost2 = frame.addGhost(new Location(1, 1), "name2", Color.red); //Creates a red ghost named "name" at location x,y
		assertEquals(true, ghost2.move());

	}
}
