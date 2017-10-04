import javax.swing.*;

/**
 * This is the driver class for the color chooser program. It contains a main method that
 * creates a JFrame and adds a MyColorChooser object to it.
 * @author Sophia Mallaro
 * @see ColorChooserDriver
 */
public class ColorChooserDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser");
        MyColorChooser chooser = new MyColorChooser();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.add(chooser);
        frame.setVisible(true);

    }
}
