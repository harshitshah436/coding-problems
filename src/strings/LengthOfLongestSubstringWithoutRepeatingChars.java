/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.util.Arrays;

/**
 * 
 * Note: Longest unique substring, NOT subsequence. Ref:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 *
 * @author Harshit
 */
public class LengthOfLongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.printf("The input string is %s \n", str);
        System.out.printf(
                "The length of the longest non-repeating character substring is %d",
                longestUniqueSubsttr(str));
        System.out.println("");

        System.out.printf("The input string is %s \n", "GEEKSFORGEEKS");
        System.out.printf(
                "The length of the longest non-repeating character substring is %d",
                longestUniqueSubsttr("GEEKSFORGEEKS"));
        System.out.println("");

        System.out.printf("The input string is %s \n", "HAHARSHIT");
        System.out.printf(
                "The length of the longest non-repeating character substring is %d",
                longestUniqueSubsttr("HAHARSHIT"));
        System.out.println("");
    }

    /*
     * Sliding Window approach
     */
    private static int longestUniqueSubsttr(String str) {
        // Assuming ASCII 128
        int[] index = new int[128];
        Arrays.fill(index, -1); // Fill arrays with -1 value
        int max_sub_len = 0;

        for (int i = 0, j = 0; i < str.length(); i++) {
            // if char is already exist then increase j
            if (index[str.charAt(i)] != -1) {
                j = Math.max(index[str.charAt(i)] + 1, j);
            }
            index[str.charAt(i)] = i; // store index of char
            max_sub_len = Math.max(max_sub_len, i - j + 1);
        }
        return max_sub_len;
    }
}
