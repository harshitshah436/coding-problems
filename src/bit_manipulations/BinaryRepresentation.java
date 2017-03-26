/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bit_manipulations;

/**
 *
 * @author Harshit
 */
public class BinaryRepresentation {

    /**
     * Convert into 32 bit binary integer.
     *
     * @param i
     */
    private static void bin(int n) {

        // Casted long because unsigned int is not supported in java.
        for (long i = (long) 1 << 31; i > 0; i = i / 2) {
            System.out.print((n & i) > 0 ? 1 : 0);
        }
    }

    private static void binRecursive(int n) {
        if (n > 1) {
            binRecursive(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        bin(7);
        System.out.println("");
        bin(4);
        System.out.println("");
        System.out.println("----recursive-----");
        binRecursive(7);
        System.out.println("");
        binRecursive(4);
        System.out.println("");
    }
}
