/**
 * Abstract class representing an animal
 * @author Sophia Mallaro
 * @see Animal
 */

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    private String name;
    //private String species;
    private String location;
    private ArrayList<Food> foodTypes;
    private ArrayList<FeedAnimal> feedings;

    /**
     * Constructor with name and location
     * @param name Animal Name
     * @param location Animal Location
     */
    Animal(String name, String location) {
        this.name = name;
        this.location = location;
        feedings = null;
        feedings = new ArrayList<FeedAnimal>();
    }
    /**
     * Dummy animal constructor
     */
    Animal() {
        feedings = new ArrayList<FeedAnimal>();
    }

    /**
     * Gives the animal's species
     * @return Animal Species
     */
    public abstract String getAnimalType();

    /**
     * Gives types of food the animals can eat
     * @return List of food types the animal can eat
     */
    public abstract List<Food> getFood();

    /**
     * Returns animal's name
     * @return String of animal name
     */
    public String getAnimalName() {
        return name;
    }

    /**
     * Returns the animals location
     * @return Animal location
     */
    public String getAnimalLocation() {
        return location;
    }

    /**
     * Returns feedings
     * @return List of feedings
     */
    public List<FeedAnimal> getFeedings() {return feedings; }

    /**
     * Adds a feeding the the animal's feeding record
     * @param feeding Feeding
     */
    public void feed(FeedAnimal feeding) {
        feedings.add(feeding);
    }


}
