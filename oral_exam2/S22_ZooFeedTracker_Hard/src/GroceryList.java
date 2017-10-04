import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class creates and manages the GUI used for viewing the grocery list
 * @author Sophia Mallaro
 * @see GroceryList
 */
public class GroceryList extends JFrame {
    private JButton all;
    private JButton bear;
    private JButton beaver;
    private JButton dolphin;
    private JButton elephant;
    private JButton lion;
    private JButton snake;
    private JButton clear;
    private JTextArea list;
    private int[] totals;

    /**
     * This GUI has buttons for selecting the grocery lists of a specific species or all animals.
     * When a button is selected, the program searches through all animals to find the animals of the
     * selected species. It calculates their feeding totals and displays them.
     * @param zooAnimalList List of Zoo Animals
     */

    GroceryList(ArrayList<Animal> zooAnimalList) {
        setLayout(null);
        setSize(500,400);
        setLocationRelativeTo(null);

        all = new JButton("All Species");
        bear = new JButton("Bears");
        beaver = new JButton("Beavers");
        dolphin = new JButton("Dolphins");
        elephant = new JButton("Elephants");
        lion = new JButton("Lions");
        snake = new JButton("Snakes");
        clear = new JButton("Clear");
        list = new JTextArea();
        totals = new int[Food.values().length];
        list.setEditable(false);

        add(list);
        list.setBounds(20,20,300,300);
        add(bear);
        bear.setBounds(350,20,100,20);
        add(beaver);
        beaver.setBounds(350,50,100,20);
        add(dolphin);
        dolphin.setBounds(350,80,100,20);
        add(elephant);
        elephant.setBounds(350,110,100,20);
        add(lion);
        lion.setBounds(350,140,100,20);
        add(snake);
        snake.setBounds(350,170,100,20);
        add(all);
        all.setBounds(350,200,100,20);
        add(clear);
        clear.setBounds(350,230,100,20);


        all.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            for(FeedAnimal feeding : animal.getFeedings()) {
                                totals[feeding.getType().getNum()] += feeding.getAmount();
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }
                }
        );

        bear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Bears:\n");
                            if(animal instanceof Bear) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }

                }
        );


        beaver.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Beaver:\n");
                            if(animal instanceof Beaver) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }

                }
        );
        dolphin.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Dolphins:\n");
                            if(animal instanceof Dolphin) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }

                }
        );
        elephant.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Elephants:\n");
                            if(animal instanceof Elephant) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }

                }
        );
        lion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Lions:\n");
                            if(animal instanceof Lion) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }
                }
        );
        snake.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        for(Animal animal : zooAnimalList) {
                            list.append("Snakes:\n");
                            if(animal instanceof Snake) {
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    totals[feeding.getType().getNum()] += feeding.getAmount();
                                }
                            }
                        }
                        int i=0;
                        for(Food food : Food.values()) {
                            list.append(food.getName() + ": " + totals[i] + " " + food.getUnits() + "\n");
                            i++;
                        }
                        list.append("\n");
                        list.append("\n");
                        for(int k=0; k<totals.length; k++) {
                            totals[k]=0;
                        }
                    }

                }
        );
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.setText("");

                    }
                }
        );
    }
}

