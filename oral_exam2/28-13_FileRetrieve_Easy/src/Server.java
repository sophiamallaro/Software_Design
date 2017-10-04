/**
 * Class representing the server
 * @author Sophia Mallaro
 * @see Server
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Server extends JFrame {
    private ServerSocket server;
    private Socket serverSocket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private JTextArea display;
    private Scanner toSend;

    /**
     * Constructor that sets up GUI
     */
    Server() {
        super("Server");
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        display = new JTextArea();
        add(display);
        display.setBounds(0,0,400,400);
        display.setEditable(false);
    }

    /**
     * Calls other methods to run the server application
     */
    public void run() {
        try {
            server = new ServerSocket(12345, 100);
            getConnection();
        } catch(IOException ex) {
            display.append("Something went wrong");
        }
    }

    /**
     * Gets connections with clients, gets input and output streams and calls the process connection method
     */
    private void getConnection() {
        try {
            serverSocket = server.accept();
            display.append("Connection received from" + serverSocket.getInetAddress().getHostName() + "\n");
            output = new ObjectOutputStream(serverSocket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(serverSocket.getInputStream());
            processConnection();
        } catch(IOException ex) {
            display.append("Connection Failed");
        }
    }

    /**
     * Gets input from the client and calls the findFile method
     * @throws IOException
     */
    private void processConnection() throws IOException {
        boolean terminated = false;
        String fileName;
        while(!terminated) {
            try {
                fileName = (String)input.readObject();
                display.append("Looking for " + fileName + "\n");
                terminated = findFile(fileName);
            } catch(ClassNotFoundException ex) {
                display.append("Error receiving the data");
            }
        }
    }

    /**
     * Looks for a file at the specified file path.
     * If the file exists, the contents are sent. If not,
     * the client is informed that the path does not exist.
     * @param message file path
     * @return True when client terminates, false otherwise
     * @throws IOException
     */
    private boolean findFile(String message) throws IOException {
        if(message.equals("exit")) {
            display.append("Connection terminated\n");
            terminate();
            return true;
        } else {
            Path path = Paths.get(message);
            if(Files.exists(path)) {
                toSend = new Scanner(path);
                if(!toSend.hasNextLine()) {
                    output.writeObject("File is empty");
                } else {
                    while(toSend.hasNextLine()) {
                        output.writeObject(toSend.nextLine());
                    }
                }
                display.append("File contents sent\n");
            } else {
                output.writeObject("File does not exist.");
                output.flush();
            }
        }
        return false;
    }

    /**
     * Closes streams and sockets
     */
    private void terminate() {
        try {
            output.close();
            input.close();
            serverSocket.close();
        } catch(IOException ex) {
            display.append("Error closing");
        }


    }
}
