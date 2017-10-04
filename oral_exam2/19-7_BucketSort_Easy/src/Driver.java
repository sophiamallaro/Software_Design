import java.util.Random;
/**
 * This is the driver class for the bucket sort program. It tests the sorting of one reversely sorted array and
 * prints the results to the screen.
 * @author Sophia Mallaro
 * @see Driver
 */
public class Driver {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] text = new int[100];
        for(int i=0; i<text.length; i++) {
            text[i] = rand.nextInt(100);
        }
        BucketSort.sort(text);
        for(int i=0; i<text.length; i++) {
            System.out.print(text[i] + " ");
        }
    }
}

