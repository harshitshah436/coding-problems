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
public class StringReversal {

    public static void main(String[] args) {
        String reverse = StringReversal("Hello");
        System.out.println(reverse);
        
        reverse = StringReversal("Hell");
        System.out.println(reverse);
    }

    public static String StringReversal(String str) {
        char[] result = str.toCharArray();
        int length = str.length()-1;
        for (int i = 0; i <= length / 2; i++) {
            char temp = result[i];
            result[i] = result[length - i];
            result[length - i] = temp;
        }
        return String.valueOf(result);
    }
}
