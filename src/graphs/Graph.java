package graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Graph implementation and graph traversal.
 * 
 * @author Harshit
 */
public class Graph {

    int V; // no of vertices
    LinkedList<Integer>[] adj; //adjecency lists

    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    /**
     * Traverse graph from the given start node using BFS technique.
     *
     * Iteratively using queue.
     *
     * @param start
     */
    private void BFS(int start) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);  // enqueue
        while (!queue.isEmpty()) {
            int u = queue.remove(); // dequeue
            visit(u, visited);
            for (int v : adj[u]) { // get all adjecents for current V
                if (!visited[v]) {
                    queue.add(v);
                }
            }
        }
    }

    /**
     * Traverse graph from the given start node using DFS technique.
     *
     * Iteratively using stack data structure or
     * recursively using internal stack memory.
     *
     * @param start
     */
    private void DFS(int start) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            visit(u, visited);
            for (int v : adj[u]) {
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }
    }

    /**
     * DFS using internal memory stack
     *
     * @param start
     */
    private void DFSRecursive(int start) {
        boolean[] visited = new boolean[V];
        DFSUsingStackMemory(start, visited);
    }

    private void DFSUsingStackMemory(int u, boolean[] visited) {
        visit(u, visited);
        for (int v : adj[u]) {
            if (!visited[v]) {
                DFSUsingStackMemory(v, visited);
            }
        }
    }
    
    private void visit(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);

        System.out.println("Following is Breadth First Search traversal "
                + "(starting from vertex 2)");

        g.BFS(2);

        System.out.println("");
        System.out.println("Following is Depth First Search traversal "
                + "(starting from vertex 2)");

        g.DFS(2);

        System.out.println("");
        System.out.println("Following is Depth First Search traversal Recursively/UsingInternalStackMemory "
                + "(starting from vertex 2)");

        g.DFSRecursive(2);
    }
}
