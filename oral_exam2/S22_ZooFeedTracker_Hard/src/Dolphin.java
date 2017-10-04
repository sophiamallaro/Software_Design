import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia Mallaro
 * @see Dolphin
 */
public class Dolphin extends Animal {

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.Bass);
            add(Food.Shrimp);
        }
    };

    /**
     * Constructor with name and location parameters
     * @param name Dolphin name
     * @param location Dolphin location
     */
    Dolphin(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor
     */
    Dolphin() {}

    /**
     * Adds food to Dolphin's food list
     * @param f food type to add
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns list of food types
     * @return list of food types the dolphin will eat
     */
    public List<Food> getFood() { return Dolphin.food; }

    /**
     * Species name
     * @return Dolphin
     */
    public String getAnimalType() { return "Dolphin";}
}
