import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		return false;
	}

	/**
	 * Determines whether there is a ghost within a 1 radius attack
	 * range of pacman
	 * 
	 * @return true if a ghost is in range of pacman, and false if not
	 */
	public boolean is_ghost_in_range() {
		// Iterate through all x coordinates within a radius of 1
		for (int x = myLoc.x - 1; x <= myLoc.x + 1; x++) {
			// Iterate through all y coordinates within a radius of 1
			for (int y = myLoc.y - 1; y <= myLoc.y + 1; y++) {

				// Get a HashSet of all the objects at the current
				// (x, y) coordinates being checked
				Location loc = new Location(x, y);

				HashSet<Map.Type> objects = myMap.getLoc(loc);

				// If there is a ghost at this location, then a ghost
				// is in range of pacman
				if (objects.contains(Map.Type.GHOST)) {
					return true;
				}
			}
		}

		// If none of the coordinates checked had a ghost, there is no
		// ghost in range of pacman
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
