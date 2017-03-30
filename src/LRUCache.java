
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
 * cache is full remove lease used value (page frame.)
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

    int capacity; // Max cache size
    DoublyLinkedListNode start;
    DoublyLinkedListNode end;
    int currentSize;

    Map<Integer, DoublyLinkedListNode> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
    }

    private void set(int key, int value) {

        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            node.value = value;
            bringNodeToFront(node);
        } else {
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            if (currentSize < capacity) {
                addNodeToFront(node);
                currentSize++;
            } else {
                nodeMap.remove(end.key);
                removeLastQueueNode();
                addNodeToFront(node);
            }
            nodeMap.put(node.key, node);
        }
    }

    private int get(int key) {
        if (nodeMap.containsKey(key)) {
            DoublyLinkedListNode node = nodeMap.get(key);
            bringNodeToFront(node);
            return node.value;
        }
        return -1;
    }

    private void bringNodeToFront(DoublyLinkedListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            start = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }

        addNodeToFront(node);
    }

    private void addNodeToFront(DoublyLinkedListNode node) {
        node.next = start;
        node.prev = null;
        if (start != null) {
            start.prev = node;
        }
        start = node;
        if (end == null) {
            end = node;
        }
    }

    private void removeLastQueueNode() {
        end = end.prev;
        if (end != null) {
            end.next = null;
        } else {
            start = null;
        }
    }

    private class DoublyLinkedListNode {

        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        int key;
        int value;

        public DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void printLRUCache() {
        DoublyLinkedListNode node = start;
        while (node != null) {
            System.out.print("Key: " + node.key + " Value: "
                    + node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(5);
        for (int i = 5; i < 11; i++) {
            lru.set(i, i * 2);
        }
        System.out.println("LRU Cache after creation");
        lru.printLRUCache();
        lru.get(7);
        System.out.println("LRU Cache after retrieving 7");
        lru.printLRUCache();
        lru.set(11, 11 * 2);
        System.out.println("LRU cache on adding one more item. It will replace last one");
        lru.printLRUCache();
    }

    /**
     * LRU Cache using Java's built-in LinkedHashMap.
     *
     * Ref: http://chriswu.me/blog/a-lru-cache-in-10-lines-of-java/
     *
     * @param <K>
     * @param <V>
     */
    private class LRUCache2<K, V> extends LinkedHashMap<K, V> {

        int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Entry<K, V> eldest) {
            return super.removeEldestEntry(eldest);
        }
    }
}
