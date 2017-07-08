package graphs;

import java.util.LinkedList;

/**
 * Always use DFS to detect cycle in a directed graph.
 *
 * Ref: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *
 * @author Harshit
 */
public class DetectCycleInGraph {

    //-----------------Graph creation START-----------------
    int V;
    LinkedList<Integer>[] adjList;

    public DetectCycleInGraph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    //-----------------Graph creation END-----------------
    public boolean isCycleInGraph() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        // For each vertex, check if a cycle exist using DFS.
        for (int u = 0; u < V; u++) {
            if (isCycleInGraph(u, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCycleInGraph(int u, boolean[] visited, boolean[] recursionStack) {
        if (!visited[u]) {

            // Mark the current node as visited and part of recursion stack
            visited[u] = true;
            recursionStack[u] = true;

            // Recur for all the vertices adjacent to this vertex
            for (int v : adjList[u]) {
                System.out.println("u: " + u + " v: " + v);
                if (!visited[v] && isCycleInGraph(v, visited, recursionStack)) {
                    return true;
                } else if (recursionStack[v]) {
                    return true;
                }
            }
        }
        recursionStack[u] = false; // remove vertex from recursion stack
        return false;
    }

    public static void main(String[] agrs) {
        DetectCycleInGraph g = new DetectCycleInGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.isCycleInGraph()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
