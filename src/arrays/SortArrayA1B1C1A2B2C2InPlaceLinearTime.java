package arrays;

/**
 * Given an aray with ['a1', 'a2', .....'aN', 'b1', 'b2', ....'bN', 'c1', 'c2',
 * .....'cN'], stagger the subarrays so it becomes ['a1', 'b1', 'c1', 'a2',
 * 'b2', 'c2', ...'aN', 'bN', 'cN']. The optimal solution requires linear-time
 * sorting and a constant space complexity.
 *
 * @author Harshit
 */
public class SortArrayA1B1C1A2B2C2InPlaceLinearTime {

    public static void main(String[] args) {

        String[] array = {"a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4", "c1", "c2", "c3", "c4", "d1", "d2", "d3", "d4"};

        for (String item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
        transpose(array, 4); // n = 4
        for (String item : array) {
            System.out.print(item + " ");
        }
    }

    private static void transpose(Object[] a, int n) {
        for (int i = 0; i < a.length; i++) {

            if (i % n <= i / n) {
                continue;
            }

            int secondIndexToSwap = (i % n) * n + i / n;
            Object temp = a[i];
            a[i] = a[secondIndexToSwap];
            a[secondIndexToSwap] = temp;

        }
    }
}
