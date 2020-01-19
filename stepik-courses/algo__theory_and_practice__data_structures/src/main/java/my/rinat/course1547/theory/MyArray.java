package my.rinat.course1547.theory;

public class MyArray {

    private int[] array;
    private int tail = 0;

    public MyArray(int size) {
        this.array = new int[size + 1];
    }

    public void add(int element) {
        insert(tail, element);
    }

    public void insert(int index, int element) {
        if (array.length > 1) {
            tail += 1;
            int i = tail;
            while (i > index) {
                array[i] = array[i - 1];
                i--;
            }
        }
        array[index] = element;
    }

    public void delete(int index) {
        int i = index;
        while (i < tail) {
            array[i] = array[i + 1];
            i++;
        }
        array[tail - 1] = array[tail];
        array[tail] = 0;
        tail -= 1;
    }

    public int[] getArray() {
        int[] copy = new int[array.length - 1];
        System.arraycopy(array, 0, copy, 0, copy.length);
        return copy;
    }
}
