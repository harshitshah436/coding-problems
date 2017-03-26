/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * @author Harshit
 */
public class ReverseWordsOfStringNotCharacters {

    public static String reverseWords(String s) {
        String[] s_array = s.split("\\s+");
        String result = "";
        for (int i = s_array.length - 1; i >= 0; i--) {
            result += s_array[i] + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        String s = "   harshit   shah ";
        System.out.println(reverseWords(s));

    }
}
