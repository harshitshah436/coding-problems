/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import data_structures.LinkedList;
import java.util.ArrayList;

/**
 *
 * Ref:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 *
 * @author Harshit
 */
public class ShortestPathDijkstras {

    private void dijkstras(int[][] graph, int src) {
        int V = graph.length;

        // System.out.println(V);
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        boolean[] verticesAlreadyInPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            int u = minDistanceVertex(dist, verticesAlreadyInPath);

            verticesAlreadyInPath[u] = true;

            // Update distances of adjecent vertices of the current minVertex
            for (int v = 0; v < V; v++) {
                if (dist[u] + graph[u][v] < dist[v] && !verticesAlreadyInPath[v]
                        && dist[u] != Integer.MAX_VALUE && graph[u][v] != 0) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);

    }

    /**
     * return index of the vertex which has shortest distance and not yet
     * included in the shortest path.
     *
     * @param dist
     * @param verticesAlreadyInPath
     * @return
     */
    private int minDistanceVertex(int[] dist, boolean[] verticesAlreadyInPath) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= min && !verticesAlreadyInPath[i]) {
                min = dist[i];
                min_index = i;
            }
        }

        return min_index;
    }

    public void printSolution(int dist[]) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {

        // Adjecency Matrix representation
        int graph[][] = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        ShortestPathDijkstras sp = new ShortestPathDijkstras();
        sp.dijkstras(graph, 0);

        // Shortest path from vertex 0 to vertex 6
        sp.dijkstrasToSpecifictTarget(graph, 0, 6);
    }

    private void dijkstrasToSpecifictTarget(int[][] graph, int src, int target) {
        int V = graph.length;

        ArrayList<Integer> path = new ArrayList<>();
        
        // System.out.println(V);
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        boolean[] verticesAlreadyInPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            int u = minDistanceVertex(dist, verticesAlreadyInPath);

            verticesAlreadyInPath[u] = true;
            path.add(u);

            // Update distances of adjecent vertices of the current minVertex
            for (int v = 0; v < V; v++) {
                if (dist[u] + graph[u][v] < dist[v] && !verticesAlreadyInPath[v]
                        && dist[u] != Integer.MAX_VALUE && graph[u][v] != 0) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }

            if (u == target) {
                System.out.println("");
                System.out.println("Minimum distance from " + src + " to " + target + " : " + dist[u]);
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Path: ");
        for(int vertex : path) {
            sb.append(vertex + " -> ");
        }
        sb.delete(sb.length()-4, sb.length());
        
        System.out.println(sb.toString());
    }
}
