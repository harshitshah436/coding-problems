package graphs;

import java.util.*;

/*
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
/**
 *
 * @author Harshit
 */
public class EvaluateDivision {

    Map<String, Node> graph = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        for (int i = 0; i < equations.length; i++) {
            Node A, B;
            if (graph.containsKey(equations[i][0])) {
                A = graph.get(equations[i][0]);
            } else {
                A = new Node(equations[i][0]);
                graph.put(equations[i][0], A);
            }
            if (graph.containsKey(equations[i][1])) {
                B = graph.get(equations[i][1]);
            } else {
                B = new Node(equations[i][1]);
                graph.put(equations[i][1], B);
            }
            A.AddLinkedNodes(B, values[i]);
            B.AddLinkedNodes(A, 1 / values[i]);
        }

        double[] res = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) {
                res[i] = -1;
            } else if (queries[i][0].equals(queries[i][1])) {
                res[i] = 1;
            } else {
                Set<String> unVisited = new HashSet(graph.keySet());
                res[i] = bfs(graph.get(queries[i][0]), queries[i][1], unVisited);
                //res[i] = graph.get(queries[i][0]).linkedNodes.get(queries[i][1]);
            }
        }

        return res;
    }

    public double bfs(Node n, String target, Set<String> unVisited) {
        if (!unVisited.contains(n.name)) {
            return -1;
        } else {
            unVisited.remove(n.name);

            for (Node subN : n.linkedNodes.keySet()) {
                if (subN.name.equals(target)) {
                    return n.linkedNodes.get(subN);
                }
                double res = bfs(subN, target, unVisited);
                if (res != -1) {
                    return res * n.linkedNodes.get(subN);
                }
            }
            return -1;
        }
    }
    
    /**
     * Applying varian of Floyd-Warshall algorithm.
     * @param equations
     * @param values
     * @param queries
     * @return 
     */
    public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String src = equations[i][0], dst = equations[i][1];
            if (!graph.containsKey(src)) {
                graph.put(src, new HashMap<>());
            }
            if (!graph.containsKey(dst)) {
                graph.put(dst, new HashMap<>());
            }
            graph.get(src).put(src, 1.0);
            graph.get(dst).put(dst, 1.0);
            graph.get(src).put(dst, values[i]);
            graph.get(dst).put(src, 1 / values[i]);
        }
        for (String mid : graph.keySet()) {
            for (String src : graph.get(mid).keySet()) {
                for (String dst : graph.get(mid).keySet()) {
                    double val = graph.get(src).get(mid) * graph.get(mid).get(dst);
                    graph.get(src).put(dst, val);
                }
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (!graph.containsKey(queries[i][0])) {
                result[i] = -1;
            } else {
                result[i] = graph.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        
        double[] res = ed.calcEquation(equations, values, queries);
        for (int i = 0; i < res.length; i++) {
           System.out.print(res[i] + " "); 
        }
        
        System.out.println("");
        System.out.println("=========================");
        
        res = ed.calcEquation2(equations, values, queries);
        for (int i = 0; i < res.length; i++) {
           System.out.print(res[i] + " "); 
        }
    }
}

class Node {

    String name;
    HashMap<Node, Double> linkedNodes;

    public Node(String name) {
        this.name = name;
        linkedNodes = new HashMap<>();
    }

    public void AddLinkedNodes(Node node, double value) {
        linkedNodes.put(node, value);
    }
}
