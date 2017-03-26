/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 * Reference:
 * http://traceformula.blogspot.com/2015/12/remove-duplicate-letters-leetcode.html
 *
 * good for understainding:
 * http://buttercola.blogspot.com/2016/01/leetcode-remove-duplicate-letters.html
 * https://discuss.leetcode.com/topic/31413/easy-to-understand-iterative-java-solution
 *
 * Bit pattern solution:
 * http://stackoverflow.com/questions/34476853/select-lexicographical-smallest-string-after-duplicates-removed
 *
 * @author Harshit
 */
public class RemoveDuplicateWithMaintainingLexicalOrder {

    private static String smallestString(String s) {
        char START = (char) ('a' - 1);

        if (s.length() == 0) {
            return s;
        }

        //We use 128 is to avoid substraction  
        //if we use 26, we have to substract 'a' from a char  
        int[] count = new int[128];
        char[] prev = new char[128];
        boolean[] assigned = new boolean[128];
        char c;
        char end = START;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count[c]--;
            if (assigned[c]) {
                continue;
            }

            while (end >= c && count[end] > 0) {
                assigned[end] = false;
                end = prev[end];
            }

            prev[c] = end;
            end = c;
            assigned[c] = true;
        }

        StringBuilder bd = new StringBuilder();
        while (end > START) {
            bd.append(end);
            end = prev[end];
        }
        return bd.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestString("cbacdcbc"));
        System.out.println(smallestString("thequickbrownfoxjumpsoverthelazydog"));
    }
}
