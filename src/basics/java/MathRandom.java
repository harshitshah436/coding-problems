package basics.java;

/**
 * Math.random() returns a value greater than or equal to 0.0 and less than 1.0.
 *
 * @author Harshit
 */
public class MathRandom {

    public static void main(String[] args) {
        // Random number between 0 to 100.
        int num = (int) (Math.random() * 101);
        System.out.println(num);

        // Random number between 10 to 20.
        int range = (20 - 10) + 1;
        num = (int) (Math.random() * range + 10);
        System.out.println(num);
    }
}
