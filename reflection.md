Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent?
SantasElves is a class that has elves working in the factory. There is one elf working at a time (the one the user is interacting with), and the user can interact with the elf and the factory through the elf.
grab(): pick up item (present) from the factory and add it to the present bag
drop(): take out item (present) from the present bag and put it back in the factory
examine(): look at the item (present)
use(): reminds user that no presents can be opened (but! if you took the chocolates from the factory and ask the elf, they may share some!)
walk(): go right, left or straight in the factory
fly(): allows the elf to go to a specific coordinate, and move between the three floors (depending on the y value)
shrink(): shrinks elf size (with limit)
grow(): grows elf size (with limit)
rest(): elf resting time
undo(): reminds users that elves have short memory and cannot undo their actions
- What additional methods (if any) did you implement alongside those listed in the interface?
getName(): reminds user which elf (name) is currently at work
checkFloor(): Ask the elf to go to a certain floor depending on the int y input value
getFloor():return the floor value into a string to make it easier to return the value for fly()
- What worked, what didn't, what advice would you give someone taking this course in the future?
the additional methods I added to make sure the fly() method worked, was a little difficult. I had to ask someone for help in implementing the getFloor() method. I wish I could work more with the coordinates and set limits on how far left or how far straight the elf could walk, but it was really difficult to implement that part. However, I really had fun with this assignment because I got to think of my own topic while implementing the given Contract class. 
