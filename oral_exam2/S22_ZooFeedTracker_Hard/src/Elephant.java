import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia Mallaro
 * @see Elephant
 */
public class Elephant extends Animal{

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.Hay);
            add(Food.Peanuts);
        }
    };

    /**
     * Elephant with name and location
     * @param name Elephant name
     * @param location Elephant location
     */
    Elephant(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor
     */
    Elephant() {}

    /**
     * Add food to the food types Elephants will eat
     * @param f Food to add
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns types of food the elephants eat
     * @return List of foods
     */
    public List<Food> getFood() { return Elephant.food; }

    /**
     * Returns the name of the species
     * @return "Elephant"
     */
    public String getAnimalType() { return "Elephant";}
}
