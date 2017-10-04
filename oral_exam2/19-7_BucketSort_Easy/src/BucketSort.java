/**
 * This class contains the logic for the bucket sort algorithm.
 * @author Sophia Mallaro
 * @see BucketSort
 */
public class BucketSort {
    /**
     * This method sorts the array. It works by looping through the array the number of times corresponding to the
     * number of places in the maximum number. Each time, it places numbers into buckets by a place and returns them
     * to the array.
     */

    public static void sort(int[] toSort) {
        int[][] buckets = new int[10][toSort.length];
        for(int i=0; i< toSort.length; i++) {
            for(int j=0; j< 10; j++) {
                buckets[j][i] = -1;
            }
        }
        int max = 0;
        for(int i=0; i<toSort.length; i++) {
            if(toSort[i] > max) {
                max=toSort[i];
            }
        }
        int totalPlace=10;
        while(totalPlace < max) {
            totalPlace = totalPlace*10;
        }
        int place = 1;
        int count;
        while(place <= totalPlace) {
            count = 0;
            int temp2;
            int temp;

            for(int i=0; i< toSort.length; i++) { //Tens place
                temp = toSort[i] % (place*10);
                temp2 = temp/10;
                while(temp2 >0){
                    temp = temp-toSort[i] % temp2;
                    temp2 = temp2/10;
                }
                //int temp = (toSort[i] % 100) - (toSort[i] % 10);
                int k=0;
                boolean inserted = false;
                while(!inserted) {
                    if(buckets[temp/place][k] == -1) {
                        buckets[temp/place][k] = toSort[i];
                        inserted = true;
                    }
                    k++;
                }
            }
            for(int i= 0; i< 10; i++) {
                for(int j=0; j<toSort.length; j++) {
                    if(buckets[i][j] != -1) {
                        toSort[count] = buckets[i][j];
                        count++;
                        buckets[i][j] = -1;
                    }
                }
            }
            place = place * 10;
        }
    }
}
