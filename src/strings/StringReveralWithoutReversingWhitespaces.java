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
public class StringReveralWithoutReversingWhitespaces {

    public static void main(String[] args) {
        String str = "I am     harshit [shah]. It's been a good day";
        System.out.println(str);
        System.out.println(StringReveralWithoutWhitespaces(str));
    }

    /*
     * You can use StringBuilder instead of result nd characters strings and
     * directly use an inbuilt function reverse.
     */
    private static String StringReveralWithoutWhitespaces(String str) {
        String result = "";
        String characters = "";
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isWhitespace(charArray[i])) {
                if (!characters.isEmpty()) {
                    char[] temp = characters.toCharArray();
                    for (int j = 0; j < temp.length / 2; j++) {
                        char cTemp = temp[j];
                        temp[j] = temp[temp.length - j - 1];
                        temp[temp.length - j - 1] = cTemp;
                    }
                    characters = String.valueOf(temp);
                }
                result += characters + charArray[i];
                characters = "";
            } else {
                characters += charArray[i];
            }
        }
        return result + characters;
    }
}
