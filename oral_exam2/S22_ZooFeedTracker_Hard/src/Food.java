/**
 * Enum representing types of food
 * @author Sophia Mallaro
 * @see Food
 */
public enum Food {
    ZebraMeat("Zebra Meat", "lbs", 0),
    Peanuts("Peanuts","lbs", 1),
    Bass("Bass", "lbs", 2),
    Shrimp("Shimp", "lbs", 3),
    Mice("Mice Meat", "# mice", 4),
    ElkMeat("Elk Meat", "lbs", 5),
    Hay("Hay","lbs", 6);

    private String name;
    private String units;
    private int num;

    Food(String name, String units, int num) {
        this.name = name;
        this.units = units;
        this.num = num;
    }

    /**
     * Gets the name of the food as a string
     * @return Food name
     */
    public String getName() {return name; }

    /**
     * Gets the units of the food as a string
     * @return String units
     */
    public String getUnits() { return units; }

    /**
     * Gets the index of the food as a number
     * @return int number
     */
    public int getNum() { return num; }


}
