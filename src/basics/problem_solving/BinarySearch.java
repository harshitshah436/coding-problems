package basics.problem_solving;

/**
 * BinarySearch using iterative and recursion.
 *
 * @author Harshit
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) {
            return -1; // Error
        }
        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 9, 12, 15, 18};
        for (int i = 0; i < 20; i++) {
            int index1 = binarySearch(a, i);
            int index2 = binarySearchRecursive(a, i, 0, a.length - 1);
            System.out.println(i + ": " + index1 + " " + index2);
        }
    }
}
