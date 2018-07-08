package basics.java;

/**
 * This class represents useful java shortcuts for coding.
 *
 * @author Harshit
 */
public class UsefulOperations {

    public static void main(String[] args) {
        String str = "123742";

        // Check if a given string is a number (contains only digit)
        boolean bool = str.chars().allMatch(Character::isDigit);
        System.out.println(bool);
    }
}
