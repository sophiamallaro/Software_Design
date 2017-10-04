/**
 * This class contains the functionality for the merge sort algorithm. This class was
 * written with assistance from Chapter 19 of Java, How to Program Early Object by
 * Dietel and Deitel.
 * @author Sophia Mallaro
 * @see MergeSort
 */
public class MergeSort {
    /**
     * This method calls sort the first time. Sort is recursively called additional times.
     * @param array The array to be sorted
     */
    public static void mergeSort(int[] array) {
        sort(array, 0, array.length-1);
    }

    /**
     * This method recursively calls sort until the arrays are divided up into single elements
     * @param arr Array to be sorted
     * @param min Minimum index of section to be sorted
     * @param max Maximum index of section to be sorted
     */
    public static void sort(int[] arr, int min, int max) {
        int middle = (max+min)/2;
        int middle2 = middle +1;
        if(max-min >0) {
            sort(arr, min, middle);
            sort(arr, (middle +1), max);
            merge(arr, min, middle, middle2, max);
        }
    }

    /**
     * This method merges sorted arrays together
     * @param arr Array to be merged
     * @param min Minimum element
     * @param middle End of section 1
     * @param middle2 End of section 2
     * @param max Maximum element
     */

    public static void merge(int [] arr, int min, int middle, int middle2, int max) {
        int left = min;
        int right = middle2;
        int leftEnd = middle;
        int rightEnd = max;
        int[] merged = new int[arr.length];
        int count = min;

        while(left <= leftEnd && right <=rightEnd) {
            if(arr[left] <= arr[right]) {
                merged[count] = arr[left];
                left++;
            }
            else {
                merged[count] = arr[right];
                right++;
            }
            count++;
        }
        while(left<=leftEnd) {
            merged[count] = arr[left];
            count++;
            left++;
        }
        while(right<=rightEnd) {
            merged[count] = arr[right];
            count++;
            right++;
        }
        for(int i=min; i<=max; i++) {
            arr[i] = merged[i];
        }
    }
}
