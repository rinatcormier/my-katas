package chapter2;

/**
 * Implementation of Selection Sort algorithm.
 * Selection sort works by finding the minimum element from the unsorted part
 * of the array and putting it at the beginning of the unsorted part.
 */
public class SelectionSortJunie {

    /**
     * Sorts an array using the selection sort algorithm.
     * This method does not modify the original array.
     *
     * @param array the array to be sorted
     * @return a new sorted array
     */
    public static int[] selectionSort(int[] array) {
        // Create a copy of the input array to avoid modifying the original
        int[] sorted = new int[array.length];
        System.arraycopy(array, 0, sorted, 0, array.length);
        
        // Perform selection sort
        for (int i = 0; i < sorted.length - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < sorted[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                int temp = sorted[i];
                sorted[i] = sorted[minIndex];
                sorted[minIndex] = temp;
            }
        }
        
        return sorted;
    }
}