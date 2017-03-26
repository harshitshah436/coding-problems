package codility;

/**
 * A binary gap within a positive integer N is any maximal sequence of
 * consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N. For example, number 9 has binary representation 1001 and
 * contains a binary gap of length 2. The number 529 has binary representation
 * 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of
 * length 1. The number 15 has binary representation 1111 and has no binary
 * gaps.
 * 
 * Write a function: class Solution { public int solution(int N); } that, given
 * a positive integer N, returns the length of its longest binary gap. The
 * function should return 0 if N doesn't contain a binary gap.
 * 
 * For example, given N = 1041 the function should return 5, because N has
 * binary representation 10000010001 and so its longest binary gap is of length
 * 5.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..2,147,483,647]. Complexity:
 * 
 * expected worst-case time complexity is O(log(N)); expected worst-case space
 * complexity is O(1).
 */

public class BinaryGap {
    /*
     * Solution approach 1: simple approach.
     */
    public int solution(int N) {

        String binaryNum = Integer.toBinaryString(N);

        int count = 0, maxCount = 0;
        boolean startCount = false;
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '1') {
                startCount = true;
                if (startCount) {
                    if (count > maxCount)
                        maxCount = count;
                    count = 0;
                }
            }
            if (startCount && binaryNum.charAt(i) == '0')
                count++;
        }
        return maxCount;
    }

    /*
     * Approach 2: converting and counting to one by one binary digit.
     */
    public int solution1(int N) {
        int max_gap = 0;
        int current_gap = 0;

        // Skip the tailing zero(s)
        while (N > 0 && N % 2 == 0)
            N /= 2;

        while (N > 0) {
            int remainder = N % 2;
            if (remainder == 0)
                // Inside a gap
                current_gap += 1;
            else {
                // Gap ends
                if (current_gap != 0) {
                    max_gap = Math.max(current_gap, max_gap);
                    current_gap = 0;
                }
            }
            N /= 2;
        }
        return max_gap;
    }
}
