package chapter1;

public class BinarySearch {

  private final int[] sortedArray;

  public BinarySearch(int[] sortedArray) {
    this.sortedArray = sortedArray;
  }

  public int indexOf(int item) {
    int low = 0;
    int hig = sortedArray.length - 1;
    while (low <= hig) {
      int mid = (low + hig) / 2;
      if (sortedArray[mid] == item) {
        return mid;
      }
      if (sortedArray[mid] < item) {
        low = mid + 1;
      } else {
        hig = mid - 1;
      }
    }
    return -1;
  }
}
