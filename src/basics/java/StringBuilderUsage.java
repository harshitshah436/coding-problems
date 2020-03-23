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
            // Use of indexOf method
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

        StringBuilder sb = new StringBuilder();
        // Default StringBuilder capacity - 16
        System.out.println(sb.capacity());
        sb.append("Aarshit");
        System.out.println(sb.capacity());

        // Reverse the string using StringBuilder
        System.out.println(sb.reverse());
        System.out.println(sb);

        // Unicode char value (ASCII)
        System.out.println(sb.codePointAt(0) + "  " + sb.codePointAt(1));
        // All char Unicode values
        sb.chars().mapToObj(p -> p + " ").forEach(System.out::print);
//        sb.chars().forEach(System.out::println);        

        // Other methods are same as String class: length(), substring(i),
        // substring(i,i), charAt(i)
    }
}
