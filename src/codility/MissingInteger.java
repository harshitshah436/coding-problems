package codility;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * 
 * that, given a non-empty zero-indexed array A of N integers, returns the
 * minimal positive integer (greater than 0) that does not occur in A.
 * 
 * For example, given: A[0] = 1 A[1] = 3 A[2] = 6 A[3] = 4 A[4] = 1 A[5] = 2 the
 * function should return 5.
 * 
 * Assume that:
 * 
 * -N is an integer within the range [1..100,000]; -each element of array A is
 * an integer within the range [-2,147,483,648..2,147,483,647].
 * 
 * Complexity:
 * 
 * -expected worst-case time complexity is O(N); -expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * Elements of input arrays can be modified.
 */
public class MissingInteger {
    public int solution(int[] A) {
        int n = A.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            // Only insert elements within the range of 1..N
            if (A[i] > 0 && A[i] <= n)
                temp[A[i] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0)
                return i + 1;
        }
        // If there isn't any missing element then the answer should be n+1.
        return n + 1;
    }

}
