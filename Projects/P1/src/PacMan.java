import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

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
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}
		// check (x, y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y + 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}
		// check (x, y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x, this.myLoc.y - 1)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}

		/* Diagonally */

		// check (x+1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}

		// check (x-1 , y+1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}

		// check (x-1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}

		// check (x+1 , y-1)
		if (!this.myMap.getLoc(new Location(this.myLoc.x + 1, this.myLoc.y)).contains(Map.Type.WALL)) {
			validMoves.add(new Location(this.myLoc.x + 1, this.myLoc.y));
		}

		return validMoves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() {
		return false;
	}

	public JComponent consume() {
		return null;
	}
}
