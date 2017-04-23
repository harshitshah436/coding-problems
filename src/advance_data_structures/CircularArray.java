package advance_data_structures;


import java.util.Iterator;

/**
 * Circular array for generic type. It also support standard iteration of java
 * [for(Object o: CircularArray)].
 *
 * @author Harshit
 * @param <T> Generic type.
 */
public class CircularArray<T> implements Iterable<T> {

    private final T[] array;
    private int head;

    /**
     * Constructor to initialize circular array with given size.
     *
     * @param size
     */
    public CircularArray(int size) {
        /*
         * Generic Array creation. Java doesn't allow generic array creation. 
         * So we can create using explicit casting.
         */
        array = (T[]) new Object[size];
        head = 0;
    }

    /**
     * Rotate array by n value. Head of the array will be shifted to right by n.
     *
     * @param n
     */
    public void rotate(int n) {
        head = rotateArrayByN(n);
    }

    /**
     * Rotate logically array by n.
     *
     * @param n
     * @return latest index of head.
     */
    private int rotateArrayByN(int n) {
        if (n < 0) {
            n += array.length;
        }
        return (head + n) % array.length;
    }

    public void set(int index, T value) {
        index = rotateArrayByN(index);
        array[index] = value;
    }

    public T get(int index) {
        index = rotateArrayByN(index);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>();
    }

    /**
     * Implement iterator for iterating CircularArray object by for-each loop.
     *
     * @param <T>
     */
    private class CircularArrayIterator<T> implements Iterator<T> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < array.length - 1;
        }

        @Override
        public T next() {
            return (T) array[rotateArrayByN(++index)];
        }
    }

    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, Integer.toString(i));
        }
        System.out.println("Initial Array: " + array.toString());

        array.rotate(3);
        System.out.println("Rotated by 3: " + array.toString());

        array.rotate(2);
        System.out.println("Rotated by 2: " + array.toString());

        array.rotate(-9);
        System.out.println("Rotated by -9: " + array.toString());
    }

    @Override
    public String toString() {
        // Note this line, it is printing the CircularArray object not interal 
        // T[] array.
        CircularArray<T> array1 = this;
        StringBuilder sb = new StringBuilder("[");
        for (T value : array1) {
            sb.append(value);
            sb.append(", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }

}
