/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Harshit
 */
class Node {

    Node left, right;
    int data;

    public Node(int item) {
        data = item;
    }

}

class BinaryTreeMirror {

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
        BinaryTreeMirror tree = new BinaryTreeMirror();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

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
