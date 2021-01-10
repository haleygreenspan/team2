import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

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
		if(get_valid_moves().size() != 0){
			Random r = new Random();
			int size = get_valid_moves().size();
			int index = r.nextInt(size);
			myLoc = get_valid_moves().get(index);
			myMap.move(myName, myLoc, Map.Type.GHOST);
			return true;
		} else {
			return false;
		}
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
