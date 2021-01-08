import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		//Creating A Map 
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		//Creating a Player
		PacMan pacman1 = frame.addPacMan(new Location(0, 0)); //Creates PacMan at location x, y
		assertEquals(true, pacman1.move());
		PacMan pacman2 = frame.addPacMan(new Location(-1, -1)); //Creates PacMan at location x, y
		assertEquals(false, pacman2.move());
		PacMan pacman3 = frame.addPacMan(new Location(40, 40)); //Creates PacMan at location x, y
		assertEquals(false, pacman3.move());
	}
	
}
