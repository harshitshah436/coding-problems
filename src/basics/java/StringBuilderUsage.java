package basics.java;

/**
 * When you concat multiple strings with some variable. Example: "abc" + val +
 * "def" + val2 in that case use StringBuilder. Java's string also uses
 * StringBuilder internally. So concating this strings it will use 4 different
 * string builders.
 *
 * When we don't know the size of chars in resultant string in that case also we
 * can use string builder to create a string.
 *
 * @author Harshit
 */
public class StringBuilderUsage {

    public static String getUniqueStringUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Suppose we want to make a string of Unique chars we don't know the 
        // size of resultant string.
        String s = "harshitshah";
        s = getUniqueStringUsingStringBuilder(s);
        System.out.println(s);
    }
}
