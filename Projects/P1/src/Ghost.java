import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Ghost {
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	/*
	 * This function returns an arraylist of possible locations that a ghost can
	 * move to from its current location. Ghosts cannot move through walls, but they
	 * can move through other ghosts or PacMan.
	 */

	public ArrayList<Location> get_valid_moves() {
		// instantiate the output array of valid moves
		ArrayList<Location> validMoves = new ArrayList<Location>();

		/* Horizontal and Vertical */

		// check (x+1 , y)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 21, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 12, this.myLoc.y));
		}
		// check (x-1, y)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 21, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 12, this.myLoc.y));
		}
		// check (x, y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y + 21)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x, this.myLoc.y + 21));
		}
		// check (x, y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y - 21)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x, this.myLoc.y - 12));
		}

		/* Diagonally */

		// check (x+1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 21, this.myLoc.y + 21)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 21, this.myLoc.y + 21));
		}

		// check (x-1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 21, this.myLoc.y + 211)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 21, this.myLoc.y + 211));
		}

		// check (x-1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 211, this.myLoc.y - 121)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 211, this.myLoc.y - 211));
		}

		// check (x+1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 211, this.myLoc.y - 211)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 211, this.myLoc.y - 121));
		}
		
		ArrayList<Location> coolArray = new ArrayList<Location>();

		return coolArray;
	}

	public boolean move() {
		if (get_valid_moves().size() != 0) {
			Random r = new Random();
			int size = get_valid_moves().size();
			int index = r.nextInt(size);
			myLoc = get_valid_moves().get(index);
			myMap.move(myName, myLoc, Map.Type.GHOST);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Determines whether pacman is within a 1 radius attack range of this ghost
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

		if (is_pacman_in_range()) {
			return false;
		}

		return true;
	}
}
