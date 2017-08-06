package tricky_problems;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * Given an expression consisting of only '<' and '>' characters with maximum
 * replacements allowed. Find out if given expression is balanced or not. Note:
 * you are only allowed to replace '>' with '<>' to make expression balanced.
 *
 * Example: Input: "<<>>", maxReplacements = 2. Output: Balanced Explanation:
 * <<>> is already balanced, so no need to replace any character.
 *
 * Input2: "<>>>", maxReplacement = 1 Now replace '>' with '<>' so our string
 * becomes, "<<>>>" Output: not balance. If maxReplacement =2 then we could have
 * make it balanced.
 *
 * @author Harshit
 */
public class ExpressionBalancedOrNot {

    public static void main(String[] args) {
        String[] expressions = {"<>>>", "<>>>>"};
        int[] maxReplacements = {2, 2};
        int[] result = balancedOrNot(expressions, maxReplacements);
        for (int i = 0; i < result.length; i++) {
            System.out.println(expressions[i] + " : " + (result[i] == 0 ? "Not balanced" : "Balanced"));
        }

        System.out.println("======================");

        System.out.println(isBalanced(">><<", 0, 0));
    }

    public static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] result = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            String expression = expressions[i];
            int maxReplacement = maxReplacements[i];
            if (isBalanced(expressions[i])) {
                result[i] = 1;
            } else {
                boolean balanced = false;
                while (maxReplacement > 0) {
                    int index = expression.indexOf('>');
                    if (index != -1) {
                        expression = expression.substring(0, index) + "<>"
                                + expression.substring(index + 1, expression.length());
                        if (isBalanced(expression)) {
                            balanced = true;
                            break;
                        }
                    } else {
                        break;
                    }
                    maxReplacement--;
                }

                result[i] = balanced ? 1 : 0;
            }
        }
        return result;
    }

    /**
     * Iterative solution
     *
     * @param exp
     * @return
     */
    public static boolean isBalanced(String exp) {
        int n = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '<') {
                n++;
            } else {
                if (n == 0) {
                    return false;
                }
                n--;
            }
        }
        return n == 0;
    }

    /**
     * Using Recursive Solution
     *
     * @param exp
     * @return
     */
    public static boolean isBalanced(String s, int start, int sum) {
        if (start == s.length()) {
            return sum == 0;
        }
        if (sum < 0) {
            return false;
        }
        if (s.charAt(start) == '<') {
            return isBalanced(s, start + 1, sum + 1);
        }
        if (s.charAt(start) == '>') {
            return isBalanced(s, start + 1, sum - 1);
        }
        return isBalanced(s, start + 1, sum);
    }

}
