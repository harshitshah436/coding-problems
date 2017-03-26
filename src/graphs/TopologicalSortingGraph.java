/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * Ref: http://www.geeksforgeeks.org/topological-sorting/ Implemented this
 * method using DFS
 *
 * other approach:
 * http://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 * calculating indegree based Kanh's algorithm.
 *
 * @author Harshit
 */
public class TopologicalSortingGraph {

    private final int V;
    private final LinkedList<Integer>[] adj;

    public TopologicalSortingGraph(int no_of_vertices) {
        V = no_of_vertices;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack stack) {
        visited[v] = true;

        Iterator<Integer> it = adj[v].iterator();

        while (it.hasNext()) {
            int i = it.next();
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        stack.push(v);
    }

    private void topologicalSort() {
        Stack<Integer> stack = new Stack();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        TopologicalSortingGraph g = new TopologicalSortingGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological sort of the given graph is: ");
        g.topologicalSort();
    }
}
