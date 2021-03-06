package basics.problem_solving;

import java.util.ArrayList;

/**
 *
 * @author Harshit
 */
public class StringAllPermutationsOrAnagrams {

    /**
     * O (n * n!) complexity.
     *
     * Easy to understand and code.
     *
     * @param prefix
     * @param suffix
     * @param list
     * @return
     */
    public static ArrayList<String> allPermuatations(String prefix, String suffix, ArrayList<String> list) {
        int n = suffix.length();
        if (n == 0) {
            list.add(prefix);
        }
        for (int i = 0; i < n; i++) {
            allPermuatations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), list);
        }
        return list;
    }

    /**
     * Another method for anagrams:
     *
     * Time Complexity: O(n * n!).
     *
     * Ref:
     * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
     *
     * @param str
     * @param left
     * @param right
     * @param list
     * @return
     */
    public static ArrayList<String> allPermuatations(String str, int left, int right, ArrayList<String> list) {
        if (left == right) {
            list.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                allPermuatations(str, left + 1, right, list);
                str = swap(str, left, i); // backtracking
            }
        }
        return list;
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String string = "arc";
        ArrayList<String> list = new ArrayList<>();
        list = allPermuatations("", string, list);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("===================");

        list = new ArrayList<>();
        list = allPermuatations(string, 0, string.length() - 1, list);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("===================");
    }

}
