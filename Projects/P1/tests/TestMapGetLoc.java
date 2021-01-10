import junit.framework.*;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;


public class TestMapGetLoc extends TestCase{
	
	//private HashSet<Map.Type> cookieSet;
	public HashSet<Map.Type> wallSet;

	public void testMapGetLoc() throws FileNotFoundException {
		//Creating A Map 
		MainFrame frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized
		//cookieSet = new HashSet<Map.Type>();
		wallSet = new HashSet<Map.Type>();
		//cookieSet.add(Map.Type.COOKIE);
		wallSet.add(Map.Type.WALL);
		
		HashSet<Map.Type> loc1 = frame.getMap().getLoc(new Location(-1, -1));
		assertEquals(wallSet, loc1);
		
		HashSet<Map.Type> loc2 = frame.getMap().getLoc(new Location(40, 40));
		assertEquals(wallSet, loc2);
		
		//ghost is randomly added, not sure if it appears in a specific location.
		//HashSet<Map.Type> loc3 = frame.getMap().getLoc(new Location(1, 2));
		//assertEquals(cookieSet, loc3);
	}
}

