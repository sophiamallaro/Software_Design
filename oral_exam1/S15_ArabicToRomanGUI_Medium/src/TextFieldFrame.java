/**
 * TextFieldFrame.java - This class contains the logic for the GUI
 * used for the Arabic to Roman conversion. The class extends JFrame.
 * @author Sophia Mallaro
 * @see TextFieldFrame
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame {
    private JTextField arabic;
    private JLabel arabicLabel;
    private JTextField roman;
    private JLabel romanLabel;

    /**
     * This is the constructor for the TextFieldFrame object. It extends JFrame
     * thus it creates a new JFrame Object. It adds a JTextField to enter the arabic
     * number as well as a JTextField to display the roman numeral form. It also creates labels
     * for each textfield. An annonymus inner class Action Listener is added to the arabic text field.
     * When the user enters an input, a new Converter object is created with the inputted number and
     * the corresponding roman numeral is displayed. If the input is invalid, "Invalid Input" is displayed
     * where the roman numeral would be displayed.
     */
    public TextFieldFrame () {
        super("Roman to Arabic Conversion");
        setLayout(new FlowLayout());
        arabicLabel = new JLabel("Arabic");
        arabicLabel.setToolTipText("Enter number between 0 and 3999");
        add(arabicLabel);
        arabic = new JTextField(10);
        add(arabic);
        romanLabel = new JLabel("Roman");
        add(romanLabel);
        roman = new JTextField(10);
        add(roman);

        arabic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String number = arabic.getText();
                try {
                    int num = Integer.parseInt(number);
                    Converter converter = new Converter(num);
                    roman.setText(converter.getRoman());
                } catch (NumberFormatException ex){
                    roman.setText("Invalid Input");
                }
                roman.setEditable(false);
            }
        });
    }
}
