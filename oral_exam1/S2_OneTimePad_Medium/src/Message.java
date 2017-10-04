/**
 * This class handles messages to be encrypted and decrypted.
 * @author Sophia Mallaro
 * @see Message
 */

import java.util.Random;

public class Message {
    private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private int[] keys;
    private String message;

    /**
     * This constructor takes in a message to be encrypted.
     * @param message Message to be encrypted
     */
    Message (String message) {
        this.message = message;
        keys = new int[message.length()]; //Maximum necessary length for array
        java.util.Arrays.fill(keys, -1);
    }

    /**
     * This constructor takes in a message to be decrypted and a set of keys
     * @param message Message to be decrypted
     * @param keys Set of keys to be used for decryption
     */
    Message (String message, int[] keys) {
        this.keys = keys;
        this.message = message;
    }

    /**
     * This get method returns the message
     * @return The message as a String
     */
    public String getMessage() {
        return message;
    }

    /**
     * THis get method returns the set of keys
     * @return The array of keys
     */
    public int[] getKeys () { return keys; }

    /**
     * This method takes in an integer and returns the corresponding character
     * in the alphabet array
     * @param index Int of index in alphabet array
     * @return Character at the corresponding place in the alphabet array
     */
    private char toLetter(int index) {
        return alphabet[index];
    }

    /**
     * This method takes in a character and returns the index of that
     * character in the alphabet array
     * @param Letter Character to be converted to index
     * @return The integer index of the character in the alphabet array
     */
    private int toIndex(char Letter) {
        for(int i = 0; i < alphabet.length; i++) {
            if (Letter == alphabet[i]) {
                return i;
            }
        }
        return -1; //Returns -1 if no such character exists in the alphabet
    }

    /**
     * This method Encrypts the message.
     */
    public void Encrypt() {
        char[] mymessage = message.toCharArray();
        int counter = 0;
        Random random = new Random();
        for(int i=0; i<mymessage.length; i++) {
            int n = random.nextInt(message.length());
            int index = toIndex(mymessage[i]);
            if(index != -1) {
                index = (index + n) % (alphabet.length);
                mymessage[i] = toLetter(index);
                keys[counter]=n;
                counter++;
            }
        }
        message = new String(mymessage);
    }

    /**
     * This method decrypts the message
     */
    public void Decrypt() {
        char[] mymessage = message.toCharArray();
        int counter = 0;
        for(int i=0; i<mymessage.length; i++) {
            int index = toIndex(mymessage[i]);
            if(index != -1) {
                index = (index - keys[counter]) % (alphabet.length);
                counter++;
                if(index < 0) {
                    index = alphabet.length + index;
                }
                mymessage[i] = toLetter(index);
            }
        }
        message = new String(mymessage);
    }
}
