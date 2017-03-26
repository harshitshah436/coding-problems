package strings;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harshit
 */
public class StringPalindromeSubstrings {

    // This needs to be updated. Not an optimal solution.
    public static void main(String[] args) {
        String str = "geek";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                if (isPalindrome(str.substring(i, j))) {
                    
                    // Use set to display distict elements.
                    System.out.println(str.substring(i, j));
                }
            }
        }

    }

    static boolean isPalindrome(String str) {
        char[] temp = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            if (temp[i] != temp[temp.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
