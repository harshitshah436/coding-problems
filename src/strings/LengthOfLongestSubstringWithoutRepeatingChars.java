/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 * 
 * See algo to store indexes and counting the current length of the substring.
 * Ref: http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *
 * @author Harshit
 */
public class LengthOfLongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.printf("The input string is %s \n", str);
        System.out.printf("The length of the longest non-repeating character substring is %d", longestUniqueSubsttr(str));
        System.out.println("");

        System.out.printf("The input string is %s \n", "GEEKSFORGEEKS");
        System.out.printf("The length of the longest non-repeating character substring is %d", longestUniqueSubsttr("GEEKSFORGEEKS"));
        System.out.println("");

        System.out.printf("The input string is %s \n", "HAHARSHIT");
        System.out.printf("The length of the longest non-repeating character substring is %d", longestUniqueSubsttr("HAHARSHIT"));
        System.out.println("");
    }

    private static int longestUniqueSubsttr(String str) {
        int[] arr = new int[256];
        int max_sub_len = 1, cur_sub_len = 1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        arr[str.charAt(0)] = 0;

        for (int i = 1; i < str.length(); i++) {

            char ch = str.charAt(i);
            int prev_inx = arr[str.charAt(i)];

            if (prev_inx == -1 || i - cur_sub_len > prev_inx) {
                cur_sub_len++;
            } else {
                if (cur_sub_len > max_sub_len) {
                    max_sub_len = cur_sub_len;
                }
                cur_sub_len = i - prev_inx;
            }
            arr[str.charAt(i)] = i;
        }

        if (cur_sub_len > max_sub_len) {
            max_sub_len = cur_sub_len;
        }

        return max_sub_len;
    }
}
