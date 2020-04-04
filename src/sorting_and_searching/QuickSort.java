package sorting_and_searching;

/**
 * Quick sort.
 *
 * Average case time complexity: O(n log n); worst case time complexity: O (n^2)
 * Space Complexity: O(log n).
 *
 * @author Harshit
 */
public class QuickSort {

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick a pivot point. Can be any
                                             // element

        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // partitioning index
            int pi = partition(arr, left, right);

            quickSort(arr, left, pi - 1); // Sort left half
            quickSort(arr, pi, right); // Sort right half including pi
        }
    }

    public static void main(String[] args) {
        int[] a = { 3, -9, 5, 7, 2, 1, -5, 0 };

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        System.out.println("-----------------");

        quickSort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
