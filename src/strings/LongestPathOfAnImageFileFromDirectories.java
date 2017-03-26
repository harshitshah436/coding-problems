/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 * Google interview question
 *
 * Ref:http://qa.geeksforgeeks.org/6922/google-interview-question-question-google-interview-solution
 *
 * @author Harshit
 */
public class LongestPathOfAnImageFileFromDirectories {

    public static void main(String[] args) {
        String s = "dir1\n"
                + " dir11\n"
                + " dir12\n"
                + "  picture.jpeg\n"
                + "  dir 121\n"
                + "   file1.txt\n"
                + "dir2\n"
                + " file2.gif";
        System.out.println(printSum(s));
    }

    public static int printSum(String s) {
        String[] arr = s.split("\n");
        int sum = 0, spaces = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            String line = arr[i];
            if (line.contains(".gif") | line.contains(".jpeg")) {
                spaces = line.length() - line.trim().length();
            }
            if (spaces > line.length() - line.trim().length()) {
                sum += line.trim().length() + 1;
                spaces--;
            }
        }
        return sum;
    }

}
