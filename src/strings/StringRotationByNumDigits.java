/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * Check if string is rotated by another string in anti clockwise direction.
 *
 * @author Harshit
 */
public class StringRotationByNumDigits {

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";
        int rotation_num = StringRotatedBy(str1, str2);
        System.out.println(rotation_num);
        
        str1 = "abcde";
        str2 = "decab";
        rotation_num = StringRotatedBy(str1, str2);
        System.out.println(rotation_num);
    }

    private static int StringRotatedBy(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return -1;
        }
        int n = str1.length();
        int rotation_count = 0;
        for (int i = n - 1; i >= 0; i--) {
            str2 = str2.charAt(n-1) + str2.substring(0, n-1);
            rotation_count++;
            if (str1.equals(str2)) {
                return rotation_count;
            }
        }
        return -1;
    }
}
