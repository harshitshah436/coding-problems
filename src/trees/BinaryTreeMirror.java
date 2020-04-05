package trees;

/**
 *
 * @author Harshit
 */
public class BinaryTreeMirror {

    static Node root;

    private Node mirror(Node root) {
        if (root == null) {
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        BinaryTreeMirror tree = new BinaryTreeMirror();

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder(root);
        System.out.println("");

        tree.mirror(root);

        /* print inorder traversal of the mirror tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int item) {
        data = item;
    }
}
