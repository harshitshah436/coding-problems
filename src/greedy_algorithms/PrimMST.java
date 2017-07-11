package greedy_algorithms;

/**
 * Prim's algorithm for finding MST. Ref:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 *
 * @author Harshit
 */
public class PrimMST {

    // Number of vertices in the graph
    private static final int V = 5;

    /**
     * Function to construct and print MST for a graph represented using
     * adjacency matrix representation.
     *
     * @param graph
     */
    private void primMST(int[][] graph) {

        // Array to store constructed MST
        int[] parent = new int[V];

        // Key values used to pick minimum weight edge in cut
        int[] key = new int[V];

        // To represent set of vertices not yet included in MST
        boolean[] mstSet = new boolean[V];  // all set to false by default

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0; // Make key 0 so that this vertex is picked as first vertex

        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int i = 0; i < V - 1; i++) {

            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // print the constructed MST
        printPrimMST(parent, graph);
    }

    /**
     * Method to find the vertex with minimum key value, from the set of
     * vertices not yet included in MST.
     *
     * @param key
     * @param mstSet
     * @return
     */
    private int minKey(int[] key, boolean[] mstSet) {
        int minKeyIndex = -1, minKeyValue = Integer.MAX_VALUE;
        for (int v = 0; v < V; v++) {
            if (mstSet[v] == false && key[v] < minKeyValue) {
                minKeyIndex = v;
                minKeyValue = key[v];
            }
        }
        return minKeyIndex;
    }

    private void printPrimMST(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        int graph[][] = new int[][]{
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}};

        PrimMST primMST = new PrimMST();
        // Print the solution
        primMST.primMST(graph);
    }
}
