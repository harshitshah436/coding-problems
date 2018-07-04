package strings;

/**
 * Check if two strings are anagram or not.
 * 
 * One naive approach is by two simple steps.
 * 
 * 1) Sort both the strings: O(n logn) 2) Compare two strings: O(n). Total
 * running time: O(n logn)
 * 
 * Following both approaches are fastest, which solve in O(n) time.
 * 
 * @author Harshit
 */
public class StringAnagrams {

    public static boolean areAnagram(String string1, String string2) {

        if (string1.length() != string2.length())
            return false;

        // Create 2 count arrays and initialize all values as 0
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int i;

        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();

        // For each character in input strings, increment count in
        // the corresponding count array
        for (i = 0; i < str1.length; i++) {
            count1[str1[i] - 97]++;
            count2[str2[i] - 97]++;
        }

        // Compare count arrays
        for (i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagram("harshitshah", "shahharshit"));
    }

}
