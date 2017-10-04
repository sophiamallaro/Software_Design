import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class creates feeding schedules for the animals.
 * @author Sophia Mallaro
 * @see FeedingSchedules
 */
public class FeedingSchedules extends JFrame {
    private JButton all;
    private JButton bear;
    private JButton beaver;
    private JButton dolphin;
    private JButton elephant;
    private JButton lion;
    private JButton snake;
    private JButton clear;
    private JTextArea list;

    /**
     * This constructor sets up the GUI. It has buttons for selecting a specific species
     * or all species. When a button is pressed, the feedings of the animals of the selected
     * species are outputted. The user can press clear to clear the viewing area.
     * @param zooAnimalList List of zoo animals
     */
    FeedingSchedules(ArrayList<Animal> zooAnimalList) {
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
                            list.append(animal.getAnimalName() + ", " +  animal.getAnimalType()+"\n");
                            for(FeedAnimal feeding : animal.getFeedings()) {
                                list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                            }
                        }
                    }

                }
        );

        bear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Bears\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Bear) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
                    }

                }
        );
        beaver.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Beavers\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Beaver) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
                    }

                }
        );
        dolphin.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Dolphins\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Dolphin) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
                    }

                }
        );
        elephant.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Elephants\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Elephant) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
                    }

                }
        );
        lion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Lions\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Lion) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
                    }

                }
        );
        snake.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        list.append("Snakes\n");
                        for(Animal animal : zooAnimalList) {
                            if(animal instanceof Snake) {
                                list.append(animal.getAnimalName() + "\n");
                                for(FeedAnimal feeding : animal.getFeedings()) {
                                    list.append(feeding.getAmount() + " " +feeding.getType().getUnits() + " " + feeding.getType().getName()+"\n");
                                }
                            }
                        }
                        list.append("\n");
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