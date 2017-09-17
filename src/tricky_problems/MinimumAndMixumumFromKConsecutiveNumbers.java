package tricky_problems;

import java.util.ArrayDeque;
import java.util.Collections;

/**
 *
 * @author Harshit
 */
public class MinimumAndMixumumFromKConsecutiveNumbers {

    public static void main(String[] args) {
        int[] a = {1, 8, 8, 4, 2, 9, 8, 11};
        int k = 4;
        findSumOfMaxAndMinOfKConsecutiveNumber(a, k);
        System.out.println("");
        findSumOfMaxAndMinOfKConsecutiveNumberOptimized(a, k);
    }

    /**
     * Brute-force approach
     *
     * @param a
     * @param k
     */
    private static void findSumOfMaxAndMinOfKConsecutiveNumber(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n - k + 1; i++) {    // O(n-k)
            int max = 0, min = Integer.MAX_VALUE;
            for (int j = i; j < i + k; j++) {    // O(k)
                if (a[j] > max) {
                    max = a[j];
                }
                if (a[j] < min) {
                    min = a[j];
                }
            }
            System.out.print(max + min + ",");
        }
    }

    /**
     * ArrayDeque is more efficient than linkedList implementation in java even
     * though both implements Deque interface. Few benefits of ArrayDeque over
     * Linkedlist are ArrayDeque doesn't need to keep a track of next or
     * previous elements. So they use less memory. While inserting, removing is
     * O(1) in ArrayDeque while for LinkedList random access to element is O(1).
     *
     * Ref for the difference between ArrayDeque and LinkedList:
     * https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
     *
     * Time complexity: O(n)
     *
     * @param a
     * @param k
     */
    private static void findSumOfMaxAndMinOfKConsecutiveNumberOptimized(int[] a, int k) {
        // LinkedList<Integer> list = new LinkedList<>(); Use ArrayDeque for queue/Deque implementation.
        int n = a.length;

        DequeWithMinMax deque = new DequeWithMinMax(k);
        int i = 0;
        while (i < n) { //O(n)
            deque.insert(a[i]);
            if (i >= k - 1) {
                System.out.print(deque.max + deque.min + ",");
            }
            i++;
        }
    }

    private static class DequeWithMinMax {

        int capacity, max, min;
        ArrayDeque<Integer> deque;

        public DequeWithMinMax(int capacity) {
            this.capacity = capacity;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            deque = new ArrayDeque<>();
        }

        void insert(int i) {
            if (deque.size() == capacity) {
                remove();
            }
            deque.add(i);
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        void remove() {
            int head = deque.pop();
            if (head == max) {
                max = Collections.max(deque);
            }
            if (head == min) {
                min = Collections.min(deque);
            }
        }
    }
}
