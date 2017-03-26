/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * IBM Uncubed coding question.
 *
 * @author Harshit
 */
public class ResolveConflictEmployeeManager {

    public static void main(String[] args) {
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//            String s;
            String s = "Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob,Katie" ;
            //while ((s = in.readLine()) != null) {
                String[] input = s.split(",");
                Map<String, String> tree = createTree(input);
                
                String emp1 = input[input.length - 2];
                String emp2 = input[input.length - 1];
                
                // Paths to top manager in heirarchy
                String[] path1 = createPathToTopManager(emp1, tree).split("<-");
                String[] path2 = createPathToTopManager(emp2, tree).split("<-");
                
                String resultingManager = "";
                
                int n = Math.max(path1.length, path2.length);
                // Loop untill no same top level managers are left and return the lowest common manager.
                for (int i = 0; i < n; i++) {
                    if (!path1[path1.length - i - 1].equals(path2[path2.length - i - 1])) {
                        break;
                    }
                    resultingManager = path1[path1.length - i - 1];
                }

                System.out.println(resultingManager);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    public static String createPathToTopManager(String emp, Map<String, String> tree) {
        StringBuilder sb = new StringBuilder();
        while (tree.containsKey(emp)) {
            sb.append(emp).append("<-");
            emp = tree.get(emp);
        }
        sb.append(emp);
        return sb.toString();
    }

    public static Map createTree(String[] input) {
        Map<String, String> tree = new HashMap<>();
        for (int i = 0; i < input.length - 2; i++) {
            String[] relation = input[i].split("->");
            tree.put(relation[1], relation[0]);
        }
        return tree;
    }
}
