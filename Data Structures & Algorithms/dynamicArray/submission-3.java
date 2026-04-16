public class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            arr = new int[capacity];
            this.capacity = capacity;
        }
    }

    public int get(int i) {
        if (i < capacity) {
            return arr[i];
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. Valid range: 0 to " + (capacity - 1));
    }

    public void set(int i, int n) {
        if (i < capacity) {
            arr[i] = n;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. Valid range: 0 to " + (capacity - 1));
    }

    public void pushback(int n) {
        if (size == capacity) {
            this.resize();
        }
        arr[size++] = n;
    }

    public int popback() {
        size--;
        int pop = arr[size];
        arr[size] = 0;
        return pop;
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newArr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
