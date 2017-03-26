package codility;

/**
 * Write a function
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * 
 * that, given a zero-indexed array A consisting of N integers, returns the
 * number of distinct values in array A.
 * 
 * Assume that:
 * 
 * -N is an integer within the range [0..100,000]; -each element of array A is
 * an integer within the range [-1,000,000..1,000,000].
 * 
 * For example, given array A consisting of six elements such that: A[0] = 2
 * A[1] = 1 A[2] = 1 A[3] = 2 A[4] = 3 A[5] = 1 the function should return 3,
 * because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * 
 * Complexity:
 * 
 * -expected worst-case time complexity is O(N*log(N)); -expected worst-case
 * space complexity is O(N), beyond input storage (not counting the storage
 * required for input arguments).
 * 
 * Elements of input arrays can be modified.
 */
public class Distinct {
    public int solution(int[] A) {

        // For empty array distinct count should be 0.
        if (A.length == 0)
            return 0;

        // Sort an array.
        quickSort(A, 0, A.length - 1);
        
        int distinctCount = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1])
                distinctCount++;
        }
        
        return distinctCount;
    }

    public static void quickSort(int[] a, int begin, int end) {
        int p = partition(a, begin, end);
        if (begin < p - 1)
            quickSort(a, begin, p - 1);
        if (p < end)
            quickSort(a, p, end);
    }

    public static int partition(int[] a, int begin, int end) {
        int i = begin, j = end;
        int pivot = a[i];
        while (i <= j) {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

}
