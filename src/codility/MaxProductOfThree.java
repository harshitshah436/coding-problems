package codility;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The
 * product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 leq P < Q < R <
 * N).
 * 
 * For example, array A such that: A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2 A[4] =
 * 5 A[5] = 6 contains the following example triplets:
 * 
 * -(0, 1, 2), product is -3 * 1 * 2 = -6 -(1, 2, 4), product is 1 * 2 * 5 = 10
 * -(2, 4, 5), product is 2 * 5 * 6 = 60
 * 
 * Your goal is to find the maximal product of any triplet.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * 
 * that, given a non-empty zero-indexed array A, returns the value of the
 * maximal product of any triplet.
 * 
 * For example, given array A such that: A[0] = -3 A[1] = 1 A[2] = 2 A[3] = -2
 * A[4] = 5 A[5] = 6 the function should return 60, as the product of triplet
 * (2, 4, 5) is maximal.
 * 
 * Assume that:
 * 
 * -N is an integer within the range [3..100,000]; -each element of array A is
 * an integer within the range [-1,000..1,000].
 * 
 * Complexity:
 * 
 * -expected worst-case time complexity is O(N*log(N)); -expected worst-case
 * space complexity is O(1), beyond input storage (not counting the storage
 * required for input arguments).
 * 
 * Elements of input arrays can be modified.
 */
public class MaxProductOfThree {
    /*
     * Remember sorting array won't give solution because it changes the indices
     * of elements.
     * 
     * The trick is to produce a max product, we have to consider any two of the
     * three picked up values can be negative. In this case, the product of
     * these two negative values can be positive.
     * 
     * So what we need to do is to compute the product of two smallest values
     * and one biggest values and the product of three biggest values.
     * 
     * The bigger one of these two will be the maximum product.
     */
    public int solution(int[] A) {

        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        int min1 = 1001, min2 = 1001, max1 = -1001, max2 = -1001, max3 = -1001;
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];

            if (temp < min1) {
                min2 = min1;
                min1 = temp;
            } else if (temp < min2) {
                min2 = temp;
            }

            if (temp > max1) {
                max3 = max2;
                max2 = max1;
                max1 = temp;
            } else if (temp > max2) {
                max3 = max2;
                max2 = temp;
            } else if (temp > max3) {
                max3 = temp;
            }
        }
        int maxProd1 = max1 * max2 * max3;
        int maxProd2 = min1 * min2 * max1;
        return maxProd1 > maxProd2 ? maxProd1 : maxProd2;
    }
}
