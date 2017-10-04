import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates the GUI logic for the program.
 * @author Sophia Mallaro
 * @see MyColorChooser
 */
public class MyColorChooser extends JPanel {
    private JSlider red;
    private JSlider green;
    private JSlider blue;
    private JTextField redValue;
    private JTextField greenValue;
    private JTextField blueValue;
    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel blueLabel;
    private MyRectangle rectangle;

    /**
     * This constructor creates a MyColorChooser object, which extends JPanel. It adds a JSlider, JTextField and
     * JLabel for each color component. Additionally, it adds anonymous inner classes to the JSliders and JTextFields.
     * These change the colors of the rectangle drawn when the user change the value of the color component.
     */
    MyColorChooser() {
        setLayout(null);

        red = new JSlider(0,255);
        green = new JSlider(0,255);
        blue = new JSlider(0,255);
        redValue = new JTextField(10);
        greenValue = new JTextField(10);
        blueValue = new JTextField(10);
        redLabel = new JLabel("Red Component");
        greenLabel = new JLabel("Green Component");
        blueLabel = new JLabel("Blue Component");

        rectangle = new MyRectangle(red.getValue(),green.getValue(),blue.getValue());

        add(red);
        red.setBounds(50,50,150,20);
        add(redValue);
        redValue.setBounds(75,80,100,20);
        add(redLabel);
        redLabel.setBounds(75,20,100,20);
        add(green);
        green.setBounds(225,50,150,20);
        add(greenValue);
        greenValue.setBounds(250,80,100,20);
        add(greenLabel);
        greenLabel.setBounds(250,20,120,20);
        add(blue);
        blue.setBounds(400,50,150,20);
        add(blueValue);
        blueValue.setBounds(425,80,100,20);
        add(blueLabel);
        blueLabel.setBounds(425,20,100,20);
        add(rectangle);
        rectangle.setBounds(0,100,600,500);



        red.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        rectangle.setRed((int)source.getValue());
                        rectangle.setVisible(true);
                    }
                }
        );
        blue.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        rectangle.setBlue((int)source.getValue());
                        revalidate();
                    }
                }
        );
        green.addChangeListener(
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        rectangle.setGreen((int)source.getValue());
                        revalidate();
                    }
                }
        );
        redValue.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event){
                        try {
                            int input = Integer.parseInt(event.getActionCommand());
                            if(input >= 0 && input <= 255) {
                                red.setValue(input);
                            }
                        } catch(NumberFormatException ex) { redValue.setText(""); }
                    }
                }
        );
        greenValue.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event){
                        try {
                            int input = Integer.parseInt(event.getActionCommand());
                            if(input >= 0 && input <= 255) {
                                green.setValue(input);
                            }
                        } catch(NumberFormatException ex) { greenValue.setText(""); }
                    }
                }
        );
        blueValue.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event){
                        try {
                            int input = Integer.parseInt(event.getActionCommand());
                            if(input >= 0 && input <= 255) {
                                blue.setValue(input);
                            }
                        } catch(NumberFormatException ex) { blueValue.setText(""); }
                    }
                }
        );
    }

}
