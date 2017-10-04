/**
 * Driver class for the server
 * @author Sophia Mallaro
 * @see ServerTest
 */
import javax.swing.*;

public class ServerTest {
    public static void main(String[] args) {
        Server server = new Server();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server.run();
    }

}
