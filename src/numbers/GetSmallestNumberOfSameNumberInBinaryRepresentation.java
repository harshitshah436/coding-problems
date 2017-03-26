package numbers;


/**
 * Commvault: Written test
 *
 * @author Harshit
 */
public class GetSmallestNumberOfSameNumberInBinaryRepresentation {

    public static void main(String[] args) {
        int N = 25;
        System.out.println(getSmallestNumber(N));
    }

    private static int getSmallestNumber(int n) {

        int result = -1;

        String bin = Integer.toBinaryString(n);

        int count_1 = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                count_1++;
            }
        }

        while (n > 0) {
            n--;
            bin = Integer.toBinaryString(n);
            int count_temp = 0;
            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
                    count_temp++;
                }
            }
            if (count_temp == count_1) {
                result = n;
                break;
            }
        }

        return result;
    }

}
