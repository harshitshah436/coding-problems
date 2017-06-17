package sorting_and_searching;

/**
 * Given is an array A[1...n] containing integers from the set {0, 1, 2,
 * ..., n^3-1}. Give an O(n) algorithm that sorts the array.
 *
 * Hint: Typically we write numbers in decimal notation. This implies
 * that an integer x needs about log_10 x (log x to the base 10) digits
 * (why?). How many digits do we need for numbers from {0, 1, 2, ...,
 * n^3-1} if we write them in base n?
 *
 * Comments:
 * See, the below url for better understanding.
 *
 * Reference:
 * http://www.geeksforgeeks.org/sort-n-numbers-range-0-n2-1-linear-time/
 *
 * @author Harshit
 */
public class LinearTimeSortingUsingRadixSort {

    /*
	 * For the below logic see example with base 10. For least significant
	 * digit/last digit sort by last digit, so passing 1 to divide the number
	 * 
	 * Same, for second last digit to divide by 10 so sending n as exponent
	 * 
	 * similarly, for the thousand digit divide by 100, so sending n^2
	 * 
	 * Here, in our case, range is n^3-1, so maximum length of any number is 3.
	 * For base 10 for example, 10^3-1 = 999, 3 digits.
	 * 
	 * Same way if the range in n^2-1 then only two times function is called.
	 * 
	 * But, if n^2 or n^3 range is given instead of n^2-1 or n^3-1 then, we need
	 * to change the logic. First take 1 minus from the given numbers then sort
	 * as below and finally add 1 to resulting sorted numbers.
     */
    private static void sortArrayUsingRadixSort(int[] a, int n) {
        CountingSort(a, n, 1); // n^0 = 1, so 1. Sort by last digit
        CountingSort(a, n, n); // n^1 = n, so n. Sort by second last
        // digit
        CountingSort(a, n, n * n); // n^2 = n*n, so. Sort by third
        // last
        // digit
    }

    // Counting Sort or Key Indexed Counting
    private static void CountingSort(int[] a, int n, int exp) {

        int[] count = new int[n];
        int[] temp = new int[n];

        // count frequencies for specific digit
        for (int i = 0; i < n; i++) {
            count[(a[i] / exp) % n]++;
        }

        // compute cumulates. Change count[i] so that count[i] now contains
        // actual position of this digit in temp[]
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        // build sorted array by specific digit
        for (int i = n - 1; i >= 0; i--) {
            temp[count[(a[i] / exp) % n] - 1] = a[i];
            count[(a[i] / exp) % n]--;
        }

        // Assign back to a[]
        for (int i = 0; i < n; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int n = 8;
        int[] a = {6, 63, 12, 1, 20, 57, 9, 49};

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n----------------");

        sortArrayUsingRadixSort(a, n);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
