package numbers;

public class ConvertDecimal {

    public void convert(int decimal, int base) {
        int result = 0;
        int multiplier = 1;

        while (decimal > 0) {
            int remainder = decimal % base;
            decimal = decimal / base;
            result = result + remainder * multiplier;
            multiplier = multiplier * 10;
        }

        System.out.println("binary....." + result);
    }

    public void toHex(int num) {
        // For storing remainder
        int rem;

        // For storing result
        String str2 = "";

        // Digits in hexadecimal number system
        char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };

        while (num > 0) {
            rem = num % 16;
            str2 = hex[rem] + str2;
            num = num / 16;
        }
        System.out.println("Method 2: Decimal to hexadecimal: " + str2);
    }

    public static void main(String args[]) {
        ConvertDecimal conv = new ConvertDecimal();
        conv.convert(128, 2);
    }
}