/**
 * This class represents a feeding. It stores the information associated.
 * @author Sophia Mallaro
 * @see FeedAnimal
 */
public class FeedAnimal {
    private Food type;
    private int amount;

    /**
     * Constructor
     * @param type Type of food
     * @param amount Amount of food
     */
    public FeedAnimal(Food type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Returns the type of food
     * @return Type of food
     */
    public Food getType() {
        return type;
    }

    /**
     * Sets the type of food
     * @param type Type of food
     */
    public void setType(Food type) {
        this.type = type;
    }

    /**
     * Returns the amount of food
     * @return amount of food
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount of food
     * @param amount amount of food
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
