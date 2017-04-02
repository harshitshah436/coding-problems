
import java.util.HashMap;

/**
 * Ref:
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 * @author Harshit
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String str) {
        HashMap<Character, TrieNode> current = root.children;
        for (char c : str.toCharArray()) {
            TrieNode temp;
            if (current.containsKey(c)) {
                temp = current.get(c);
            } else {
                temp = new TrieNode(c);
                current.put(c, temp);
            }
            temp.count++;
            current = temp.children;
        }
    }

    public boolean serch(String str) {
        HashMap<Character, TrieNode> current = root.children;
        TrieNode temp;
        for (char c : str.toCharArray()) {
            if (current.containsKey(c)) {
                temp = current.get(c);
                current = temp.children;
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {

    char data;
    int count;
    HashMap<Character, TrieNode> children;

    public TrieNode(char c) {
        count = 0;
        data = c;
        children = new HashMap<>();
    }
}

/**
 * Improved performance of trie using array for storing characters. Only 26
 * elements needed.
 */
class Trie1 {

    private final TrieNode1 root;

    public Trie1() {
        root = new TrieNode1(' ');
    }

    public void insert(String str) {
        TrieNode1[] current = root.children;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            TrieNode1 temp;
            if (current[index] != null) {
                temp = current[index];
            } else {
                temp = new TrieNode1(c);
                current[index] = temp;
            }
            temp.count++;
            current = temp.children;
        }
    }

    public boolean search(String str) {
        TrieNode1[] current = root.children;
        TrieNode1 temp;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (current[index] != null) {
                temp = current[index];
                current = temp.children;
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode1 {

    char data;
    int count;
    TrieNode1[] children;

    public TrieNode1(char c) {
        count = 0;
        data = c;
        children = new TrieNode1[26];
    }
}
