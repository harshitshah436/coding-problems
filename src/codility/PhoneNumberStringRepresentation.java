package codility;

/**
 * String representing a phone number
 * 
 * Any number would be in a format: XXX-XXX-XXX or XXX-XXX-XX or XXX-XX-XX.
 * 
 * Last two or one representation should be two letters. All others should
 * contain 3 letters.
 * 
 * @author Harshit
 */
public class PhoneNumberStringRepresentation {

    public String solution(String S) {
        // write your code in Java SE 8
        S = S.replaceAll("-", "");
        S = S.replaceAll("\\s", "");
        int length = S.length();
        int remainder = length % 3;

        int multiplier = 1;
        if (remainder == 1) {
            while (length > 0) {
                int product = multiplier * 3;
                length -= 3;
                product += multiplier - 1;
                multiplier++;
                if (length == 1) {
                    product -= 1;
                }
                if (length > 0) {
                    S = S.substring(0, product) + "-"
                            + S.substring(product, S.length());
                }
            }
        } else {
            while (length > 0) {
                int product = multiplier * 3;
                length -= 3;
                product += multiplier - 1;
                multiplier++;
                if (length > 0) {
                    S = S.substring(0, product) + "-"
                            + S.substring(product, S.length());
                }
            }
        }
        return S;
    }
}
