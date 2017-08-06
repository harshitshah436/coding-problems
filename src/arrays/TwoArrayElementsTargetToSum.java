package arrays;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harshit
 */
public class TwoArrayElementsTargetToSum {

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 12};
        int[] b = {1, 5, 7, 9, 10, 11};
        System.out.println(TwoArrayElementsTargetToSumBruteForce(a, b, 5));
        System.out.println(TwoArrayElementsTargetToSumOptimized(a, b, 5));
    }

    // Optimized
    /*
            b
            1   5   7   9   10  11
       2    *   *   *   *   *   *
    a  4    *   *   *   *   *   *
       3    *   *   *   *   *   *
       6    *   *   *   *   *   *
      12    *   *   *   *   *   *
    
    
    Sorted array so take small amount of time.
    
     */
    private static boolean TwoArrayElementsTargetToSumOptimized(int[] a, int[] b, int target) {
        Arrays.sort(a);
        Arrays.sort(b);
        return TwoArrayElementsTargetToSumBruteForce(a, b, target);
    }

    static boolean TwoArrayElementsTargetToSumBruteForce(int[] batteryOne, int[] batteryTwo, int gigawattTarget) {
        // Bruteforce solution
        for (int i = 0; i < batteryOne.length; i++) {
            for (int j = 0; j < batteryTwo.length; j++) {
                if (batteryOne[i] + batteryTwo[j] == gigawattTarget) {
                    return true;
                }
            }
        }
        return false;

        // Easy approch but tricky: Store one array values in HashSet(). Then iterate throught second array and check sum-arry[i] exist in our hashset. If true return. O(n) approch.
    }
}
