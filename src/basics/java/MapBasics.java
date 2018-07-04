package basics.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

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

        // Get a value by key or get a default value
        value = map.getOrDefault("Hello", 0);
        System.out.println(value);

        // Check if a key exists
        boolean check = map.containsKey("Bob1");
        System.out.println(check);

        // Check if a value exists
        check = map.containsValue(11);
        System.out.println(check);

        // To clear map or any collection
        map.clear();

        map.put("Harshit", 11);
        map.put("Alice", 25);
        map.put("Bob", 5);

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

        // Use of TreeMap (Natural order sorting by key)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Harshit");
        treeMap.put(2, "Naisargi");
        treeMap.put(4, "Bob");
        treeMap.put(1, "Charlie");
        System.out.println(treeMap);

        // Sort TreeMap by Descending order of key
        NavigableMap<Integer, String> nMap = treeMap.descendingMap();
        System.out.println(nMap);
        for (String str : nMap.values()) {
            System.out.println(str);
        }
    }
}
