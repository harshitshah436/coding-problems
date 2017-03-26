/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.*;

/**
 * 
 * Ref: https://discuss.leetcode.com/topic/30572/share-some-thoughts/2
 * Other ref: https://discuss.leetcode.com/topic/30956/two-o-n-solutions/20
 *
 * @author Harshit
 */
public class FindMinHeightVertices {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Collections.singletonList(0);
        if (n <= 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Make a list of all the leaves (degree 1 vertices)
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n = n - leaves.size();
            List<Integer> new_leaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adjList.get(i).iterator().next();
                adjList.get(j).remove(i);
                if (adjList.get(j).size() == 1) {
                    new_leaves.add(j);
                }
            }
            leaves = new_leaves;
        }

        return leaves;
    }
}
