import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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
	 * Determines whether pacman is within a 1 radius attack
	 * range of this ghost
	 * 
	 * @return true if this ghost is in range of pacman, and false if not
	 */
	public boolean is_pacman_in_range() {
		// Iterate through all x coordinates within a radius of 1
		for (int x = myLoc.x - 1; x <= myLoc.x + 1; x++) {
			// Iterate through all y coordinates within a radius of 1
			for (int y = myLoc.y - 1; y <= myLoc.y + 1; y++) {

				// Get a HashSet of all the objects at the current
				// (x, y) coordinates being checked
				Location loc = new Location(x, y);

				HashSet<Map.Type> objects = myMap.getLoc(loc);

				// If pacman is at this location, then this ghost
				// is in range of pacman
				if (objects.contains(Map.Type.PACMAN)) {
					return true;
				}
			}
		}

		// If none of the coordinates checked had pacman, this ghost is not
		// in range of pacman
		return false;
	}

	public boolean attack() {
		return false;
	}
}
