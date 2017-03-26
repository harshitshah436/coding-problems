package data_structures;

public class BinaryTree {

    public Node root;

    public BinaryTree() {
        root = null;
    }

    // Iterative approach
    public void insert(int i) {
        if (root == null)
            root = new Node(i);
        else {
            Node current = root;
            while (true) {
                Node parent = current;
                if (i < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(i);
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(i);
                        break;
                    }
                }
            }
        }
    }

    // Recursive insert
    public Node insertRecursively(Node root, int i) {
        if (root == null)
            root = new Node(i);
        else {
            if (i < root.data) {
                root.left = insertRecursively(root.left, i);
            } else {
                root.right = insertRecursively(root.right, i);
            }
        }
        return root;
    }

    static class BinaryTreeTest {
        public static void main(String[] args) {
            BinaryTree bt = new BinaryTree();
            bt.insert(50);
            bt.insert(60);
        }
    }

}
