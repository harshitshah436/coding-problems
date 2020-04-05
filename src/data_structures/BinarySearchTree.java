package data_structures;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Iterative insert for BST
    public void insertBST(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node parent = null, current = root;
        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (data < parent.data) {
            parent.left = new Node(data);
        } else {
            parent.right = new Node(data);
        }
    }

    // Recursive insert
    public Node insertRecursively(Node root, int i) {
        if (root == null) {
            root = new Node(i);
        } else if (i < root.data) {
            root.left = insertRecursively(root.left, i);
        } else {
            root.right = insertRecursively(root.right, i);
        }
        return root;
    }

    static class BinarySearchTreeTest {

        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree();
            bst.insertBST(50);
            bst.insertBST(60);
        }
    }
}

class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int i) {
        left = null;
        right = null;
        data = i;
    }
}

