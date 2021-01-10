import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		
		Ghost cloakG = frame.addGhost(new Location (2,2), "Cloak", Color.WHITE);
		PacMan p1 = frame.addPacMan(new Location (1,2));
		assertTrue(cloakG.attack(p1));
		
	}
}
