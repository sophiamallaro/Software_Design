import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * This class contains the JFrame for feeding an animal. It takes in a reference to the animal
 * and adds a feeding with the information entered by the user.
 * @author Sophia mallaro
 * @see Feeding
 */
public class Feeding extends JFrame {
    private JComboBox options;
    //private List<Food> foods;
    private JTextField amount;
    private JTextField units;
    private JLabel optionsLabel;
    private JLabel amountLabel;

    /**
     * This constructor sets up the GUI. It has a JCombo box for food options and
     * a text field to enter the amount fed. When the user presses enter, the feeding
     * is added to the list of animal feedings.
     * @param toFeed Animal to be fed
     */
    Feeding(Animal toFeed) {
        setSize(240, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        amount = new JTextField("");
        units = new JTextField("");
        amountLabel = new JLabel("Amount");
        optionsLabel = new JLabel("Food Type");
        List<Food> foods = toFeed.getFood();
        String[] foodOptions = new String[foods.size()];
        int i = 0;
        for (Food food : foods) {
            foodOptions[i] = food.getName();
            i++;
        }
        options = new JComboBox(foodOptions);

        units.setText(foods.get(0).getUnits());

        add(optionsLabel);
        optionsLabel.setBounds(20, 20, 80, 20);
        add(options);
        options.setBounds(100, 20, 100, 20);
        add(amountLabel);
        amountLabel.setBounds(20, 50, 80, 20);
        add(amount);
        amount.setBounds(100, 50, 70, 20);
        add(units);
        units.setBounds(170, 50, 30, 20);
        units.setEditable(false);

        options.addActionListener(
                new ActionListener() {
                    String selected = (String) options.getSelectedItem();
                    public void actionPerformed(ActionEvent event) {
                        for (Food food : foods) {
                            if (selected.equals(food.getName())) {
                                units.setText(food.getUnits());
                            }
                        }
                    }
                }
        );

        amount.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        try{
                            Food selected;
                            for (Food food : foods) {
                                if(food.getName().equals(options.getSelectedItem())) {
                                    selected = food;
                                    toFeed.feed(new FeedAnimal(selected,Integer.parseInt(event.getActionCommand())));
                                }
                            }
                            dispose();
                        } catch(NumberFormatException ex) {
                            amount.setText("Invalid Amount");
                        }
                    }
                }
        );


    }
}
