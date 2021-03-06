import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

public class PacMan {

	String myName;
	Location myLoc;
	Map myMap;
	Location shift;

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	/*
	 * This method returns all the valid moves that PacMan can make given his
	 * current position.
	 */
	public ArrayList<Location> get_valid_moves() {
		// instantiate the output array of valid moves
		ArrayList<Location> validMoves = new ArrayList<Location>();

		/* Horizontal and Vertical */

		// check (x+1 , y)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}
		// check (x-1, y)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 1, this.myLoc.y));
		}
		// check (x, y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y + 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x, this.myLoc.y + 1));
		}
		// check (x, y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y - 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x, this.myLoc.y - 1));
		}

		/* Diagonally */

		// check (x+1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y + 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y + 1));
		}

		// check (x-1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 1, this.myLoc.y + 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 1, this.myLoc.y + 1));
		}

		// check (x-1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x - 1, this.myLoc.y - 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x - 1, this.myLoc.y - 1));
		}

		// check (x+1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y - 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y - 1));
		}

		return validMoves;
	}

	public boolean move() {
		if (get_valid_moves().size() != 0) {
			Random r = new Random();
			int size = get_valid_moves().size();
			int index = r.nextInt(size);
			myLoc = get_valid_moves().get(index);
			myMap.move(myName, myLoc, Map.Type.PACMAN);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines whether there is a ghost within a 1 radius attack range of pacman
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
		if (myMap.getLoc(myLoc).contains(Map.Type.COOKIE)) {
			return myMap.eatCookie(myName);

		} else {
			return null;
		}
	}
}
