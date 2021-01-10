# Project 1: PacMan
## 1. Group Members: 
 * Antonio Pancorbo 
 * Sruthi Rajarajan 
 * Bharath Hegde 
 * Xuewei Ji

## 2. Our code laying PacMan Image:
![PacMan]()

## 3. How to Run The Code 
This code could be run from the command line by using the following commands.
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```
Make sure to run these commands from inside the P1 directory
- **javac** - compiles all of the source files
- **java** - runs the StartMenu java program
- **-cp** - specifies the classpaths

## 4. Functions Explanation
### 4.1 PacMan Class
- **get_valid_moves()**
  + Type: `() -> ArrayList`

  + Function Implementation:

  + Test Description:

- **move()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses the get_valid_moves method to find a location for a Pacman to move. If the size of the ArrayList that we get from the get_valid_moves method does not equal to 0, moving to the first Location listed in the ArrayList and return true. Otherwise, return false.

  + Test Description: Using the TestPacManMove.java file to create a JUnit test to test whether the move method works well or not. In MainFrame, there is a wall in the Location(0,0). If we add a Pacman here, this Pacman could not move. There is a cookie in the Location(1,1). If we add a Pacman here, this Pacman could move. 

- **is_ghost_in_range()**
  + Type: `() -> Bool`

  + Function Implementation:

  + Test Description:

- **consume()**
  + Type: `() -> JComponent`

  + Function Implementation:

  + Test Description:

### 4.2 Ghost Class
- **get_valid_moves()**
  + Type: `() -> ArrayList<Location>`

  + Function Implementation:

  + Test Description:

- **move()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses the get_valid_moves method to find a location for a ghost to move. If the size of the ArrayList that we get from the get_valid_moves method does not equal to 0, moving to the first Location listed in the ArrayList and return true. Otherwise, return false.

  + Test Description: Using the TestGhostMove.java file to create a JUnit test to test whether the move method works well or not. In MainFrame, there is a wall in the Location(0,0). If we add a ghost here, this ghost could not move. There is a cookie in the Location(1,1). If we add a ghost here, this ghost could move. 

- **is_pacman_in_range()**
  + Type: `() -> Bool`

  + Function Implementation:

  + Test Description:

- **attack()**
  + Type: `() -> Bool`

  + Function Implementation:

  + Test Description:

### 4.3 Map Class
- **move(String name, Location loc, Type type)**
  + Type: `(String name, Location loc, Type type) -> Bool`

  + Function Implementation:

  + Test Description:

- **getLoc(Location loc)**
  + Type: `(Location loc) -> HashSet<Type>`

  + Function Implementation: For the given location argument, returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall). If the location is not in the range of dim, return a wallSet. If the field contains a key that is equal to loc, return the corresponding value. If none of the above cases is true, return an emptySet.

  + Test Description: Using the TestMapGetLoc.java file to create a JUnit test to test whether the getLoc method works well or not. Both the Location(-1, -1) and the Location(40, 40) in the MainFrame are not in the range of dim. If we test getLoc in those two locations, we should get a wallSet as a return.

- **attack(String name)**
  + Type: `(String name) -> Bool`

  + Function Implementation:

  + Test Description:

- **eatCookie(String Name)**
  + Type: `() -> JComponent`

  + Function Implementation:

  + Test Description:
