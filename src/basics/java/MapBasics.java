package basics.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * Iterating hashmap, Iterating only values, Iterating only keys.
 *
 * @author Harshit
 */
public class MapBasics {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Inserting key, value pair into a map.
        map.put("Harshit", 11);
        map.put("Alice", 25);
        map.put("Bob", 5);
        map.put("Charlie", 9);

        // Get a value by key
        int value = map.get("Bob");
        System.out.println(value);

        // Check if a key exists
        boolean check = map.containsKey("Bob1");
        System.out.println(check);

        // Check if a value exists
        check = map.containsValue(11);
        System.out.println(check);

        // Get a collection of values;
        // map.values() returns collection view
        for (int i : map.values()) {
            System.out.println(i);
        }
        System.out.println("----------------------------");
        // OR to get into a list and perform sort
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("----------------------------");

        // Get a Set of keys;
        for (String str : map.keySet()) {
            System.out.println(str);
        }
        // or
        HashSet<String> set = new HashSet<>(map.keySet());
        System.out.println("----------------------------");

        // Iterate hashmap using map.entrySet() method.
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
