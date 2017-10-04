/**
 * This is the driver class for encyrpting a message
 * @author Sophia Mallaro
 * @see Encrypt
 */
import java.util.Scanner;

public class Encrypt {
    /**
     * This main method asks a user to enter a message. It displays the encrypted message
     * and a set of keys.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();
        Message encrypt = new Message(message.toUpperCase());
        encrypt.Encrypt();
        System.out.println("Message:        " + message);
        System.out.print("Keys:        ");
        for (int i = 0; i < encrypt.getKeys().length; i++) {
            if (encrypt.getKeys()[i] != -1) {
                System.out.print(encrypt.getKeys()[i] + ",");
            }
        }
        System.out.print("\n");
        System.out.println("Cipher Text:    " + encrypt.getMessage());
        scanner.close();
    }
}