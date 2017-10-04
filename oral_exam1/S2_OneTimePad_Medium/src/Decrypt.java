/**
 * This is the driver class for decrypting a message
 * @author Sophia Mallaro
 * @see Decrypt
 */
import java.util.Scanner;

public class Decrypt {
    /**
     * This main method asks a user to enter an encrypted message and a set of keys.
     * It displays the decrypted message.
     * @param args main arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter encrypted message: ");
        String message = scanner.nextLine();
        int keys[] = new int[message.length()];
        System.out.print("Enter key values: ");
        String keyList = scanner.nextLine();
        keyList = keyList.replaceAll("\\s", "");
        String Keys[] = keyList.split(",");
        for(int i=0; i< Keys.length; i++) {
            try {keys[i] = Integer.parseInt(Keys[i]);}
            catch(IllegalArgumentException ex ) {}
        }
        Message encrypt = new Message(message, keys);
        encrypt.Decrypt();
        System.out.println("Cipher Text:    " + message);
        System.out.println("Decrypted Text: " + encrypt.getMessage());
        scanner.close();
    }


}
