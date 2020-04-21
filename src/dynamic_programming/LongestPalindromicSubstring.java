package dynamic_programming;

/**
 *
 * Solution to Longest Palindromic Substring in the given string. Not it's not a
 * subsequence.
 *
 *
 * Concept Ref:
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 *
 * @author Harshit
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "BBABCBCAB";
        String lps = lpsDynamicProgramming(str);
        System.out.println(
                "The longest palindromic substring of the given string " + str
                        + " is : " + lps);
    }

    private static String lpsDynamicProgramming(String str) {
        int len = str.length();
        boolean[][] table = new boolean[len][len];
        int max = 0, start = 0;

        // Check substring of length 1
        for (int i = 0; i < len; i++) {
            table[i][i] = true;
            max = 1;
        }

        // Check substring of length 2
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                max = 2;
                start = i;
            }
        }

        // Check for the length greater than 2. k is the length of the substring
        for (int k = 3; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) { // fix starting index
                int j = i + k - 1; // end index of the substring of size k
                // checking for sub-string from ith index to jth index iff
                // str[i+1] to str[j-1] is a palindrome
                if (str.charAt(i) == str.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    if (k > max) {
                        max = k;
                        start = i;
                    }
                }
            }
        }

        return str.substring(start, start + max);
    }
}
