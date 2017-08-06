package basics.problem_solving;


import java.util.ArrayList;

/**
 * This code is to get all possible string combinations or subsequences and NOT
 * permutations.
 *
 * Example: String-"arc", combinations/subsequences: {"", "a", "ac", ... ,"arc"}
 * but not "car". in permutations "car" and "arc" are different words.
 *
 * @author Harshit
 */
public class StringAllCombinationsOrSebsequences {

    /**
     * Recursive solution. This is fastest
     *
     * Time Complexity: O(n * n!).
     *
     * @param str
     * @return
     */
    public static ArrayList<String> allCombinations(String suffix, String prefix, ArrayList<String> list) {
        int n = prefix.length();
        if (n < 0) {
            return null;
        }
        list.add(suffix);
        for (int i = 0; i < n; i++) {
            allCombinations(suffix + prefix.charAt(i), prefix.substring(i + 1), list);
        }
        return list;
    }

    /**
     * Using bit manipulations.
     *
     * Time Complexity: O(n * 2n).
     *
     * @param string
     * @return
     */
    public static ArrayList<String> allCombinations(String string) {
        ArrayList<String> list = new ArrayList<>();
        int n = string.length();
        for (int i = 0; i < (1 << n); i++) {  // O(2^n); 1<<n = 2^n
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {    // O(n)
                if ((i & (1 << j)) != 0) {  // This step is important
                    sb.append(string.charAt(j));
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    /**
     * Using bit manipulations. This is bit faster
     *
     * Time Complexity: O(n * 2n).
     *
     * @param string
     * @return
     */
    public static ArrayList<String> allCombinations1(String string) {
        ArrayList<String> list = new ArrayList<>();
        int n = string.length();
        for (int i = 0; i < (1 << n); i++) {  // O(2^n); 1<<n = 2^n
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int j = i; j > 0; j >>= 1) {    // O(n) See this. only in worst case o(n)
                if ((j & 1) != 0) {  // This step is important
                    sb.append(string.charAt(index));
                }
                index++;
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        String string = "arc";
        ArrayList<String> list = new ArrayList<>();
        list = allCombinations("", string, list);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("===================");
        list = allCombinations(string);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("===================");
        list = allCombinations1(string);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
