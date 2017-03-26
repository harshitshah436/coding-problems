/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * @author Harshit
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is "
                + MatrixChainOrderRecursive(arr, 1, n - 1));

        System.out.println("Minimum number of multiplications using Dynamic Programming is "
                + MatrixChainOrderDynamic(arr, n));
    }

    /**
     * Naive recursive method for matrix chain multiplication.
     */
    private static int MatrixChainOrderRecursive(int[] p, int i, int j) {

        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = MatrixChainOrderRecursive(p, i, k)
                    + MatrixChainOrderRecursive(p, k + 1, j) + p[i - 1] * p[k] * p[j];

            min = Math.min(min, count);
        }
        return min;
    }

    private static int MatrixChainOrderDynamic(int[] p, int n) {

        int m[][] = new int[n][n];

        // For all length 1 matrix multiplications would be 0.
        for (int L = 1; L < n; L++) {
            m[L][L] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (j == n) {
                    continue;
                }
                m[i][j] = Integer.MAX_VALUE;
                int count = 0;
                for (int k = i; k <  j; k++) {
                    count = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    m[i][j] = Math.min(m[i][j], count);
                }
            }
        }
        return m[1][n-1];
    }
}
