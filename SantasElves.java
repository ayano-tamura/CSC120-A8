import java.util.ArrayList;

public class SantasElves implements Contract{
    ArrayList<String> presentBag = new ArrayList<String>();
    private String elfName;
    private int currentFloor =1; //starting floor for all elves
    double elfSize = 10;

    public SantasElves(String elfName){
        this.elfName = elfName;
        System.out.println("Hi! I'm "+ this.elfName + ", and I will be helping Santa with the presents today!");
    }

    public String getName(){
        System.out.println(this.elfName + " is currently on duty");
        return this.elfName;
    }

    /**
     * Ask Elf to pick up an item from the factory and add it to the present bag
     * @param item item to grab and add to present bag
     */
    public void grab(String item){
        presentBag.add(item);
        System.out.println(item + " has been added to the present bag!");
    }
    
    /**
     * Ask elf to remove an item from the present bag and put it back to the factory
     * @param item item to drop from the present bag
     * @return item that was removed/not removed
     */
    public String drop(String item){
        if (!presentBag.contains(item)){
            throw new RuntimeException("That item isn't in the present bag!");
        }
        presentBag.remove(item);
        System.out.println("Your elf has removed " + item + " from the present bag!");
        return item;
    }

    /**
     * Ask elf to examine an item in the factory or already in the present bag
     * @param item the item to examine
     */
    public void examine(String item){
        System.out.println("Examining " + item + "... This looks like a cool present!");
    }


    /**
     * Elf reminder that we can't use anything inside the present bag, but you can ask for chocolate if it's in the bag
     * @param item item to try to use
     */
    public void use(String item){
        if (!presentBag.contains(item)){
            throw new RuntimeException("I cannot find that item in the present bag, you need to add it first!");
        } else if (presentBag.contains(item)){
            if (item.toLowerCase().contains("chocolate")){
                System.out.println("Shhh! Here's some chocolate for you, don't tell santa about it though!");
            }else{
                System.out.println("We can't open these presents remember? They're wrapped for the children!!");
            }
        }
    }

    /**
     * Allow the elf to walk in a given direction (left, right, or straight)
     * @param direction direction of elf walking 
     * @return ture if the elf can walk in a direction without issues
     */
    public boolean walk(String direction){
        if (direction.toLowerCase().equals("left")){
            System.out.println("Turning left...");
            return true;
        } else if (direction.toLowerCase().equals("right")){
            System.out.println("Turning right...");
            return true;
        } else if (direction.toLowerCase().equals("straight")){
            System.out.println("Walking straight...");
            return true;
        } else {
            throw new RuntimeException("You can walk left, right, or straight. If you want to explore upstairs, use the fly() feature!");
        }
    }

    /**
     * ask elf to move to a coordinate inside the factory, move between the three floor factory.
     * @param x x coordinate to move 
     * @param y y coordinate to move between floors (up/down)
     * @return true if the elf can fly to the new location
     */
    public boolean fly(int x, int y){
        int floor = checkFloor(y);
        if (floor != currentFloor){
            currentFloor = floor;
            System.out.println("You are now on the " + getFloor(currentFloor) + " floor of Santa's factory!");
        } else {
            System.out.println("You are already on the " + getFloor(currentFloor) + " floor! Your new coordinates are" + x + ", " + y);
        }
        return true;
    }

    /**
     * Ask the elf to go to a certain floor depending on the int y input value
     * @param y the value to check if the elf will go to the second, third, or remain on the first floor
     * @return respective floor numbers
     */
    private int checkFloor(int y){
        if (y > 10){
            return 3;
        } else if (y > 6){
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * return the floor value into a string to make it easier to return the value
     * @param number number to convert to string type
     * @return converted string
     */
    private String getFloor(int number){
        String[] floors = {"first", "second", "third"};
        if (number >= 1 && number <=3){
            return floors[number - 1];
        } else {
            return Integer.toString(number);
        }
    }

    /**
     * Shrink elf size so elf can explore more hidden presents! (size has limit though)
     */
    public Number shrink(){
        if (elfSize > 5){
            elfSize -= 0.5;
            System.out.println(this.elfName + " has shrunk by 0.5cm and is now "+ elfSize +"cm!");
            return elfSize;
        } else {
            throw new RuntimeException(this.elfName + " can no longer shrink beyond this size!");
        }
    }
    
    /**
     * Grow elf size so elf can pick up more presents (size has limit though)
     */
    public Number grow(){
        if (elfSize < 13){
            elfSize += 0.5;
            System.out.println(this.elfName + " has grown by 0.5cm and is now "+ elfSize +"cm!");
            return elfSize;
        } else {
            throw new RuntimeException(this.elfName + " can no longer grow beyond this size!");
        }
    }

    /**
     * Command for elf to take a break
     */
    public void rest(){
        System.out.println("It's important for elves to rest too! Your elf is resting...");
    }

    /**
     * Reminds users that elves have short term memory and cannot work backwards.
     */
    public void undo(){
        System.out.println("Elves have super short term memory and cannot undo actions. What can you do about it, they're just cute elves afterall!");
    }

    // public static void main(String[] args) {
    //     SantasElves elf = new SantasElves("greg");
    //     System.out.println(elf);
    //     elf.getName();
    //     elf.grab("chocolate");
    //     elf.use("chocolate");
    //     elf.walk("left");
    //     elf.fly(2,8);
    //     elf.shrink();
    //     elf.grow();
    // }
}

