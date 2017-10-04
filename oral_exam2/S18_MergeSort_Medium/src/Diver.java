/**
 * This is the driver class for the merge sort program. It tests the sorting of one reversely sorted array and
 * prints the results to the screen.
 * @author Sophia Mallaro
 * @see Diver
 */
import java.util.Random;

public class Diver {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] test = new int[100];
        for(int i=0; i<test.length; i++) {
            test[i] = rand.nextInt(100)+1;
        }
        MergeSort.mergeSort(test);
        for(int i=0; i<test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
}