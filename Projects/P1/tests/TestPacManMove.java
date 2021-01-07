import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {
	/*
	@Before
	public void setUp() throws Exception {
	}
   
	@After
	public void tearDown() throws Exception {
	}
	
	@Test */
	public void testPacManMove() throws FileNotFoundException{
		//Creating A Map 
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		//Creating a Player
		PacMan pacman = frame.addPacMan(new Location(0, 0)); //Creates PacMan at location x, y
		assertEquals(true, pacman.move());
	}
   
	/*
	@Test
	public void testPacManMove1() throws FileNotFoundException{
	 
	} */
   
}
