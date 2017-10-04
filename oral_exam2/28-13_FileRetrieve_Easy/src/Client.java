import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Class representing the client
 * @author Sophia mallaro
 * @see Client
 */
public class Client extends JFrame {
    private JTextField fileName;
    private JTextArea fileInfo;
    private Socket clientSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    //private String server;

    /**
     * Constructor that sets up the GUI
     */
    Client() {
        super("Client");
        fileName = new JTextField("Enter file path or 'exit' to close");
        fileInfo = new JTextArea();
        setLayout(new BorderLayout());
        add(fileName, BorderLayout.NORTH);
        add(fileInfo, BorderLayout.CENTER);
        add(new JScrollPane(fileInfo));
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

        fileName.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        send(fileName.getText());
                    }
                }
        );

    }

    /**
     * This method waits for connections and sets up input and output streams
     */
    public void run() {
        try {
            fileInfo.append("Attempting Connection\n"); //Connect to server
            clientSocket = new Socket("127.0.0.1", 12345);
            fileInfo.append("Connection Successful\n");

            input = new ObjectInputStream(clientSocket.getInputStream()); //Get input and output streams
            output = new ObjectOutputStream(clientSocket.getOutputStream());

            processConnection();

        } catch (IOException ex) {
            fileInfo.append("Connection Failed\n");
        }
    }

    /**
     * Sends the file path to the user
     * @param message File path inputted by user
     */
    private void send(String message) {
        try {
            output.writeObject(message);
            output.flush();
            if(message.equals("exit")) {
                fileInfo.append("Terminating connection\n");
                terminate();
            } else {
                fileInfo.append("Contents of: " + message + "\n");
            }

        } catch (IOException ex) {
            fileInfo.append("Error occurred while sending the message\n");
        }
    }

    /**
     * Receives information from the server and prints to the screen
     * @throws IOException
     */
    private void processConnection() throws IOException{
        boolean terminated = false;
        String file;
        while(!terminated) {
            try {
                file = (String)input.readObject();
                fileInfo.append(file);
                fileInfo.append("\n");
            } catch(ClassNotFoundException ex) {
                fileInfo.append("Error receiving the data");
            }
        }
    }

    /**
     * Closes input and output streams and socket
     */
    private void terminate() {
        try {
            input.close();
            output.close();
            clientSocket.close();
        } catch(IOException ex) {
            fileInfo.append("Error closing\n");
        }
    }
}
