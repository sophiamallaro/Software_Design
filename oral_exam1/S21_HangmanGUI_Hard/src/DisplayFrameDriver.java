/**
 * DisplayFrameDriver.java - This is the driver class for the hangman program.
 * It creates a JFrame and adds a DisplayFrame.
 * @author Sophia Mallaro
 * @see DisplayFrame Driver
 */
import javax.swing.*;
import java.awt.*;

public class DisplayFrameDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing lines, rectangles and ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(180,600);
        frame.setResizable(false);

        DisplayFrame display = new DisplayFrame();
        frame.add(display);
        display.setSize(180,300);
        display.setLocation(0,0);
        display.setVisible(true);

        frame.setVisible(true);
    }

}
