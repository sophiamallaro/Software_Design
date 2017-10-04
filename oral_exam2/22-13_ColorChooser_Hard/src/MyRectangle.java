/**
 * This class extends JLabel and represents the rectangle drawn to the screen.
 * @author Sophia Mallaro
 * @see MyRectangle
 */
import javax.swing.*;
import java.awt.*;

public class MyRectangle extends JLabel {
    private int red;
    private int green;
    private int blue;

    /**
     * This constructor takes in integer values for the red, green and blue color components of the rectangle.
     * @param red Red color value
     * @param green Green color value
     * @param blue Blue color value
     */
    MyRectangle(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        repaint();
    }

    /**
     * This set method sets the value of the red color component
     * @param red Red Color value
     */
    public void setRed(int red) {
        this.red = red;
        repaint();
    }

    /**
     * This method sets the value of the green color component
     * @param green New green value
     */

    public void setGreen(int green) {
        this.green = green;
        repaint();
    }

    /**
     * This method updates the blue color component value
     * @param blue New blue color value
     */
    public void setBlue(int blue) {
        this.blue = blue;
        repaint();
    }

    /**
     * This method overrides the JLabel's paintComponent method. It updates the color of
     * the rectangle.
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        Color color = new Color(red,green,blue);
        g.setColor(color);
        g.fillRect(150,100,300,300);
    }

}
