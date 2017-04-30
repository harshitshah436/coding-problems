/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

import java.util.ArrayList;

/**
 * Power Set returns all subsets of a set. For example, Set: {0, 1, 2},
 * Subsets:{}, {0}, {1}, {0, 1}, {2}, {0, 2}, {1, 2}, {0, 1, 2}
 *
 * @author Harshit
 */
public class PowerSet {

    /**
     * Using Bit manipulations. (Note: this is valid only for power set, not for
     * any arbitrary set)
     *
     * Time Complexity: O(n * 2^n)
     *
     * @param set
     * @return
     */
    private static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        int max = 1 << set.size(); // Find max size/ number of elements of subsets.
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < max; i++) { // O(n) time.
            ArrayList<Integer> subset = new ArrayList<>();
            int index = 0;
            for (int j = i; j > 0; j >>= 1) {  // O(2^n) time.
                if ((j & 1) == 1) {
                    subset.add(set.get(index));
                }
                index++;
            }
            subsets.add(subset);
        }
        return subsets;
    }

    /**
     * Recursive solution.
     *
     * Time Complexity: O(n * 2^n)
     *
     * @param set
     * @param index
     * @return
     */
    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        if (set.size() == index) {
            subsets.add(new ArrayList<>());
        } else {
            subsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> new_subsets = new ArrayList<>();
            for (ArrayList<Integer> sset : subsets) {
                ArrayList<Integer> current_subset = new ArrayList<>();
                current_subset.addAll(sset);
                current_subset.add(item);
                new_subsets.add(current_subset);
            }
            subsets.addAll(new_subsets);
        }

        return subsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            set.add(i);
        }

        ArrayList<ArrayList<Integer>> subsets = getSubsets2(set);
        System.out.println(subsets.toString());

        subsets = getSubsets(set, 0);
        System.out.println(subsets.toString());
    }
}
