package advance_data_structures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * LRUCache.java
 */
/**
 * For any cache algorithms, you should think to use queue.
 *
 * Here, LRU (Least Recently Used) cache problem involves two main operations.
 * 1) get a value (page frame) for given key 2) Insert a value for the key. If
 * cache is full remove least used value (page frame.)
 *
 * We can think of two data structures for two operations. 1) HashMap to get a
 * value in O(1) 2) Insert a value and also remove a value in O(1). Doubly
 * LinkedList.
 *
 * Ref: http://androidsrc.net/lru-cache-java-implementation/
 *
 * another ref: http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 *
 * @author Harshit
 */
public class LRUCache {

    int capacity, currentSize;
    Node head, tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity; // Max cache size
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            moveNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (currentSize == capacity) {
                cache.remove(tail.key);
                removeTailNode();
            } else {
                currentSize++;
            }
            addNodeToHead(node);
            cache.put(node.key, node);
        } else {
            node.value = value;
            moveNodeToHead(node);
        }
    }

    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addNodeToHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void removeTailNode() {
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
    }

    /* Doubly Linked List Node */
    private class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void printLRUCache() {
        Node node = head;
        while (node != null) {
            System.out.print(
                    "[Key: " + node.key + " Value: " + node.value + "] ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        for (int i = 5; i < 11; i++) {
            lru.put(i, i * 2);
        }
        System.out.println("LRU Cache after creation");
        lru.printLRUCache();
        lru.get(7);
        System.out.println("LRU Cache after retrieving 7");
        lru.printLRUCache();
        lru.put(11, 11 * 2);
        System.out.println(
                "LRU cache on adding one more item. It will replace last one");
        lru.printLRUCache();
    }

    /**
     * LRU Cache using Java's built-in LinkedHashMap. (Lazy implementation)
     */
    @SuppressWarnings({ "unused", "serial" })
    private class LRUCache2 {
        private LinkedHashMap<Integer, Integer> lru;

        public LRUCache2(int capacity) {
            lru = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(
                        Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return lru.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            lru.put(key, value);
        }
    }

    /**
     * LRU Cache using Java's built-in LinkedHashMap. Directly extends the
     * class.
     *
     * Ref: http://chriswu.me/blog/a-lru-cache-in-10-lines-of-java/
     *
     * @param <K>
     * @param <V>
     */
    @SuppressWarnings({ "unused", "serial" })
    private class LRUCache3<K, V> extends LinkedHashMap<K, V> {

        int capacity;

        public LRUCache3(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Entry<K, V> eldest) {
            return super.removeEldestEntry(eldest);
        }
    }
}
