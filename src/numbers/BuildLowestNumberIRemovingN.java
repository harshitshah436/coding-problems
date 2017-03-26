/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

/**
 * 
 * Concept Ref: http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 *
 * @author Harshit
 */
public class BuildLowestNumberIRemovingN {

    public static void main(String[] args) {
        System.out.println(BuildLowestNumberIterative("25874663", 4));
        System.out.println(BuildLowestNumberIterative("4325043", 3));
        System.out.println(BuildLowestNumberIterative("12234567", 3));
        System.out.println(BuildLowestNumberIterative("765028321", 5));
        System.out.println(BuildLowestNumberIterative("121198", 2));
        System.out.println("======================");
        System.out.println(BuildLowestNumberRecursive("25874663", 4, ""));
        System.out.println(BuildLowestNumberRecursive("4325043", 3, ""));
        System.out.println(BuildLowestNumberRecursive("12234567", 3, ""));
        System.out.println(BuildLowestNumberRecursive("765028321", 5, ""));
        System.out.println(BuildLowestNumberRecursive("121198", 2, ""));
    }

    private static String BuildLowestNumberIterative(String str, int n) {
        String result = "";
        while (n > 0 && str.length() > n) {
            int min_idx = 0;
            for (int i = 1; i <= n; i++) {
                if (str.charAt(i) < str.charAt(min_idx)) {
                    min_idx = i;
                }
            }
            result += String.valueOf(str.charAt(min_idx));
            str = str.substring(min_idx + 1);
            n = n - min_idx;
        }
        return n > 0 ? result : result + str;
    }

    private static String BuildLowestNumberRecursive(String str, int n, String result) {

        if (n == 0) {
            result += str;
            return result;
        }

        if (str.length() <= n) {
            return result;
        }

        int min_idx = 0;
        for (int i = 1; i <= n; i++) {
            if (str.charAt(i) < str.charAt(min_idx)) {
                min_idx = i;
            }
        }

        result += str.charAt(min_idx);

        return BuildLowestNumberRecursive(str.substring(min_idx + 1), n - min_idx, result);
    }
}
