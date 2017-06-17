package sorting_and_searching;


/**
 * MergeSort
 *
 * Time Complexity: O(n log n), average case, worst case both. Space complexity:
 * O(n) due to the auxiliary space used to merge parts of the array.
 *
 * @author Harshit
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3, -9, 5, 7, 2, 1, -5, 0};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        System.out.println("-----------------");

        mergeSort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);         // Sort left half
            mergeSort(a, mid + 1, high);    // Sort right half
            merge(a, low, mid, high);            // Merge them
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] helper = new int[a.length];

        /* Copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = a[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        /* 
         * Iterate through helper array. Compare the left and right
         * half, copying back the smaller element from the two halves
         * into the original array. 
         */
        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                a[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                a[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* 
         * Copy the rest of the left side of the array into the target array. 
         * Right side would already be in place so no need to do a while loop.
         */
        while (helperLeft <= mid) {
            a[current] = helper[helperLeft];
            helperLeft++;
            current++;
        }
    }
}
