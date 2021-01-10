# Project 1: PacMan
## 1. Group Members: 
 * Antonio Pancorbo 
 * Sruthi Rajarajan 
 * Bharath Hegde 
 * Xuewei Ji

## 2. Our Code Playing PacMan Image:
![PacMan](https://github.com/cmsc388T/team2/blob/main/Projects/P1/tests/image.png)

## 3. How to Run The Code
### 3.1 Run the Game
This code could be run from the command line by using the following commands.
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

### 3.2 Run the Tests
```bash
javac -cp "tests/junit-4.10.jar:src/:tests/" src/*.java tests/*.java
java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore testname
ex: java -cp "tests/junit-4.10.jar:src/:tests/" org.junit.runner.JUnitCore TestGhostMove
```
Make sure to run these commands from inside the P1 directory

## 4. Functions Explanation
### 4.1 PacMan Class
- **get_valid_moves()**
  + Type: `() -> ArrayList`

  + Function Implementation: It gets all possible moves that pacman can move. This is implemented by checking horizontally, vertically, and diagonally by one unit. 

  + Test Description: The test shows that at (1,1) the pacman can indeed move somewhere. 

- **move()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses the get_valid_moves method to find a location for a Pacman to move. If the size of the ArrayList that we get from the get_valid_moves method does not equal to 0, moving to the first Location listed in the ArrayList and return true. Otherwise, return false.

  + Test Description: Using the TestPacManMove.java file to create a JUnit test to test whether the move method works well or not. In MainFrame, there is a wall in and around the Location(40,40). If we add a Pacman here, this Pacman could not move. There is a cookie in the Location(1,1). If we add a Pacman here, this Pacman could move. 

- **is_ghost_in_range()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses a double/nested for loop, using myMap.getLoc() to check if any (x, y) coordinate within a radius of 1 from PacMan has a HashSet of entities that contains a GHOST. If so, then there is a ghost in range, and true is returned. Otherwise, false is returned.

  + Test Description: Using a double/nested for loop, the method first places PacMans in every location within a radius of 1 around a ghost. It makes sure that all of these PacMans report that a ghost is in range. Then, it places a PacMan at the corner (1, 1) and a ghost at (1, 2) to make sure there are no problems when the PacMan checks walls around it. There is also a separate test method that places a PacMan and a ghost just outside of range from each other and ensures that the PacMan reports that there is no ghost in range. This method also places a PacMan in the corner (1, 1) again to make sure that checking walls is not a problem, and that the PacMan still reports that there is no ghost found.
  
- **consume()**
  + Type: `() -> JComponent`

  + Function Implementation: This method uses the getLoc method from the Map.java file to obtain the current location pf Pacman and checks if there is
  a cookie in that location. If there is no cookie, then the method returns null or else it calls on the eatCookie method from the Map.java file to consume the cookie.

  + Test Description: This test creates a new frame along with two Pacmans, p1 and p2 respectively. P1 is placed in location (0,0) where there is a wall. Since there is on cookie at location (0,0), the pacman named p1 will not be able to consume the cookie and thus the consume method should return null. P2 is placed in location (1,1) where there is a cookie and when the consume method is called, it should not return null. 

### 4.2 Ghost Class
- **get_valid_moves()**
  + Type: `() -> ArrayList<Location>`

  + Function Implementation: It gets all possible moves that a ghost can move. This is implemented by checking horizontally, vertically, and diagonally by one unit. 

  + Test Description: The test shows that at (1,1) the ghost can indeed move somewhere. 


- **move()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses the get_valid_moves method to find a location for a ghost to move. If the size of the ArrayList that we get from the get_valid_moves method does not equal to 0, moving to the first Location listed in the ArrayList and return true. Otherwise, return false.

  + Test Description: Using the TestGhostMove.java file to create a JUnit test to test whether the move method works well or not. In MainFrame, there is a wall in and around the Location(40,40). If we add a ghost here, this ghost could not move. There is a cookie in the Location(1,1). If we add a ghost here, this ghost could move. 

- **is_pacman_in_range()**
  + Type: `() -> Bool`

  + Function Implementation: Similar to PacMan.is_ghost_in_range(). This method uses a double/nested for loop, using myMap.getLoc() to check if any (x, y) coordinate within a radius of 1 from the ghost has a HashSet of entities that contains PACMAN. If so, then PacMan in range, and true is returned. Otherwise, false is returned.

  + Test Description: Using a double/nested for loop, the method first places ghosts in every location within a radius of 1 around a PacMan. It makes sure that all of these ghosts report that PacMan is in range. Then, it places a ghost at the corner (1, 1) and a PacMan at (1, 2) to make sure there are no problems when the ghost checks walls around it. There is also a separate test method that places a ghost and a PacMan just outside of range from each other and ensures that the ghost reports that there is no PacMan in range. This method also places a ghost in the corner (1, 1) again to make sure that checking walls is not a problem, and that the ghost still reports that there is no PacMan found.

- **attack()**
  + Type: `() -> Bool`

  + Function Implementation: This method uses the is_pacman_in_range method to check is a pacman is nearby. If pacman is nearby, then the function calls
  the attack method from the Map.java file. If pacman is not nearby, then it returns false.

  + Test Description: A new frame is created along with a ghost and pacman. The ghost is initialized to be at location(2,2) and the pacman at location(1,2). Since the pacman is range of the ghost, the ghost should be able to attack the pacman and return true.

### 4.3 Map Class
- **move(String name, Location loc, Type type)**
  + Type: `(String name, Location loc, Type type) -> Bool`

  + Function Implementation: It first gets the old location and updated the new location and component to the new location. Using the old location from before it removes the type present in the old location and moves it to the new location. 

  + Test Description: The test asserts that a ghost can indeed move from (1,2) to (1,1).

- **getLoc(Location loc)**
  + Type: `(Location loc) -> HashSet<Type>`

  + Function Implementation: For the given location argument, returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall). If the location is not in the range of dim, return a wallSet. If the field contains a key that is equal to loc, return the corresponding value. If none of the above cases is true, return an emptySet.

  + Test Description: Using the TestMapGetLoc.java file to create a JUnit test to test whether the getLoc method works well or not. Both the Location(-1, -1) and the Location(40, 40) in the MainFrame are not in the range of dim. If we test getLoc in those two locations, we should get a wallSet as a return.

- **attack(String name)**
  + Type: `(String name) -> Bool`

  + Function Implementation: This method first checks locations.containsKey(name) to make sure there actually is an entity with the provided name. If so, then it uses locations.get(name) and getLoc() to get the HashSet of all objects at the location the entity with the provided name is at. The method then checks to make sure a GHOST is contained in this HashSet (to make sure there actually is a ghost to be controlled). If this check also passes, then a temporary Ghost object is instantiated, and .is_pacman_in_range() is run on it. If .is_pacman_in_range() returns true, then PacMan is range of this ghost, so the gameOver flag is set to true and the method returns true. If any of these checks fail, then the method just returns false without changing the gameOver flag.

  + Test Description: First, a PacMan and ghost within range of each other are added, and the test ensures that Map.attack() returns true when controlling the ghost, and that Map.isGameOver() returns true as well afterwards. Another test method tries to call Map.attack() with a non-existent ghost name, as well as the name "wall", to make sure none of those attacks work and also that the game is not over afterwards. Another test method places a PacMan and ghost just outside of range of each other, and makes sure that Map.attack() fails when called on the ghost, and that the game is not over afterwards.

  - **eatCookie(String name)**
  + Type: `() -> JComponent`

  + Function Implementation: This method checks if the 'locations' hashmap contains the name of the cookie passed in. If it is not in the locations map, then this eatCookie method will also return null. If it is in the locations hashmap, then other fields are updated. A string is created for the name of the cookie using the location. The cookie type is removed from the 'field' hashmap. Then the location is removed from the 'location' hashmap. The 'cookies' integer is incremented by 1 to indicate that a cookie has been consumed. Then, the cookie is removed from the 'components' hashmap.

  + Test Description: A new frame is created and two pacmans named p1 and p2 are added. Pacman p1 is added to location (0,0) where there is a wall and thus when eatCookie is called, it should return null. Pacman p2 is added to location (1,1) where there is a cookie and thus should not return null when the eatCookie method is called.
