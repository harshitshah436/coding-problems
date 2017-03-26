package codility;

/**
 * Medium/Challenging Problem: Not easy.
 * 
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 leq P < Q < N, is called a slice of array A
 * (notice that the slice contains at least two elements). The average of a
 * slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length
 * of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... +
 * A[Q]) / (Q - P + 1).
 * 
 * For example, array A such that: A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5 A[4] = 1
 * A[5] = 5 A[6] = 8 contains the following example slices:
 * 
 * -slice (1, 2), whose average is (2 + 2) / 2 = 2; -slice (3, 4), whose average
 * is (5 + 1) / 2 = 3; -slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 =
 * 2.5.
 * 
 * The goal is to find the starting position of a slice whose average is
 * minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * 
 * that, given a non-empty zero-indexed array A consisting of N integers,
 * returns the starting position of the slice with the minimal average. If there
 * is more than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * 
 * For example, given array A such that: A[0] = 4 A[1] = 2 A[2] = 2 A[3] = 5
 * A[4] = 1 A[5] = 5 A[6] = 8 the function should return 1, as explained above.
 * 
 * Assume that:
 * 
 * -N is an integer within the range [2..100,000]; -each element of array A is
 * an integer within the range [-10,000..10,000].
 * 
 * Complexity:
 * 
 * -expected worst-case time complexity is O(N); -expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * Elements of input arrays can be modified.
 */
public class MinAvgTwoSlice {
    /*
     * Solution link:
     * http://codility-lessons.blogspot.com/2014/07/lesson-3-minavgtwoslice.html
     * 
     * To check the number of the slots that produce the minimum average, we
     * only have to check the sum of the consecutive two or three slots. So for
     * more than 3 any odd number can be tested by some groups of even and odd
     * numbers. while even pairs are calculated from some pairs of even number.
     */
    public int solution(int[] A) {
        int i = 0;
        int N = A.length;

        if (N == 2) {
            return 0;
        }

        // initialize the current minimum average of the first two slots.
        double minavg = (A[0] + A[1]) / 2.0;
        int idx = 0;

        for (i = 2; i < N; i++) {
            double tmp1 = (A[i - 1] + A[i]) / 2.0;
            double tmp2 = (A[i - 2] + A[i - 1] + A[i]) / 3.0;

            if (tmp1 < minavg) {
                idx = i - 1;
                minavg = tmp1;
            }
            if (tmp2 < minavg) {
                idx = i - 2;
                minavg = tmp2;
            }
        }
        return idx;

    }
}
