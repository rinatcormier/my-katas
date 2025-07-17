package chapter2;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        int[] sorted = new int[array.length];
        System.arraycopy(array, 0, sorted, 0, array.length);
        for (int i = 0; i < sorted.length; i++) {
            int minValue = sorted[i];
            int minIndex = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j] < minValue) {
                    minValue = sorted[j];
                    minIndex = j;
                }
            }
            int temp = sorted[i];
            sorted[i] = minValue;
            sorted[minIndex] = temp;
        }
        return sorted;
    }
}
