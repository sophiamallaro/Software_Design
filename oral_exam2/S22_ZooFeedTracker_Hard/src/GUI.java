import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is the main GUI for the program.
 * @author Sophia Mallaro
 * @see GUI
 */
public class GUI extends JFrame {
    private JList<String> animals;
    private ArrayList<Animal> zooAnimals;
    private JButton addAnimal;
    private JButton feed;
    private JButton getGroceryList;
    private JButton getFeedingSchedule;
    private DefaultListModel<String> model;
    public JTextField animalName;
    public JComboBox animalType;
    public JTextField location;
    private JLabel nameLabel;
    private JLabel animalTypeLabel;
    private JLabel locationLabel;
    private static String[] animalTypes = {"Bear","Beaver","Dolphin","Elephant","Lion","Snake"};
    private JLabel addAnAnimalLabel;

    /**
     * This constructor sets up the GUI. It contains a list of animals, buttons to view feedings or grocery lists,
     * and an area to add additional animals.
     * @param title
     */
    GUI(String title) {
        super(title);
        setLayout(null);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        zooAnimals = new ArrayList<>();
        model = new DefaultListModel<>();
        animals = new JList<>(model);
        addAnimal = new JButton("Add Animal");
        getGroceryList = new JButton("Get Grocery List");
        getFeedingSchedule = new JButton("Get Feedings");
        feed = new JButton("Feed Animal");
        location = new JTextField("");
        animalName = new JTextField("");
        animalType = new JComboBox(animalTypes);
        addAnimal = new JButton("Add");
        animalTypeLabel = new JLabel("Species");
        nameLabel = new JLabel("Name");
        locationLabel = new JLabel("Location");
        addAnAnimalLabel = new JLabel("New Animal Information");

        add(animals);
        animals.setBounds(20, 20, 300, 400);
        add(feed);
        feed.setBounds(360, 20, 150, 25);
        add(getGroceryList);
        getGroceryList.setBounds(360, 50, 150, 25);
        add(getFeedingSchedule);
        getFeedingSchedule.setBounds(360,80,150,25);

        add(addAnAnimalLabel);
        addAnAnimalLabel.setBounds(367,130,250,25);
        add(nameLabel);
        nameLabel.setBounds(350,160,50,20);
        add(animalTypeLabel);
        animalTypeLabel.setBounds(350,185,100,20);
        add(animalName);
        animalName.setBounds(420,160,100,20);
        add(animalType);
        animalType.setBounds(420,185,100,20);
        add(locationLabel);
        locationLabel.setBounds(350,210,50,20);
        add(location);
        location.setBounds(420,210,100,20);
        add(addAnimal);
        addAnimal.setBounds(420,235,100,20);
        setVisible(true);

        addAnimal.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if(animalName.getText().equals("") || animalName.getText().equals("Enter a Name")) {
                            animalName.setText("Enter a Name");
                        }
                        else if(location.getText().equals("") || location.getText().equals("Enter a location")) {
                            location.setText("Enter a location");
                        }
                        else {
                            String selected = (String) animalType.getSelectedItem();
                            Animal toAdd;
                            switch (selected) {
                                //Animal toAdd;
                                case "Bear":
                                    toAdd = new Bear(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                                case "Beaver":
                                    toAdd = new Beaver(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                                case "Dolphin":
                                    toAdd = new Dolphin(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                                case "Elephant":
                                    toAdd = new Elephant(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                                case "Lion":
                                    toAdd = new Lion(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                                case "Snake":
                                    toAdd = new Snake(animalName.getText(), location.getText());
                                    zooAnimals.add(toAdd);
                                    model.addElement(animalName.getText());
                                    break;
                            }
                        }
                    }
                }
        );
        getGroceryList.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        GroceryList list = new GroceryList(zooAnimals);
                        list.setVisible(true);
                    }
                }
        );
        getFeedingSchedule.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        FeedingSchedules list = new FeedingSchedules(zooAnimals);
                        list.setVisible(true);
                    }
                }
        );

        feed.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimals) {
                            if(animal.getAnimalName().equals(animals.getSelectedValue())) {
                                Feeding feeding = new Feeding(animal);
                                feeding.setVisible(true);
                            }
                        }

                    }
                }
        );
    }

}
