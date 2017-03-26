package codility;

/** 
 * A small frog wants to get to the other side of a pond. The frog is 
 * initially located on one bank of the pond (position 0) and wants to get 
 * to the other bank (position X). The frog can jump any (integer) distance 
 * between 1 and D. If X > D then the frog cannot jump right across the 
 * pond. Luckily, there are leaves falling from a tree onto the surface of 
 * the pond, and the frog can jump onto and from the leaves.<br/><br/> 
 * 
 * You are given a zero-indexed array A consisting of N integers. This 
 * array represents falling leaves. Initially there are no leaves. A[K] 
 * represents the position where a leaf will fall in second K.<br/><br/> 
 * 
 * The goal is to find the earliest time when the frog can get to the other 
 * side of the pond. The frog can jump from and to positions 0 and X (the 
 * banks of the pond) and every position with a leaf.<br/><br/> 
 * 
 * For example, you are given integers X = 7, D = 3 and array A such that:<br/> 
 * 
 * <pre>{@code 
 * A[0] = 1 
 * A[1] = 3 
 * A[2] = 1 
 * A[3] = 4 
 * A[4] = 2 
 * A[5] = 5 
 * }</pre> 
 * 
 * Initially, the frog cannot jump across the pond in a single jump. 
 * However, in second 3, after a leaf falls at position 4, it becomes 
 * possible for the frog to cross. This is the earliest moment when the 
 * frog can jump across the pond (by jumps of length 1, 3 and 3). <br/><br/> 
 * 
 * {@code 
 *         class Solution { public int solution(int[] A, int X, int D); } 
 * }<br/><br/> 
 * 
 * that, given a zero-indexed array A consisting of N integers, and 
 * integers X and D, returns the earliest time when the frog can jump to 
 * the other side of the pond. If the frog can leap across the pond in just 
 * one jump, the function should return 0. If the frog is never able to 
 * jump to the other side of the pond, the function should return -1.<br/><br/> 
 * 
 * For example, given X = 7, D = 3 and array A such that: 
 * 
 * <pre>{@code 
 * A[0] = 1 
 * A[1] = 3 
 * A[2] = 1 
 * A[3] = 4 
 * A[4] = 2 
 * A[5] = 5 
 * }</pre> 
 * 
 * the function should return 3 as explained above.<br/><br/> 
 * 
 * Assume that:<br/> 
 * - N is an integer within the range [0..100,000];<br/> 
 * - X and D are integers within the range [1..100,000];<br/> 
 * - each element of array A is an integer within the range [1..X-1].<br/><br/> 
 * 
 * Complexity:<br/> 
 * - expected worst-case time complexity is O(N);<br/> 
 * - expected worst-case space complexity is O(X), beyond input 
 * storage (not counting the storage required for input arguments).<br/><br/> 
 * 
 * Elements of input arrays can be modified.<br/><br/> 
 * 
 */

/**
 * Coding test to find out smallest time when the frog can jump the pond.
 * 
 * @author Harshit
 */
class FrogAndPond {

    /*
     * Time complexity: O(N) Space complexity: O(X)+1 ~ O(X)
     */
    public int solution(int[] A, int X, int D) {

        // If a distance accross the pond is less than one jump then return 0.
        if (X <= D) {
            return 0;
        }

        // Initialize leaves array of size X with 0 value to monitor the leaves
        // at respective position.
        int[] leaves = new int[X];

        // Current position variable with 0 as a starting position of the frog.
        int cur_pos = 0;

        for (int i = 0; i < A.length; i++) {

            // Increment respective leaf position.
            leaves[A[i]]++;

            // If current position is less than A[i] means the position of the
            // leaf and current position plus the maximum jump achieved is equal
            // to or higher than A[i].
            if (cur_pos < A[i] && cur_pos + D >= A[i]) {
                // Check if a leaf is present at respective location to make a
                // jump.
                if (leaves[A[i] - cur_pos] > 0)
                    cur_pos = A[i];
            }

            // Check if the frog is reached to otherside or not.
            if (cur_pos + D >= X) {
                // If a frog crossed the pond just in one jump then return 0.
                if (i == 0)
                    return 0;
                else
                    return i;
            }
        }

        // Return -1 if the frog cannot make it to other side.
        return -1;
    }

    public int solution1(int[] A, int X, int D) {

        // Base case when X is less than or equal to D then frog can jump
        // right across the pond in 0 seconds.
        if (X <= D) {
            return 0;
        }

        // Initialize current distance variable.
        int distance = 0;

        for (int time = 0; time < A.length; time++) {
            // Update distance to current position of leaf if any of the
            // below condition is satisfied. Check current position is
            // greater than distance if current position is less than or
            // equal to D or current position is greater than D and less
            // than or equall to distance + D
            if ((A[time] <= D && A[time] > distance)
                    || (A[time] > D && A[time] <= (distance + D))) {
                distance = A[time];
            }

            // Verify if the frog can jump the pond at current time.
            if (distance + D >= X) {
                return time;
            }

        }

        // Return -1 if frog can not jump in any conditions.
        return -1;
    }
}