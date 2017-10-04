import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a beaver
 * @author Sophia mallaro
 * @see Beaver
 */
public class Beaver extends Animal {

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.Bass);
            add(Food.Hay);
        }
    };

    /**
     * Beaver constructor with name and location
     * @param name Beaver name
     * @param location Beaver location
     */
    Beaver(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor
     */
    Beaver() { super(); }

    /**
     * Add food to the beaver food types
     * @param f Food type to add
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns list of food types
     * @return
     */
    public List<Food> getFood() { return Beaver.food; }

    /**
     * Beaver species name
     * @return returns "Beaver"
     */
    public String getAnimalType() { return "Beaver";}

}
