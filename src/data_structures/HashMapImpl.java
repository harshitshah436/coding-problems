/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 * Reference:
 * http://codereview.stackexchange.com/questions/62049/simple-implementation-of-hashmap
 *
 * Changed the function to calculate hash for working better with negative
 * numbers as mentioned in Reference.
 *
 * @author Harshit
 */
public class HashMapImpl {

    static class HashMap {

        int SIZE_OF_TABLE = 128;
        HashEntry[] table;

        HashMap() {
            table = new HashEntry[SIZE_OF_TABLE];
            for (int i = 0; i < SIZE_OF_TABLE; i++) {
                table[i] = null;
            }
        }

        public void put(int key, int value) {
            int index = hashCodeNew(key);
            HashEntry hashEntry = new HashEntry(key, value);
            if (table[index] == null) {
                table[index] = hashEntry;
            } else {
                HashEntry runner = table[index];
                while (runner.next != null) {
                    if (runner.key == hashEntry.key) {
                        runner.value = hashEntry.value;
                        break;
                    } else {
                        runner = runner.next;
                    }
                }
                if (runner.next == null) {
                    if (runner.key == hashEntry.key) {
                        runner.value = hashEntry.value;
                    } else {
                        runner.next = hashEntry;
                    }
                }
            }

        }

        public int get(int key) {
            int index = hashCodeNew(key);
            if (table[index] == null) {
                return -1;
            } else {
                HashEntry runner = table[index];
                if (runner.key == key) {
                    return runner.value;
                }
                while (runner.next != null) {
                    if (runner.key == key) {
                        return runner.value;
                    }
                }

                if (runner.key == key) {
                    return runner.value;
                }
                return -1;
            }
        }

        public int hashCodeNew(int h) {
            return (h & Integer.MAX_VALUE) % SIZE_OF_TABLE;
        }
    }

    static class HashEntry {

        int key;
        int value;
        HashEntry next = null;

        HashEntry() {
        }

        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(10, 20);
        hashMap.put(20, 11);
        hashMap.put(21, 1);
        hashMap.put(20, 10);

        System.out.println("Hello: " + hashMap.get(21));
    }
}
