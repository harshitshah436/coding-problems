/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Method 4,5 are interesting based on 2x2 matrix multiplication with itself.
 *
 * @author Harshit
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibRecursive(n));
        System.out.println(fibDynamicProgramming(n));
        System.out.println(fibDynamicProgrammingMoreOptimized(n));
    }

    /**
     * Only store previous two numbers instead of dynamic array.
     *
     * Time Complexity: O(n) Space complexity: O(1)
     *
     * @param n
     * @return
     */
    private static int fibDynamicProgrammingMoreOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 0, prev_1 = 1, prev_2 = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = fib;
        }
        return fib;
    }

    /**
     * Time complexity: o(n) Space complexity: o(n)
     *
     * @param n
     * @return
     */
    private static int fibDynamicProgramming(int n) {

        // array to store fibonacci number
        int f[] = new int[n + 1];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /**
     * Complexity: exponential (O (2^n))
     *
     * @param n
     * @return
     */
    private static int fibRecursive(int n) {
        if (n < -1) {
            return -1;
        }
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}
