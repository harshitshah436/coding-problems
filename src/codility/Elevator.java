package codility;

import java.util.HashSet;

/**
 * Elevator problem.
 * 
 * A[] - weigths of person
 * B[] - floor to go.
 * (length of A and B should be same)
 * M - 
 * X - maximum capacity of person in the elevator
 * Y - maximum number of weights
 * 
 * @author Harshit
 */
public class Elevator {

     public int solution(int[] A, int[] B, int M, int X, int Y) {
         int count_stops = 0;
         int i = 0, prev_i=0;

         while (i < A.length) {
             
             int w_sum = A[i], no_p = 1;
             // O(M) || O(log(N))
             while (w_sum <= Y && no_p <= X && i < A.length) {
                 w_sum += A[i];
                 no_p++;
                 i++;
             }
             i--;

             int new_i = i;
             // Space Complexity: Maximum possible O(N)
             HashSet<Integer> hset = new HashSet<Integer>();
             // O(log(N))
             while (new_i >= prev_i) {
                 // insert into hashset(M)
                 hset.add(B[new_i]);
                 new_i--;
             }
             
             i++;
             prev_i = i;
             
             count_stops += hset.size();
             count_stops++;
         }

         return count_stops;
     }
}
