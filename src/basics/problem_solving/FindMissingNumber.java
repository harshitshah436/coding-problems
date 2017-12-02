package basics.problem_solving;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1
 * to n. There are no duplicates in list. One of the integers is missing in the
 * list. Write an efficient code to find the missing integer.
 *
 * @author Harshit
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5, 6};
        int miss = getMissingNo(a);
        System.out.println(miss);

        miss = getMissingNoByXOR(a);
        System.out.println(miss);
    }

    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param a
     * @return
     */
    private static int getMissingNo(int[] a) {
        int n = a.length + 1;   // remeber this step: increase number by 1 as one number is missing.
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < a.length; i++) {
            sum -= a[i];
        }
        return sum;
    }

    /**
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param a
     * @return
     */
    private static int getMissingNoByXOR(int[] a) {

        // XOR of all array elements
        int x1 = a[0];
        for (int i = 1; i < a.length; i++) {
            x1 = x1 ^ a[i];
        }

        // XOR of elements upto n;
        int n = a.length + 1;   // remeber this step: increase number by 1 as one number is missing.
        int x2 = 1;
        for (int i = 2; i <= n; i++) {
            x2 = x2 ^ i;
        }

        // XOR of x1 and x2 gives the missing number.
        return x1 ^ x2;
    }
}
