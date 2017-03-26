/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

/**
 *
 * Solution to LPS problem into two possible way. Find out the longest
 * palindromic subsequence in the given string.
 *
 * 1) Naive Recursive Solution
 *
 * 2) Dynamic Programming
 *
 * Concept Ref: https://www.youtube.com/watch?v=U4yPae3GEO0
 *
 * @author Harshit
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "BBABCBCAB";
        int lpsR = lpsRecursive(str);
        System.out.println("Recursive Method:" + lpsR);
        int lpsD = lpsDynamicProgramming(str);
        System.out.println("Recursive Method:" + lpsD);
    }

    private static int lpsRecursive(String str) {

        char[] chars = str.toCharArray();
        int startIndex = 0;
        int endIndex = chars.length;

        if (startIndex == endIndex - 1) {
            return 1;
        }

        if (chars[startIndex] == chars[endIndex - 1]) {
            return lpsRecursive(str.substring(startIndex + 1, endIndex - 1)) + 2;
        } else {
            return Math.max(lpsRecursive(str.substring(startIndex + 1, endIndex)), lpsRecursive(str.substring(startIndex, endIndex - 1)));
        }
    }

    private static int lpsDynamicProgramming(String str) {
        int n = str.length();
        int[][] L = new int[n][n];

        // All substrings of length 1 are palindromes.
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        int j;
        for (int cur_len = 2; cur_len <= n; cur_len++) {
            for (int i = 0; i < n - cur_len + 1; i++) {
                j = i + cur_len - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = Math.max(L[i+1][j], L[i][j-1]);
                }
            }
        }

        return L[0][n - 1];
    }
}
