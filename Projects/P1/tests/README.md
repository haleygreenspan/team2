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

  + Function Implementation: This method uses the getLoc method from the Map.java file to obtain the current location pf Pacman and checks if there is
  a cookie in that location. If there is no cookie, then the method returns null or else it calls on the eatCookie method from the Map.java file to consume the cookie.

  + Test Description: This test creates a new frame along with two Pacmans, p1 and p2 respectively. P1 is placed in location (0,0) where there is a wall. Since there is on cookie at location (0,0), the pacman named p1 will not be able to consume the cookie and thus the consume method should return null. P2 is placed in location (1,1) where there is a cookie and when the consume method is called, it should not return null. 

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

  + Function Implementation: This method uses the is_pacman_in_range method to check is a pacman is nearby. If pacman is nearby, then the function calls
  the attack method from the Map.java file. If pacman is not nearby, then it returns false.

  + Test Description: A new frame is created along with a ghost and pacman. The ghost is initialized to be at location(2,2) and the pacman at location(1,2). Since the pacman is range of the ghost, the ghost should be able to attack the pacman and return true.

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

  + Function Implementation: This method calls on the consume method from the Pacman class and checks if that methods does not return null. If the consume method returns null, then this eatCookie method will also return null. If it does not return null, it indicates that a cookie has been consumed. If that is the case, the cookie type is removed from the 'field' hashmap. Then the location is removed from the 'location' hashmap. The 'cookies' integer is incremented by 1 to indicate that a cookie has been consumed. Then, the cookie is removed from the 'components' hashmap.

  + Test Description: A new frame is created and two pacmans named p1 and p2 are added. Pacman p1 is added to location (0,0) where there is a wall and thus when eatCookie is called, it should return null. Pacman p2 is added to location (1,1) where there is a cookie and thus should not return null when the eatCookie method is called.
