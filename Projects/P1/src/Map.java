import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

	public enum Type {
		EMPTY, PACMAN, GHOST, WALL, COOKIE
	}

	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components;
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet;
	private HashSet<Type> wrongSet;

	private int cookies = 0;

	public Map(int dim) {
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}

	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc))
			field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	/*
	 * The method takes a name, location, and type and put the object specified by
	 * the name at the location. If the function is able to successfull move the
	 * object it returns true, otherwise it returns false.
	 */

	public boolean move(String name, Location loc, Type type) {
		try {
			// get the old location
			Location old = locations.get(name);
			// put new location
			locations.put(name, loc);
			// set new location for component
			components.get(name).setLocation(loc.x, loc.y);
			// remove the old location and move it to new location
			field.get(old).remove(type);
			field.get(loc).add(type);
			// if all goes fine return true
			return false; 
		} catch (Exception e) {
			return false;
		}
	}

	public HashSet<Type> getLoc(Location loc) {
		// wallSet and emptySet will help you write this method
		if (loc.x < 0 || loc.y < 0 || loc.x > dim || loc.y > dim) {
			return emptySet;
		} else if (field.containsKey(loc)) {
			wrongSet.add(Type.EMPTY);
			wrongSet.add(Type.WALL);
			return wrongSet;
		} else {
			return wallSet;
		}
	}

	/**
	 * Attempts to make the ghost of the specified name attack pacman. If the attack
	 * is successful, the game is ended
	 * 
	 * @param name the name of the ghost that should try to perform the attack
	 * @return true if the attack is successful, and false if not
	 */
	public boolean attack(String name) {
		// Ensure this name is valid
		if (locations.containsKey(name)) {
			// Get all objects at ${name}'s locaton
			Location loc = locations.get(name);

			HashSet<Type> objects = getLoc(locations.get(name));

			// Make sure that there actually is a ghost at this location.
			// It is possible that a name such as "pacman" or "wall" was
			// given instead of an actual ghost's name
			if (objects.contains(Type.GHOST)) {
				// Create a temporary Ghost object to represent
				// the ghost at this location
				Ghost temp = new Ghost(name, loc, this);

				// Try to make the ghost attack pacman. End the game
				// if the attack was successful
				if (temp.is_pacman_in_range()) {
					return true;
				}
			}
		}

		// If the name was invalid, the name referred to a non-ghost entity, or
		// the attack failed, just return false
		return false;
	}

	public JComponent eatCookie(String name) {

		if (locations.containsKey(name)) {
			Location loc = locations.get(name);
			String str_name = "tok_x" + loc.x + "_y" + loc.y;

			field.get(loc).remove(Type.COOKIE);
			locations.remove(str_name);
			cookies++;
			return components.remove(str_name);
		} else {
			return null;
		}

		// update locations, components, field, and cookies
		// the id for a cookie at (10, 1) is tok_x10_y1
	}
}
