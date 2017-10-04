/**
 * Driver class for the client
 * @author Sophia Mallaro
 * @see ClientTest
 */
import javax.swing.*;
public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client();
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.run();
        //client.setVisible(true);
    }
}
