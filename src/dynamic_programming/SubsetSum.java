/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * Calculate subset sum for both of the following condition and return true if
 * any of them are true.
 *
 * 1. exclude the last element of the array 2. include the last element of the
 * array
 *
 * @author Harshit
 */
public class SubsetSum {

    /**
     * Naive recursive approach
     *
     * Computational Complexity: Exponential
     *
     * @param set
     * @param n
     * @param sum
     * @return
     */
    private static boolean isSubsetSumNaiveRecursive(int[] set, int n, int sum) {
        if (n == 0 && sum > 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        // Check this condition, otherwise it will go on and give stackoverflow error.
        if (sum < set[n - 1]) {
            return isSubsetSumNaiveRecursive(set, n - 1, sum);
        }

        return isSubsetSumNaiveRecursive(set, n - 1, sum)
                || isSubsetSumNaiveRecursive(set, n - 1, sum - set[n - 1]);
    }

    private static boolean isSubsetSumNaiveDynamicProgramming(int[] set, int n, int sum) {
        boolean[][] subsetsum = new boolean[sum + 1][n + 1];

        // If sum is 0 then set true for all the subsets.
        for (int i = 0; i <= n; i++) {
            subsetsum[0][i] = true;
        }

        // If sum is not 0 and subset is empty then false.
        for (int i = 0; i <= sum; i++) {
            subsetsum[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subsetsum[i][j] = subsetsum[i][j - 1];
                if (i >= set[j - 1]) {
                    subsetsum[i][j] = subsetsum[i][j]
                            || subsetsum[i - set[j - 1]][j - 1];
                }
            }
        }

        return subsetsum[sum][n];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSumNaiveRecursive(set, n, sum) == true) {
            System.out.println("Subset sum exists");
        } else {
            System.out.println("No subset exists fot the given sum");
        }

        if (isSubsetSumNaiveDynamicProgramming(set, n, sum) == true) {
            System.out.println("Subset sum exists");
        } else {
            System.out.println("No subset exists fot the given sum");
        }
    }
}
