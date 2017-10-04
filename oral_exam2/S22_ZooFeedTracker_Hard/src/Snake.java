import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia Mallaro
 * @see Snake
 */
public class Snake extends Animal {

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.Mice);
        }
    };

    /**
     * Snake constructor
     * @param name Snake name
     * @param location Snake location
     */
    Snake(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor
     */
    Snake() {}

    /**
     * Adds a food to the list of foods the animal eats
     * @param f Food to be added
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns the lsit of food types the animal eats
     * @return List of types of foods the animal eats
     */
    public List<Food> getFood() { return Snake.food; }

    /**
     * Returns species 
     * @return "Snake"
     */
    public String getAnimalType() { return "Snake";}
}
