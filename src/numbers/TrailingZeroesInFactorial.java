/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

/**
 *
 * @author Harshit
 */
public class TrailingZeroesInFactorial {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroes(100));
    }
    
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
