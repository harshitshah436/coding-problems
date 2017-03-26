/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

import java.util.Scanner;

/**
 *
 * @author Harshit
 */
public class ReverseStringCapitalize {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = Integer.parseInt(in.nextLine());

        //for (int j = 0; j < n; j++) {
        //  String input = in.nextLine();
        String input = "Hello World";

        String result = "";
        int i;
        for (i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                result += reverseCapitalize(input.substring(0, i)) + input.charAt(i);
                input = input.substring(i + 1, input.length());
                i = -1;
            }
        }

        result += reverseCapitalize(input.substring(0, i));

        System.out.println(result);

        //}
    }

    public static String reverseCapitalize(String s) {
        int n = s.length();
        char[] temp = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char c = temp[i];
            temp[i] = temp[n - i - 1];
            temp[n - i - 1] = c;
        }

        temp[0] = Character.toUpperCase(temp[0]);
        temp[n-1] = Character.toLowerCase(temp[n-1]);
        return new String(temp);
    }
}
