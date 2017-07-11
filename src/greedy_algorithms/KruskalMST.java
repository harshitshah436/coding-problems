package greedy_algorithms;

import java.util.Arrays;

/**
 *
 * Ref:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 *
 * @author Harshit
 */
public class KruskalMST {

    /**
     * Method to find minimum spanning tree for the given graph
     *
     * @param graph
     */
    private static void KruskalMST(Graph graph) {

        // These variables are declared to remove redundant code and 
        // to make code more readable.
        int V = graph.V;
        Graph.Edge[] edges = graph.edges;

        Graph.Edge[] result = new Graph.Edge[V]; // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i;  // An index variable, used for sorted edges
        for (i = 0; i < V; i++) {
            result[i] = graph.new Edge();  // To get an instance of inner non-static class
        }

        // Step 1: Sort all the edges in non-decreasing/ascending order of their
        // weight. If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edges);

        // Allocate memory for creating V subsets
        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
        }

        // Initialize V subsets with single elements
        for (i = 0; i < V; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0; // Index used to pick next edge

        while (e < V - 1) { // Number of edges is equal V-1 (MST is created)
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Graph.Edge next_edge = edges[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == "
                    + result[i].weight);
        }
    }

    /**
     * A utility function to find set of an element i (uses path compression
     * technique).
     *
     * @param subsets
     * @param i
     * @return
     */
    private static int find(Subset[] subsets, int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    /**
     * A function that does union of two sets of x and y (uses union by rank)
     *
     * @param subsets
     * @param x
     * @param y
     */
    private static void Union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree. If ranks are 
        // same, then make one as root and increment its rank by one.
        // (Union by Rank).
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // A class to represent union-find
    private static class Subset {

        int parent, rank;
    }

    // A class to represent Graph and edges
    private static class Graph {

        int V; // no of vertices
        int E; // no of edges
        Edge[] edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;

            edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge();
            }
        }

        class Edge implements Comparable<Edge> {

            int src, dest, weight;

            @Override
            public int compareTo(Edge edge) {
                return this.weight - edge.weight;
            }

        }
    }

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */

        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        //add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        KruskalMST(graph);
    }
}
