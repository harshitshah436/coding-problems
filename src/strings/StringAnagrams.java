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
        
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

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

    public static boolean areAnagram1(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Create a frequency/count array and initialize all values with 0
        char[] freq = new char[26];
        
        // For input strings, increase count for one string and decrease for
        // another.
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.codePointAt(i) - 97]++;
            freq[str2.codePointAt(i) - 97]--;
        }

        // Check any non-zero value
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagram("harshitshah", "shahharshit"));
        System.out.println(areAnagram1("harshitshah", "shahharshit"));
    }

}
