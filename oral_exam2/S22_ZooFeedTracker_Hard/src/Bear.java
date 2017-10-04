import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a bear
 * @author Sophia Mallaro
 * @see Bear
 */
public class Bear extends Animal {

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.ElkMeat);
        }
    };

    /**
     * Constructor with name and location
     * @param name Bear name as a string
     * @param location
     */
    Bear(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor for a bear
     */
    Bear() {}

    /**
     * Adds a food to the types of food the bear eats
     * @param f
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns the list of food bears eat
     * @return List of food types
     */
    public List<Food> getFood() { return Bear.food; }

    /**
     * Returns the species type
     * @return "Bear"
     */
    public String getAnimalType() { return "Bear";}
}
