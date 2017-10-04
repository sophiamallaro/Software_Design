import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia Mallaro
 * @see Lion
 */
public class Lion extends Animal {

    private static List<Food> food = new ArrayList<Food>() { //http://stackoverflow.com/questions/12670398/how-to-initialize-static-arraylistmyclass-in-one-line
        {
            add(Food.ZebraMeat);
            add(Food.ElkMeat);
        }
    };

    /**
     * Lion constructor
     * @param name Lion name
     * @param location Lion location
     */
    Lion(String name, String location) {
        super(name, location);
    }

    /**
     * Dummy constructor
     */
    Lion() {}

    /**
     * Add food to the list of foods lion eat
     * @param f Food type to add
     */
    public static void addFood(Food f) {
        food.add(f);
    }

    /**
     * Returns list of foods the lions eat
     * @return List of foods
     */
    public List<Food> getFood() { return Lion.food; }

    /**
     * Animal species name
     * @return "Lion"
     */
    public String getAnimalType() { return "Lion";}
}
