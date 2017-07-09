package java_basics;

/**
 * Java Enum examples for enum declaration, enum with values, declaring in a
 * class and separately.
 *
 * For good reading:
 * https://crunchify.com/why-and-for-what-should-i-use-enum-java-enum-examples/
 *
 * @author Harshit
 */
public class EnumExample {

    public static void main(String[] args) {
        // Enum usage
        for (RGYB color : RGYB.values()) {
            System.out.println(color + "   " + color.ordinal());
        }
        for (SomeType type : SomeType.values()) {
            System.out.println(type + " " + type.value);
        }
        if (Color.Blue.code == 'B') {
            System.out.println("True");
        }
    }

    public enum RGYB {
        R, G, Y, B
    }

    public enum SomeType {
        Harshit(11), Naisu(271), Lay(277);

        int value;

        SomeType(int value) {
            this.value = value;
        }
    }
}

enum Color {
    Red('R'), Green('G'), Yellow('Y'), Blue('B');

    char code;

    Color(char c) {
        code = c;
    }
}
