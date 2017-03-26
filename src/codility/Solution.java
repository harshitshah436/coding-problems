package codility;

//you can also use imports, for example:
//import java.util.*;
import java.util.HashSet;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int count_stops = 0;
        int i = 0, prev_i = 0;

        while (i < A.length) {

            int w_sum = A[i], no_p = 1;
            // O(M) || O(log(N))
            while (w_sum <= Y && no_p <= X && i < A.length) {
                System.out.println("in" + i);
                w_sum += A[i];
                no_p++;
                i++;
            }
            i--;
            System.out.println("out" + i);

            int new_i = i;
            HashSet<Integer> hset = new HashSet<Integer>();
            // O(log(N))
            while (new_i >= prev_i) {
                // insert into hashset(M)
                hset.add(B[new_i]);
                new_i--;
            }

            i++;
            prev_i = i;

            System.out.println(hset.size());

            count_stops += hset.size();
            count_stops++;
        }

        return count_stops;
    }
}